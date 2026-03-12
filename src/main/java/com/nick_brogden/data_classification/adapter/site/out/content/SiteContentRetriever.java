package com.nick_brogden.data_classification.adapter.site.out.content;

import com.nick_brogden.data_classification.adapter.web.browser.BrowserInitializer;
import com.nick_brogden.data_classification.adapter.web.browser.LocalBrowser;
import com.nick_brogden.data_classification.adapter.web.UrlBuilder;
import com.nick_brogden.data_classification.adapter.web.browser.ProfileService;
import com.nick_brogden.data_classification.adapter.web.browser.dto.CreateProfileResponse;
import com.nick_brogden.data_classification.port.DomainContentRetriever;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class SiteContentRetriever implements DomainContentRetriever {

    private final BrowserInitializer browserInitializer;
    private final ProfileService profileService;

    // TODO think about not opening browser for each domain, new page is enough
    @Override
    public String retrieve(String domain) {
        CreateProfileResponse profile = profileService.createProfile();
        try (LocalBrowser localBrowser = browserInitializer.initBrowser(profile.data().profileId())) {

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
