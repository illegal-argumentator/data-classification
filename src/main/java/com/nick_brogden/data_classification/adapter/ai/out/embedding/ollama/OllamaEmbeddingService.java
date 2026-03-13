package com.nick_brogden.data_classification.adapter.ai.out.embedding.ollama;

import com.nick_brogden.data_classification.adapter.ai.out.embedding.EmbeddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OllamaEmbeddingService implements EmbeddingService {

    private final OllamaEmbeddingModel embeddingModel;

    private static final int MAX_CHUNK_LENGTH = 500;
    private static final int MAX_CONTENT_LENGTH = 4_000;

    @Override
    public float[] call(String payload) {
        return processChunks(trimPayload(payload));
    }

    private float[] processChunks(String payload) {
        if (payload == null || payload.isEmpty()) {
            return new float[0];
        }

        List<float[]> vectors = new ArrayList<>();

        for (String chunk : splitIntoChunks(payload)) {
            EmbeddingRequest request = new EmbeddingRequest(List.of(chunk), null);
            EmbeddingResponse response = embeddingModel.call(request);
            vectors.add(response.getResult().getOutput());
        }

        return meanPoolVectors(vectors);
    }

    private List<String> splitIntoChunks(String text) {
        List<String> chunks = new ArrayList<>();
        for (int i = 0; i < text.length(); i += MAX_CHUNK_LENGTH) {
            chunks.add(text.substring(i, Math.min(i + MAX_CHUNK_LENGTH, text.length())));
        }
        return chunks;
    }

    private float[] meanPoolVectors(List<float[]> vectors) {
        if (vectors.isEmpty()) return new float[0];

        int length = vectors.getFirst().length;
        float[] pooled = new float[length];

        for (float[] vector : vectors) {
            for (int i = 0; i < length; i++) {
                pooled[i] += vector[i];
            }
        }

        for (int i = 0; i < length; i++) {
            pooled[i] /= vectors.size();
        }

        return pooled;
    }

    private String trimPayload(String payload) {
        if (payload == null) return null;

        String trimmed = payload.trim();
        if (trimmed.length() <= MAX_CONTENT_LENGTH) return trimmed;

        int middle = trimmed.length() / 2;
        int halfLength = MAX_CONTENT_LENGTH / 2;
        int start = Math.max(0, middle - halfLength);
        int end = Math.min(trimmed.length(), middle + halfLength);

        return trimmed.substring(start, end);
    }
}