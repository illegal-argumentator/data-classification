package com.nick_brogden.data_classification.adapter.web.browser.nst.dto;

public record StartBrowserResponse(
        int code,
        ResponseData data,
        boolean err,
        String msg
) {

    public record ResponseData(
            int port,
            String profileId,
            String proxy
    ) {
    }
}
