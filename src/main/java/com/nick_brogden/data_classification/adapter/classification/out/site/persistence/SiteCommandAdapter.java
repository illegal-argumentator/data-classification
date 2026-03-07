package com.nick_brogden.data_classification.adapter.classification.out.site.persistence;

import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.port.SiteCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class SiteCommandAdapter implements SiteCommandPort {

    @Override
    public void save(Site site) {

    }

    @Override
    public void saveAll(List<Site> sites) {

    }

    @Override
    public Site update(String domain, Site site) {
        return null;
    }
}
