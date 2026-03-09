package com.nick_brogden.data_classification.adapter.classification.out.embedding.ollama;

import com.nick_brogden.data_classification.adapter.classification.out.embedding.EmbeddingService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.embedding.EmbeddingRequest;
import org.springframework.ai.embedding.EmbeddingResponse;
import org.springframework.ai.ollama.OllamaEmbeddingModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OllamaEmbeddingService implements EmbeddingService {

    private final OllamaEmbeddingModel embeddingModel;

    @Override
    public float[] call(String payload) {
        EmbeddingRequest request = new EmbeddingRequest(List.of(payload), null);
        EmbeddingResponse response = embeddingModel.call(request);
        return response.getResult().getOutput();
    }

}
