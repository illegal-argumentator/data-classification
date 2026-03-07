package com.nick_brogden.data_classification.port;

public interface SiteQueryPort {

    boolean existsByDomain(String domain);

}
