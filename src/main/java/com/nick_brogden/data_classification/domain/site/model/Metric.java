package com.nick_brogden.data_classification.domain.site.model;

public record Metric(
        String domain,
        int organicKeywords,
        int organicTraffic
) {
}

