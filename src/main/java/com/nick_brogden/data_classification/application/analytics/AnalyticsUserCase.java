package com.nick_brogden.data_classification.application.analytics;

import com.nick_brogden.data_classification.domain.group.exception.GroupFailedException;
import com.nick_brogden.data_classification.domain.group.exception.GroupIsInProgressException;
import com.nick_brogden.data_classification.domain.group.model.Group;
import com.nick_brogden.data_classification.domain.group.type.ProgressState;
import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.port.CsvExporter;
import com.nick_brogden.data_classification.port.group.GroupQueryPort;
import com.nick_brogden.data_classification.port.site.SiteQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnalyticsUserCase {

    private final GroupQueryPort groupQueryPort;
    private final SiteQueryPort siteQueryPort;
    private final CsvExporter<List<Site>> exporter;

    public byte[] exportCsv(String groupId) {
        Group group = groupQueryPort.find(groupId);
        validateGroup(group);
        List<Site> sites = siteQueryPort.retrieveAllCompletedByGroup(groupId);
        return exporter.export(sites);
    }

    private void validateGroup(Group group) {
        if (group.state() == ProgressState.COMPLETED) {
            return;
        } else if (group.state() == ProgressState.IN_PROGRESS) {
            throw new GroupIsInProgressException("Group is in progress.");
        }

        throw new GroupFailedException("Group processing failed. Please try again.");
    }

}
