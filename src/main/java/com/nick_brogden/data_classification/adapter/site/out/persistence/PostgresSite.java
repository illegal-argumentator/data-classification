package com.nick_brogden.data_classification.adapter.site.out.persistence;

import com.nick_brogden.data_classification.adapter.group.out.persistence.PostgresGroup;
import com.nick_brogden.data_classification.domain.site.type.Category;
import com.nick_brogden.data_classification.domain.site.type.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name = "sites")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostgresSite {

    private static final int MAX_CONTENT_LENGTH = 50_000;
    private static final int MAX_LOGS_LIST_LENGTH = 5_000;
    private static final int MAX_LOG_LENGTH = 200;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToMany
    private Set<PostgresGroup> groups;

    @Column(unique = true)
    private String domain;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = MAX_LOGS_LIST_LENGTH)
    @ElementCollection
    private Set<String> logs;

    @Column(length = MAX_CONTENT_LENGTH)
    private String content;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    private Set<Category> categories;

    @ElementCollection
    private Set<PostgresMetric> metrics;

    @CreatedDate
    private Instant createdAt;

    @LastModifiedDate
    private Instant updatedAt;

    public void setContent(String content) {
        if (content != null && content.length() > MAX_CONTENT_LENGTH) {
            this.content = content.substring(0, MAX_CONTENT_LENGTH);
        } else {
            this.content = content;
        }
    }

    public void setLogs(List<String> logs) {
        Set<String> formatterLogs = logs.stream()
                .map(log -> log.length() > MAX_LOG_LENGTH ? log.substring(0, MAX_LOG_LENGTH) + "...\n" : log)
                .collect(Collectors.toSet());

        if ((MAX_LOGS_LIST_LENGTH - this.logs.size()) > logs.size()) {
            this.logs = new HashSet<>(formatterLogs);
        } else {
            this.logs.addAll(formatterLogs);
        }
    }
}
