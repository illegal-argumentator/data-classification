package com.nick_brogden.data_classification.adapter.classification.out.site.persistence;

import com.nick_brogden.data_classification.domain.site.type.Category;
import com.nick_brogden.data_classification.domain.site.type.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "sites")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostgresSite {

    private static final int MAX_STRING_LENGTH = 50_000;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(unique = true)
    private String domain;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(length = MAX_STRING_LENGTH)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> logs;

    @Column(length = MAX_STRING_LENGTH)
    private String content;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<Category> categories;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<PostgresMetric> metrics;

    public void setContent(String content) {
        if (content != null && content.length() > MAX_STRING_LENGTH) {
            this.content = content.substring(0, MAX_STRING_LENGTH);
        } else {
            this.content = content;
        }
    }

    public void setLogs(List<String> logs) {
        int logsLength = getLogsLength(this.logs);
        int requestLogs = getLogsLength(logs);

        if ((MAX_STRING_LENGTH - logsLength) > requestLogs) {
            this.logs = new ArrayList<>(logs);
        } else {
            this.logs.addAll(logs);
        }
    }

    private int getLogsLength(List<String> logs) {
        return logs.stream()
                .map(String::length)
                .reduce(0, Integer::sum);
    }
}
