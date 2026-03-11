package com.nick_brogden.data_classification.adapter.site.out.persistence;

import com.nick_brogden.data_classification.adapter.group.out.persistence.GroupRepository;
import com.nick_brogden.data_classification.adapter.group.out.persistence.PostgresGroup;
import com.nick_brogden.data_classification.adapter.site.out.mapper.SiteMapper;
import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.domain.site.model.SiteData;
import com.nick_brogden.data_classification.domain.site.type.Status;
import com.nick_brogden.data_classification.port.site.SiteCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SiteCommandAdapter implements SiteCommandPort {

    private final SiteMapper siteMapper;
    private final SiteRepository siteRepository;
    private final GroupRepository groupRepository;

    @Override
    public Site ensureExists(String domain, String groupId) {
        PostgresGroup postgresGroup = groupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found"));

        PostgresSite site = siteRepository.findByDomain(domain)
                .orElseGet(() -> {
                    PostgresSite newSite = PostgresSite.builder()
                            .domain(domain)
                            .status(Status.PENDING)
                            .groups(new HashSet<>(Set.of(postgresGroup)))
                            .build();
                    return siteRepository.save(newSite);
                });

        if (!site.getGroups().contains(postgresGroup)) {
            site.getGroups().add(postgresGroup);
            siteRepository.save(site);
        }

        return siteMapper.toSite(site);
    }

    @Override
    public Site update(String domain, Site site) {
        PostgresSite existing = siteRepository.findByDomain(domain)
                .orElseThrow(() -> new RuntimeException("Site does not exist."));

        siteMapper.updateEntity(site, existing);
        siteRepository.save(existing);

        return siteMapper.toSite(existing);
    }

    @Override
    public Site complete(String domain, SiteData data) {
        return update(domain,
                Site.builder()
                        .categories(data.categories())
                        .content(data.content())
                        .metrics(data.metrics())
                        .status(Status.COMPLETED)
                        .build());
    }
}
