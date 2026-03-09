package com.nick_brogden.data_classification.application.site;

import com.nick_brogden.data_classification.domain.site.model.Metric;
import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.domain.site.type.Category;
import com.nick_brogden.data_classification.domain.site.type.Status;
import com.nick_brogden.data_classification.port.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Supplier;

@Slf4j
@Service
@RequiredArgsConstructor
public class SiteUseCase implements SiteDataRetriever {

    private final SiteCommandPort commandPort;
    private final DomainContentRetriever contentRetriever;
    private final DomainMetricsProvider metricsProvider;
    private final CategoryClassifier categoryClassifier;

    @Override
    public String retrieveContent(String domain) {
        log.info("Started retrieving content on {}.", domain);
        Site updateSite = commandPort.update(domain, Site.builder().status(Status.CONTENT_RETRIEVE).build());
        return getOnFail(updateSite, () -> contentRetriever.retrieve(domain));
    }

    @Override
    public List<Category> retrieveCategories(String domain, String content) {
        log.info("Started retrieving categories on {}.", domain);
        Site updateSite = commandPort.update(domain, Site.builder().status(Status.CATEGORIZATION).build());
        return getOnFail(updateSite, () -> categoryClassifier.classify(content));
    }

    @Override
    public List<Metric> retrieveMetrics(String domain) {
        log.info("Started retrieving metrics on {}.", domain);
        Site updateSite = commandPort.update(domain, Site.builder().status(Status.METRIC_POPULATION).build());
        return getOnFail(updateSite, () -> metricsProvider.provide(domain));
    }

    private <T> T getOnFail(Site site, Supplier<T> supplier) {
        try {
            return supplier.get();
        } catch (Exception e) {
            commandPort.update(site.domain(), Site.builder().status(Status.FAILED).logs(List.of("Failed on " + site.status() + " - " + e.getMessage())).build());
            throw e;
        }
    }

}
