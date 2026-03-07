package com.nick_brogden.data_classification.domain.site.model;

import com.nick_brogden.data_classification.domain.site.type.Category;
import com.nick_brogden.data_classification.domain.site.type.Status;
import lombok.Builder;

import java.util.List;

@Builder(toBuilder = true)
public record Site(
        String domain,
        Status status,
        String content,
        List<Category> categories,
        List<String> logs,
        Metric metric
) {

}
