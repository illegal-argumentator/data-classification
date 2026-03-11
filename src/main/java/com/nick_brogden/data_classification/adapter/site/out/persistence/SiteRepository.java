package com.nick_brogden.data_classification.adapter.site.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface SiteRepository extends JpaRepository<PostgresSite, String> {

    boolean existsByDomain(String domain);

    @Query("""
            SELECT s
            FROM PostgresSite s
            LEFT JOIN FETCH s.logs
            LEFT JOIN FETCH s.metrics
            LEFT JOIN FETCH s.categories
            LEFT JOIN FETCH s.groups
            WHERE s.domain = :domain
            """)
    Optional<PostgresSite> findByDomain(String domain);
}
