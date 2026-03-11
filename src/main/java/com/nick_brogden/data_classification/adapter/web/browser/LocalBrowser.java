package com.nick_brogden.data_classification.adapter.web.browser;

public interface LocalBrowser extends AutoCloseable {

    void navigate(String url);

    void waitForLoadState();

    String text(String selector);

}
