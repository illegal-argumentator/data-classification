package com.nick_brogden.data_classification.application.classification;

import com.nick_brogden.data_classification.application.site.SiteDataRetriever;
import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.domain.site.model.SiteData;
import com.nick_brogden.data_classification.domain.site.type.Status;
import com.nick_brogden.data_classification.port.SiteCommandPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClassificationUseCase {

    private final Executor executor;
    private final SiteCommandPort commandPort;
    private final SiteDataRetriever dataRetriever;

    @Async
    public void process(String email, List<String> domains) {
        commandPort.saveAll(domains.stream().map(domain -> Site.builder().domain(domain).status(Status.PENDING).build()).toList());
        List<Site> sites = processDomainsConcurrently(domains);
        // TODO convert sites to csv
        // TODO send data to email
    }

    private List<Site> processDomainsConcurrently(List<String> domains) {
        List<CompletableFuture<Site>> futures = domains.stream()
                .map(domain -> CompletableFuture.supplyAsync(() -> {
                            SiteData siteData = buildSiteData(domain);
                            return commandPort.update(domain,
                                    Site.builder()
                                            .categories(siteData.categories())
                                            .content(siteData.content())
                                            .status(Status.COMPLETED)
                                            .build());
                        }, executor)
                        .exceptionally(ex -> {
                            log.warn("Couldn't execute {}", domain, ex);
                            return null;
                        })).toList();

        return waitForTasks(futures);
    }

    private SiteData buildSiteData(String domain) {
        String content = dataRetriever.retrieveContent(domain);
//        List<Category> categories = dataRetriever.retrieveCategories(domain, content);
//        List<Metric> metrics = dataRetriever.retrieveMetrics(domain);
        return new SiteData(content, null, null);
    }

    private List<Site> waitForTasks(List<CompletableFuture<Site>> futures) {
        return futures.stream()
                .map(CompletableFuture::join)
                .filter(Objects::nonNull)
                .toList();
    }
}
