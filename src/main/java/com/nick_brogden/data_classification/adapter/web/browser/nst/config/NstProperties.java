package com.nick_brogden.data_classification.adapter.web.browser.nst.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "nst-browser")
public class NstProperties {

    private String apiKey;
    private boolean headless;
    private int port;
    private String host;
    private String url;
    private String groupId;

}
