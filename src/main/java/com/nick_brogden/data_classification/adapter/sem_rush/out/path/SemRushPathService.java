package com.nick_brogden.data_classification.adapter.sem_rush.out.path;

import com.nick_brogden.data_classification.adapter.sem_rush.out.config.SemRushProps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public final class SemRushPathService {

    private final SemRushProps props;

    private final String BASE_URL_TEMPLATE = "%s?type=%s&key=%s&domain=%s&database=%s&export_columns=%s";

    public String getDomainSearch(String domain) {
        return BASE_URL_TEMPLATE.formatted(
                props.getUrl(),
                props.getType(),
                props.getApiKey(),
                domain,
                props.getDatabase(),
                props.getMetrics()
        );
    }


}
