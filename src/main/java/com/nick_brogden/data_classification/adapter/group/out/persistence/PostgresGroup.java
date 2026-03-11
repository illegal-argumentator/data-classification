package com.nick_brogden.data_classification.adapter.group.out.persistence;

import com.nick_brogden.data_classification.domain.group.type.ProgressState;
import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "groups")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostgresGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Enumerated(EnumType.STRING)
    private ProgressState state;

    private String message;

    public void setMessage(String message) {
        if (message != null && !message.isBlank()) {
            this.message = message.length() > 255 ? message.substring(0, 252) + "..." : message;
        }
    }

}
