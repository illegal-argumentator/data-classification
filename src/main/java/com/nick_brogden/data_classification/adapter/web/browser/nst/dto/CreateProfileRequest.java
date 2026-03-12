package com.nick_brogden.data_classification.adapter.web.browser.nst.dto;

import java.util.List;
import java.util.Map;

public record CreateProfileRequest(
        String groupId,
        String platform,
        Fingerprint fingerprint
) {

    public record Fingerprint(Localization localization, String timezone, Geo geo) {
        public record Localization(
                boolean basedOnProxy,
                String language,
                List<String> languages,
                String locale,
                Map<String, String> flags
        ) {
        }

        public record Geo(String country) {}
    }
}


