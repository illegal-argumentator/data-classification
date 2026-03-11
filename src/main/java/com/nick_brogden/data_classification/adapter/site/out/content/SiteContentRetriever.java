package com.nick_brogden.data_classification.adapter.site.out.content;

import com.nick_brogden.data_classification.adapter.web.browser.BrowserInitializer;
import com.nick_brogden.data_classification.adapter.web.browser.LocalBrowser;
import com.nick_brogden.data_classification.adapter.web.UrlBuilder;
import com.nick_brogden.data_classification.port.DomainContentRetriever;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SiteContentRetriever implements DomainContentRetriever {

    private final BrowserInitializer browserInitializer;

    // TODO think about not opening browser for each domain, new page should be enough
    @Override
    public String retrieve(String domain) {
        try (LocalBrowser localBrowser = browserInitializer.initBrowser()) {

            localBrowser.navigate(UrlBuilder.buildByDomain(domain));
            localBrowser.waitForLoadState();

            String text = localBrowser.text("body");
            if (text == null || text.isBlank()) {
                throw new RuntimeException("Site has no content or blocked bot activity.");
            }

            return text;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
