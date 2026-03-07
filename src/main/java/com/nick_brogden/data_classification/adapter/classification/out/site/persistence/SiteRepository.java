package com.nick_brogden.data_classification.adapter.classification.out.site.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SiteRepository extends JpaRepository<PostgresSite, String> {
}
