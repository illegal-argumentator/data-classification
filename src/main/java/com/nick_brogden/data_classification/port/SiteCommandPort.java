package com.nick_brogden.data_classification.port;

import com.nick_brogden.data_classification.domain.site.model.Site;

import java.util.List;

public interface SiteCommandPort {

    void save(Site site);

    void saveAll(List<Site> sites);

    Site update(String domain, Site site);

}
