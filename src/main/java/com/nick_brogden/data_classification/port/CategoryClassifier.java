package com.nick_brogden.data_classification.port;

import com.nick_brogden.data_classification.domain.site.type.Category;

import java.util.List;

public interface CategoryClassifier {

    List<Category> classify(String content);

}
