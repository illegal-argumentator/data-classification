package com.nick_brogden.data_classification.application.classification;

import jakarta.annotation.Nullable;
import lombok.Builder;

@Builder
public record ResponseBody<T> (
        int code,
        @Nullable
        String message,
        T body
) {

    public boolean isSuccessful() {
        return code >= 200 && code <= 299;
    }

}
