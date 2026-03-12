package com.nick_brogden.data_classification.domain.site.model;

import com.nick_brogden.data_classification.domain.group.model.Group;
import com.nick_brogden.data_classification.domain.site.type.Category;
import com.nick_brogden.data_classification.domain.site.type.Status;
import lombok.Builder;
import lombok.With;

import java.util.List;
import java.util.Set;

@Builder(toBuilder = true)
public record Site(
        String id,
        Set<Group> groups,
        String domain,
        Status status,
        List<String> logs,

        @With
        List<Category> categories,
        @With
        List<Metric> metrics,
        @With
        String content
) {

}
