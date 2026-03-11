package com.nick_brogden.data_classification.adapter.group.out.persistence;

import com.nick_brogden.data_classification.domain.group.type.ProgressState;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<PostgresGroup, String> {

    boolean existsByState(ProgressState state);

}
