package com.nick_brogden.data_classification.port.group;

import com.nick_brogden.data_classification.domain.group.model.Group;
import com.nick_brogden.data_classification.domain.group.type.ProgressState;
import com.nick_brogden.data_classification.domain.site.model.Site;

import java.util.List;

public interface GroupCommandPort {

    Group save(ProgressState state);

    void complete(String id, List<Site> sites);

    void fail(String message);

}
