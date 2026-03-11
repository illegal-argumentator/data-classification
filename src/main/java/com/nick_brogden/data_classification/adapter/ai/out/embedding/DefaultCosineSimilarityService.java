package com.nick_brogden.data_classification.adapter.ai.out.embedding;

import org.springframework.stereotype.Service;

@Service
public class DefaultCosineSimilarityService implements CosineSimilarityService {

    @Override
    public double calcSimilarity(float[] vectorA, float[] vectorB) {
        if (vectorA.length != vectorB.length) {
            throw new IllegalArgumentException("Vectors must be same length.");
        }

        double dot = 0.0, normA = 0.0, normB = 0.0;

        for (int i = 0; i < vectorA.length; i++) {
            dot += vectorA[i] * vectorB[i];
            normA += vectorA[i] * vectorA[i];
            normB += vectorB[i] * vectorB[i];
        }

        return dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }

}
