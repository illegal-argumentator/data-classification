package com.nick_brogden.data_classification.domain.site.model;

import com.nick_brogden.data_classification.domain.site.type.Category;

public record Metric(String content, Category category, Object metrics) {
}
