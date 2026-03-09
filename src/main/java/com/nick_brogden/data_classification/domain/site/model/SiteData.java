package com.nick_brogden.data_classification.domain.site.model;

import com.nick_brogden.data_classification.domain.site.type.Category;

import java.util.List;

public record SiteData(String content, List<Category> categories, List<Metric> metrics) {
}
