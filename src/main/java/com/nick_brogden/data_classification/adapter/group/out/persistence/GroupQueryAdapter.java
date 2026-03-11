package com.nick_brogden.data_classification.adapter.group.out.persistence;

import com.nick_brogden.data_classification.adapter.group.out.mapper.GroupMapper;
import com.nick_brogden.data_classification.domain.group.model.Group;
import com.nick_brogden.data_classification.domain.group.type.ProgressState;
import com.nick_brogden.data_classification.port.group.GroupQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupQueryAdapter implements GroupQueryPort {

    private final GroupRepository repository;
    private final GroupMapper mapper;

    @Override
    public Group find(String groupId) {
        PostgresGroup entity = repository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found."));
        return mapper.toGroup(entity);
    }

    @Override
    public boolean existsByState(ProgressState state) {
        return repository.existsByState(state);
    }
}
