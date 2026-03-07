package com.nick_brogden.data_classification.application.site;

import com.nick_brogden.data_classification.domain.site.type.Category;

public interface SiteDataRetriever {

    String retrieveContent(String domain);

    Category retrieveCategory(String content);

    Object retrieveMetrics(String domain);

}
