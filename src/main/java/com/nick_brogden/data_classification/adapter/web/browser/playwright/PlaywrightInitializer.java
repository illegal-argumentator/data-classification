package com.nick_brogden.data_classification.adapter.web.browser.playwright;

import com.microsoft.playwright.*;
import com.nick_brogden.data_classification.adapter.web.browser.BrowserInitializer;
import com.nick_brogden.data_classification.adapter.web.browser.LocalBrowser;
import com.nick_brogden.data_classification.adapter.web.browser.nst.config.NstProperties;
import com.nick_brogden.data_classification.adapter.web.browser.playwright.dto.PlaywrightBrowser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.Boolean.TRUE;

@Slf4j
@Component
@RequiredArgsConstructor
public class PlaywrightInitializer implements BrowserInitializer {

    private final static String NST_BROWSER_URL_TEMPLATE = "ws://%s:%s/devtool/launch/%s?x-api-key=%s&config=%%7B%%22headless%%22%%3A%s%%2C%%22autoClose%%22%%3A%s%%7D";
    private final NstProperties nstProperties;

    @Override
    public LocalBrowser initBrowser() {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(nstProperties.isHeadless()));
        Page page = browser.newPage();

        return new PlaywrightBrowser(page, List.of(page, browser, playwright));
    }

    @Override
    public LocalBrowser initBrowser(String browserProfileId) {
        try {
            String url = String.format(
                    NST_BROWSER_URL_TEMPLATE,
                    nstProperties.getHost(),
                    nstProperties.getPort(),
                    browserProfileId,
                    nstProperties.getApiKey(),
                    nstProperties.isHeadless(),
                    TRUE
            );

            log.info("Init playwright url: {}", url);

            return initPlaywrightWithCdp(url);
        } catch (PlaywrightException e) {
            log.error("Error connecting to Nst Browser: {}", e.getMessage());
            throw new RuntimeException("Error connecting to Nst Browser. Possibly daily quote reached");
        }
    }

    public LocalBrowser initPlaywrightWithCdp(String cdpUrl) throws PlaywrightException {
        Playwright playwright = Playwright.create();

        Browser browser = playwright.chromium().connectOverCDP(cdpUrl);
        BrowserContext context = browser.contexts().get(0);
        Page page = context.pages().get(0);
        page.bringToFront();

        return new PlaywrightBrowser(page, List.of(page, browser, playwright));
    }
}
