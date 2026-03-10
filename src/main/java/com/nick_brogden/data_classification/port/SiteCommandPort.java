package com.nick_brogden.data_classification.port;

import com.nick_brogden.data_classification.domain.site.model.Site;

public interface SiteCommandPort {

    Site ensureExists(String domain);
    Site update(String domain, Site site);

}
