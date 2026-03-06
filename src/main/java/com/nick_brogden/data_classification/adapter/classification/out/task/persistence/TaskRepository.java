package com.nick_brogden.data_classification.adapter.classification.out.task.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<PostgresTask, String> {
}
