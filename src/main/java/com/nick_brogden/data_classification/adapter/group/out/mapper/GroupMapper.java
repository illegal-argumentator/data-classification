package com.nick_brogden.data_classification.adapter.group.out.mapper;

import com.nick_brogden.data_classification.adapter.group.out.persistence.PostgresGroup;
import com.nick_brogden.data_classification.domain.group.model.Group;
import com.nick_brogden.data_classification.infrastructure.MapStructConfig;
import org.mapstruct.Mapper;

@Mapper(config = MapStructConfig.class)
public interface GroupMapper {

    Group toGroup(PostgresGroup entity);

}
