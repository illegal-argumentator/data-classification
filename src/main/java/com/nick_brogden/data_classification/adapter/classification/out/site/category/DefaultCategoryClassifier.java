package com.nick_brogden.data_classification.adapter.classification.out.site.category;

import com.nick_brogden.data_classification.domain.site.type.Category;
import com.nick_brogden.data_classification.port.CategoryClassifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultCategoryClassifier implements CategoryClassifier {

    @Override
    public List<Category> classify(String content) {
        return null;
    }

}
