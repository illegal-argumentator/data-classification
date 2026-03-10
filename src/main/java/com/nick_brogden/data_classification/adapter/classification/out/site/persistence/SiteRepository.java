package com.nick_brogden.data_classification.adapter.classification.out.site.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SiteRepository extends JpaRepository<PostgresSite, String> {

    boolean existsByDomain(String domain);

    Optional<PostgresSite> findByDomain(String domain);
}
