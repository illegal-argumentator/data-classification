package com.nick_brogden.data_classification.domain.site.model;

import com.nick_brogden.data_classification.domain.site.type.Category;

import java.util.Set;

public record SiteData(String content, Set<Category> categories, Set<Metric> metrics) {
}
