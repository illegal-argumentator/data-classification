package com.nick_brogden.data_classification.adapter.classification.out.site.mapper;

import com.nick_brogden.data_classification.adapter.classification.out.site.persistence.PostgresSite;
import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.infrastructure.MapStructConfig;
import org.mapstruct.*;

@Mapper(config = MapStructConfig.class)
public interface SiteMapper {

    PostgresSite toEntity(Site site);
    Site toSite(PostgresSite entity);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntity(Site request, @MappingTarget PostgresSite entity);

}
