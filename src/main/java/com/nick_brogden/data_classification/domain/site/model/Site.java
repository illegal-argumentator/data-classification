package com.nick_brogden.data_classification.domain.site.model;

import com.nick_brogden.data_classification.domain.site.type.Category;
import com.nick_brogden.data_classification.domain.site.type.Status;
import lombok.Builder;
import lombok.With;

import java.util.List;

@Builder(toBuilder = true)
public record Site(
        String domain,
        Status status,
        List<String> logs,

        @With
        String content,
        @With
        List<Category> categories,
        @With
        List<Metric> metrics
) {

}
