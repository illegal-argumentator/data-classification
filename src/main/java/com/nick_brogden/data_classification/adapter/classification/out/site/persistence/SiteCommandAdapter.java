package com.nick_brogden.data_classification.adapter.classification.out.site.persistence;

import com.nick_brogden.data_classification.adapter.classification.out.site.mapper.SiteMapper;
import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.domain.site.type.Status;
import com.nick_brogden.data_classification.port.SiteCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SiteCommandAdapter implements SiteCommandPort {

    private final SiteMapper mapper;
    private final SiteRepository repository;

    @Override
    public Site ensureExists(String domain) {
        PostgresSite postgresSite = repository.findByDomain(domain)
                .orElseGet(() -> {
                    PostgresSite newSite = PostgresSite.builder()
                            .domain(domain)
                            .status(Status.PENDING)
                            .build();
                    return repository.save(newSite);
                });

        return mapper.toSite(postgresSite);
    }

    @Override
    public Site update(String domain, Site site) {
        PostgresSite existing = repository.findByDomain(domain)
                .orElseThrow(() -> new RuntimeException("Site does not exist."));

        mapper.updateEntity(site, existing);

        Optional.ofNullable(site.logs()).ifPresent(logs -> {
            if (existing.getLogs() == null) {
                existing.setLogs(new ArrayList<>(site.logs()));
            } else {
                existing.getLogs().addAll(site.logs());
            }
        });

        repository.save(existing);

        return mapper.toSite(existing);
    }
}
