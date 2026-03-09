package com.nick_brogden.data_classification.adapter.classification.out.http.browser;

public interface LocalBrowser extends AutoCloseable {

    void navigate(String url);

    void waitForLoadState();

    String text(String selector);

}
