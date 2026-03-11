package com.nick_brogden.data_classification.port.site;

public interface SiteQueryPort {

    boolean existsByDomain(String domain);

}
