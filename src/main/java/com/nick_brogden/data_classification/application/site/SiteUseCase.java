package com.nick_brogden.data_classification.application.site;

import com.nick_brogden.data_classification.domain.site.type.Category;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SiteUseCase implements SiteDataRetriever {



    @Override
    public String retrieveContent(String domain) {
        return null;
    }

    @Override
    public Category retrieveCategory(String content) {
        return null;
    }

    @Override
    public Object retrieveMetrics(String domain) {
        return null;
    }

}
