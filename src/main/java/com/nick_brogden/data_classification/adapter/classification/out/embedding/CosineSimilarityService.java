package com.nick_brogden.data_classification.adapter.classification.out.embedding;

public interface CosineSimilarityService {

    double calcSimilarity(float[] vectorA, float[] vectorB);

}
