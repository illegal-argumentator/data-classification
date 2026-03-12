package com.nick_brogden.data_classification.adapter.site.out.persistence;

import com.nick_brogden.data_classification.adapter.site.out.mapper.SiteMapper;
import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.port.site.SiteQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SiteQueryAdapter implements SiteQueryPort {

    private final SiteRepository repository;
    private final SiteMapper mapper;

    @Override
    public List<Site> retrieveAllCompletedByGroup(String groupId) {
        List<PostgresSite> sites = repository.findAllCompletedByGroupId(groupId);
        return sites.stream().map(this.mapper::toSite).toList();
    }

}
