package com.nick_brogden.data_classification.adapter.group.out.persistence;

import com.nick_brogden.data_classification.adapter.group.out.mapper.GroupMapper;
import com.nick_brogden.data_classification.domain.group.model.Group;
import com.nick_brogden.data_classification.domain.group.type.ProgressState;
import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.port.group.GroupCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GroupCommandAdapter implements GroupCommandPort {

    private final GroupRepository repository;
    private final GroupMapper groupMapper;

    @Override
    public Group save(ProgressState state) {
        PostgresGroup entity = repository.save(PostgresGroup.builder().state(state).build());
        return groupMapper.toGroup(entity);
    }

    @Override
    public void complete(String id, List<Site> sites) {
        PostgresGroup entity = repository.findById(id).orElseThrow(() -> new RuntimeException("Group not found."));
        entity.setState(ProgressState.COMPLETED);
        repository.save(entity);
    }

    @Override
    public void fail(String message) {
        repository.save(PostgresGroup.builder().state(ProgressState.FAILED).message(message).build());
    }

}
