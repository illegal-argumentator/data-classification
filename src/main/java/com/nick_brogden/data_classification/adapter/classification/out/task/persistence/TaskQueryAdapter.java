package com.nick_brogden.data_classification.adapter.classification.out.task.persistence;

import com.nick_brogden.data_classification.port.TaskQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskQueryAdapter implements TaskQueryPort {

    @Override
    public boolean existsByDomain(String domain) {
        return false;
    }
}
