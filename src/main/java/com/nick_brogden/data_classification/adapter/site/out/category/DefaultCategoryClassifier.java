package com.nick_brogden.data_classification.adapter.site.out.category;

import com.nick_brogden.data_classification.adapter.ai.out.embedding.CosineSimilarityService;
import com.nick_brogden.data_classification.adapter.ai.out.embedding.EmbeddingService;
import com.nick_brogden.data_classification.domain.site.type.Category;
import com.nick_brogden.data_classification.port.CategoryClassifier;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultCategoryClassifier implements CategoryClassifier {

    @Value("${embedding.treshold}")
    private float EMBEDDING_THRESHOLD;

    @Value("${embedding.limit}")
    private int EMBEDDING_LIMIT;

    private final EmbeddingService embeddingService;
    private final EmbeddedCategoryService embeddedCategoryService;
    private final CosineSimilarityService cosineSimilarityService;

    @Override
    public Set<Category> classify(String content) {
        float[] contentEmbedding = embeddingService.call(content);
        Map<Category, float[]> categoryEmbeddings = embeddedCategoryService.get();

        List<Map.Entry<Category, Double>> similarities = new ArrayList<>();
        for (Map.Entry<Category, float[]> entry : categoryEmbeddings.entrySet()) {
            double similarity = cosineSimilarityService.calcSimilarity(contentEmbedding, entry.getValue());
            if (similarity >= EMBEDDING_THRESHOLD) similarities.add(Map.entry(entry.getKey(), similarity));
        }
        similarities.sort((e1, e2) -> Double.compare(e2.getValue(), e1.getValue()));

        return similarities.stream()
                .limit(EMBEDDING_LIMIT)
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

}
