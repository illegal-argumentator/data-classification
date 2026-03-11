package com.nick_brogden.data_classification.port.group;

import com.nick_brogden.data_classification.domain.group.model.Group;
import com.nick_brogden.data_classification.domain.group.type.ProgressState;

public interface GroupQueryPort {

    Group find(String groupId);

    boolean existsByState(ProgressState state);

}
