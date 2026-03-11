package com.nick_brogden.data_classification.application.analytics;

import com.nick_brogden.data_classification.domain.group.exception.GroupFailedException;
import com.nick_brogden.data_classification.domain.group.exception.GroupIsInProgressException;
import com.nick_brogden.data_classification.domain.group.model.Group;
import com.nick_brogden.data_classification.domain.group.type.ProgressState;
import com.nick_brogden.data_classification.port.group.GroupQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnalyticsUserCase {

    private final GroupQueryPort groupQueryPort;

    public byte[] exportCsv(String groupId) {
        Group group = groupQueryPort.find(groupId);
        validateGroup(group);
        // TODO retrieve all sited by groupId
        return new byte[]{};
    }

    private void validateGroup(Group group) {
        if (group.progressState() == ProgressState.COMPLETED) {
            return;
        } else if (group.progressState() == ProgressState.IN_PROGRESS) {
            throw new GroupIsInProgressException("Group is in progress.");
        }

        throw new GroupFailedException("Group failed. Please try again.");
    }

}
