package com.nick_brogden.data_classification.application.site;

import com.nick_brogden.data_classification.domain.site.model.Metric;
import com.nick_brogden.data_classification.domain.site.type.Category;

import java.util.List;

public interface SiteDataRetriever {

    String retrieveContent(String domain);

    List<Category> retrieveCategories(String domain, String content);

    List<Metric> retrieveMetrics(String domain);

}
