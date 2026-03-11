package com.nick_brogden.data_classification.adapter.site.out.persistence;

import com.nick_brogden.data_classification.port.site.SiteQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SiteQueryAdapter implements SiteQueryPort {

    private final SiteRepository repository;

    @Override
    public boolean existsByDomain(String domain) {
        return repository.existsByDomain(domain);
    }

}
