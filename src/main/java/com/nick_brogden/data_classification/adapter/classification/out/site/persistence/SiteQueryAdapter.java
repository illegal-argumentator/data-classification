package com.nick_brogden.data_classification.adapter.classification.out.site.persistence;

import com.nick_brogden.data_classification.adapter.classification.out.site.mapper.SiteMapper;
import com.nick_brogden.data_classification.port.SiteQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SiteQueryAdapter implements SiteQueryPort {

    private final SiteMapper mapper;
    private final SiteRepository repository;

    @Override
    public boolean existsByDomain(String domain) {
        return repository.existsByDomain(domain);
    }

}
