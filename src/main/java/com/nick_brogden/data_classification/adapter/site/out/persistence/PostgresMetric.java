package com.nick_brogden.data_classification.adapter.site.out.persistence;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class PostgresMetric {

    private String domain;
    private int organicKeywords;
    private int organicTraffic;

}
