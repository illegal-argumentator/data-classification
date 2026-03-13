package com.nick_brogden.data_classification.application.site;

import com.nick_brogden.data_classification.domain.site.model.Metric;
import com.nick_brogden.data_classification.domain.site.type.Category;

import java.util.Set;

public interface SiteDataRetriever {

    String retrieveContent(String domain);

    Set<Category> retrieveCategories(String domain, String content);

    Set<Metric> retrieveMetrics(String domain);

}
