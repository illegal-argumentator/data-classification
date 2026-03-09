package com.nick_brogden.data_classification.adapter.classification.out.web;

import com.nick_brogden.data_classification.adapter.classification.out.http.browser.BrowserInitializer;
import com.nick_brogden.data_classification.adapter.classification.out.http.browser.LocalBrowser;
import com.nick_brogden.data_classification.port.DomainContentRetriever;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultContentRetriever implements DomainContentRetriever {

    private final BrowserInitializer browserInitializer;

    // TODO think about not opening browser for each domain, new page should be enough
    @Override
    public String retrieve(String domain) {
        try (LocalBrowser localBrowser = browserInitializer.initBrowser()) {

            localBrowser.navigate(UrlBuilder.buildByDomain(domain));
            localBrowser.waitForLoadState();

            return localBrowser.text("body");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
