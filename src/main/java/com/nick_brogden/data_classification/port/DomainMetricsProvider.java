package com.nick_brogden.data_classification.port;

import com.nick_brogden.data_classification.domain.site.model.Metric;

import java.util.Set;

public interface DomainMetricsProvider {

    Set<Metric> provide(String domain);

}
