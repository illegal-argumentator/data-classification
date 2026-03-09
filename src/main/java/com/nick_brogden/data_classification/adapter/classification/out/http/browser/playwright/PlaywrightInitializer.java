package com.nick_brogden.data_classification.adapter.classification.out.http.browser.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.nick_brogden.data_classification.adapter.classification.out.http.browser.BrowserInitializer;
import com.nick_brogden.data_classification.adapter.classification.out.http.browser.LocalBrowser;
import com.nick_brogden.data_classification.adapter.classification.out.http.browser.playwright.dto.PlaywrightBrowser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlaywrightInitializer implements BrowserInitializer {

    @Value("${browser.headless}")
    private boolean BROWSER_HEADLESS;

    @Override
    public LocalBrowser initBrowser() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(BROWSER_HEADLESS));
        Page page = browser.newPage();

        return new PlaywrightBrowser(page, List.of(page, browser, playwright));
    }

}
