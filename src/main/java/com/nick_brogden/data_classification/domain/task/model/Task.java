package com.nick_brogden.data_classification.domain.task.model;

import com.nick_brogden.data_classification.domain.task.type.Category;
import com.nick_brogden.data_classification.domain.task.type.Status;
import lombok.Builder;

import java.util.List;

@Builder
public record Task(
        String domain,
        Status status,
        String content,
        List<Category> categories,
        String logs
) {
}
