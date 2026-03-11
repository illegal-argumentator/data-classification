package com.nick_brogden.data_classification.port.site;

import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.domain.site.model.SiteData;

public interface SiteCommandPort {

    Site ensureExists(String domain, String groupId);

    Site update(String domain, Site site);

    Site complete(String domain, SiteData data);

}
