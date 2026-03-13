package com.nick_brogden.data_classification.application.classification;

import com.nick_brogden.data_classification.application.site.SiteDataRetriever;
import com.nick_brogden.data_classification.bootstrap.FlowStepProperties;
import com.nick_brogden.data_classification.domain.group.exception.GroupAlreadyInProgressException;
import com.nick_brogden.data_classification.domain.group.model.Group;
import com.nick_brogden.data_classification.domain.group.type.ProgressState;
import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.domain.site.model.SiteData;
import com.nick_brogden.data_classification.port.MailNotifier;
import com.nick_brogden.data_classification.port.group.GroupCommandPort;
import com.nick_brogden.data_classification.port.group.GroupQueryPort;
import com.nick_brogden.data_classification.port.site.SiteCommandPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Slf4j
@Service
@RequiredArgsConstructor
public class ClassificationUseCase {

    private final Executor executor;

    private final SiteCommandPort siteCommandPort;
    private final SiteDataRetriever siteDataRetriever;

    private final GroupCommandPort groupCommandPort;
    private final GroupQueryPort groupQueryPort;

    private final MailNotifier mailNotifier;

    private final FlowStepProperties props;

    @Async
    public void process(String email, Set<String> domains) {
        throwIfAlreadyInProgress();

        try {
            Group group = groupCommandPort.save(ProgressState.IN_PROGRESS);
            processDomainsConcurrently(group.id(), domains);
            mailNotifier.notify(email, group.id());
        } catch (Exception e) {
            groupCommandPort.fail(e.getMessage());
        }
    }

    private void throwIfAlreadyInProgress() {
        if (groupQueryPort.existsByState(ProgressState.IN_PROGRESS)) {
            throw new GroupAlreadyInProgressException("Group already in progress.");
        }
    }

    private void processDomainsConcurrently(String groupId, Set<String> domains) {
        List<CompletableFuture<Site>> futures = domains.stream()
                .map(domain -> CompletableFuture.supplyAsync(() -> {

                    SiteData siteData = buildSiteData(domain, groupId);
                    return siteCommandPort.complete(domain, siteData);

                }, executor).exceptionally(ex -> {
                    log.warn("Couldn't execute {} - {}", domain, ex.getMessage());
                    return null;
                }))
                .toList();

        List<Site> sites = waitForTasks(futures);
        groupCommandPort.complete(groupId, sites);
    }

    private SiteData buildSiteData(String domain, String groupId) {
        Site site = siteCommandPort.ensureExists(domain, groupId);

        if ((site.content() == null || site.content().isBlank()) && !props.getContentRetriever().isDisabled()) {
            site = site.withContent(siteDataRetriever.retrieveContent(domain));
        }

        if ((site.categories() == null || site.categories().isEmpty()) && !props.getCategorization().isDisabled()) {
            site = site.withCategories(siteDataRetriever.retrieveCategories(domain, site.content()));
        }

        if ((site.metrics() == null || site.metrics().isEmpty()) && !props.getMetrics().isDisabled()) {
            site = site.withMetrics(siteDataRetriever.retrieveMetrics(domain));
        }

        return new SiteData(site.content(), site.categories(), site.metrics());
    }

    private List<Site> waitForTasks(List<CompletableFuture<Site>> futures) {
        return futures.stream()
                .map(CompletableFuture::join)
                .filter(Objects::nonNull)
                .toList();
    }
}
