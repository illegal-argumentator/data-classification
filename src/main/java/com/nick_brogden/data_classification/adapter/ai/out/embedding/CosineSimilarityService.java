package com.nick_brogden.data_classification.adapter.ai.out.embedding;

public interface CosineSimilarityService {

    double calcSimilarity(float[] vectorA, float[] vectorB);

}
