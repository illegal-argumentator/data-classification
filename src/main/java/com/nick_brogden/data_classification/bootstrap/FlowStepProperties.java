package com.nick_brogden.data_classification.bootstrap;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "flow-step")
public class FlowStepProperties {

    private DisabilityProperty contentRetriever;
    private DisabilityProperty categorization;
    private DisabilityProperty notifier;
    private DisabilityProperty metrics;

    @Getter
    @Setter
    public static class DisabilityProperty {

        boolean disabled;

    }

}
