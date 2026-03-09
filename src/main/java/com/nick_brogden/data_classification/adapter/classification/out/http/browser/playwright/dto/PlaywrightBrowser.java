package com.nick_brogden.data_classification.adapter.classification.out.http.browser.playwright.dto;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.LoadState;
import com.nick_brogden.data_classification.adapter.classification.out.http.browser.LocalBrowser;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class PlaywrightBrowser implements LocalBrowser {

    private Page page;

    private List<AutoCloseable> autoCloseables;

    @Override
    public void navigate(String url) {
        page.navigate(url);
    }

    @Override
    public void waitForLoadState() {
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
    }

    @Override
    public String text(String selector) {
        return page.locator(selector).innerText();
    }

    public void close() {
        if (!CollectionUtils.isEmpty(autoCloseables)) {
            for (AutoCloseable ac : autoCloseables) {
                try {
                    ac.close();
                } catch (Exception e) {
                    log.error("Failed to close resource: {}", e.getMessage(), e);
                }
            }
        }

        try {
            if (page != null) {
                page.close();
            }
        } catch (Exception e) {
            log.error("Failed to close page: {}", e.getMessage(), e);
        }
    }
}
