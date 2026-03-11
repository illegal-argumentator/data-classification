package com.nick_brogden.data_classification.adapter.sem_rush.out.mapper;

import com.nick_brogden.data_classification.domain.site.model.Metric;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.Map;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MetricMapper {

    public static Metric toMetric(Map<String, String> row) {
        String domain = row.get("domain");

        int organicKeywords = Integer.parseInt(
                row.getOrDefault("organicKeywords", "0")
        );

        int organicTraffic = Integer.parseInt(
                row.getOrDefault("organicTraffic", "0")
        );

        return new Metric(
                domain,
                organicKeywords,
                organicTraffic
        );
    }

}
