package com.nick_brogden.data_classification.adapter.http.ok_http.dto;

import lombok.Builder;

@Builder
public record OkResponseBody(
        String body,
        int code
) {
}
