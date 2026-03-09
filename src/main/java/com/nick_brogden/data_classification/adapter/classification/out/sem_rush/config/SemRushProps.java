package com.nick_brogden.data_classification.adapter.classification.out.sem_rush.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "sem-rush")
public class SemRushProps {

    private String url;
    private String apiKey;
    private String[] metrics;
    private String type;
    private String database;

}
