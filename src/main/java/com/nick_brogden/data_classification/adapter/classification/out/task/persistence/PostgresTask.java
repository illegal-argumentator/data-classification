package com.nick_brogden.data_classification.adapter.classification.out.task.persistence;

import com.nick_brogden.data_classification.domain.task.type.Category;
import com.nick_brogden.data_classification.domain.task.type.Status;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tasks")
public class PostgresTask {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String domain;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = 30_000)
    String content;

    List<Category> categories;

}
