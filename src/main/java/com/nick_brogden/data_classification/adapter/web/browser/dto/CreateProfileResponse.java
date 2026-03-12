package com.nick_brogden.data_classification.adapter.web.browser.dto;

public record CreateProfileResponse(
        CreateProfileResponseData data
) {
    public record CreateProfileResponseData(
            String profileId,
            String name) {
    }
}
