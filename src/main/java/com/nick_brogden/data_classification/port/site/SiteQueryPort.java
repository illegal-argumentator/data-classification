package com.nick_brogden.data_classification.port.site;

import com.nick_brogden.data_classification.domain.site.model.Site;

import java.util.List;

public interface SiteQueryPort {

    List<Site> retrieveAllCompletedByGroup(String groupId);

}
