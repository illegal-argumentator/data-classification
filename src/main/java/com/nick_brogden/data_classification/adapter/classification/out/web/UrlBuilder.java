package com.nick_brogden.data_classification.adapter.classification.out.web;

import org.springframework.web.util.UriComponentsBuilder;

public final class UrlBuilder {

    private static final String HTTPS_PROTOCOL = "https";

    public static String buildByDomain(String domain) {
        return UriComponentsBuilder.newInstance()
                .scheme(HTTPS_PROTOCOL)
                .host(domain)
                .build()
                .toUriString();
    }
}
