package com.nick_brogden.data_classification.domain.group.model;

import com.nick_brogden.data_classification.domain.group.type.ProgressState;
import lombok.Builder;

@Builder
public record Group(
        String id,
        ProgressState state,
        String message
) {
}
