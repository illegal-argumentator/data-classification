package com.nick_brogden.data_classification.adapter.classification.out.site.category;

import com.nick_brogden.data_classification.adapter.classification.out.embedding.EmbeddingService;
import com.nick_brogden.data_classification.domain.site.type.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmbeddedCategoryService {

    private final EmbeddingService embeddingService;

    @Cacheable("categories")
    public Map<Category, float[]> get() {
        HashMap<Category, float[]> categoryEmbeddings = new HashMap<>();

        for (Category category : Category.values()) {
            float[] embedding = embeddingService.call(category.getDisplayName());
            categoryEmbeddings.put(category, embedding);
        }

        return categoryEmbeddings;
    }

}
