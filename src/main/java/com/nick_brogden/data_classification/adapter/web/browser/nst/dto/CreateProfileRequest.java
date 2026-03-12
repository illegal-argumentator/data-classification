package com.nick_brogden.data_classification.adapter.web.browser.nst.dto;

import java.util.List;

public record CreateProfileRequest(
        String groupId,
        Fingerprint fingerprint
) {

    public record Fingerprint(Localization localization, String timezone, Geo geo) {
        public record Localization(String language, List<String> languages, String locale) {
        }

        public record Geo(String country) {}
    }
}


