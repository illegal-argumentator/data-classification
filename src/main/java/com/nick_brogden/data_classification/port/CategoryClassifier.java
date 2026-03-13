package com.nick_brogden.data_classification.port;

import com.nick_brogden.data_classification.domain.site.type.Category;

import java.util.Set;

public interface CategoryClassifier {

    Set<Category> classify(String content);

}
