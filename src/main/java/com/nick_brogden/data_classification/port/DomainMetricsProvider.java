package com.nick_brogden.data_classification.port;

import com.nick_brogden.data_classification.domain.site.model.Metric;

import java.util.List;

public interface DomainMetricsProvider {

    List<Metric> provide(String domain);

}
