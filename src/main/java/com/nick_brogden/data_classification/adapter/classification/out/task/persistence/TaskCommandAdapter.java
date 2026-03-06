package com.nick_brogden.data_classification.adapter.classification.out.task.persistence;

import com.nick_brogden.data_classification.domain.task.model.Task;
import com.nick_brogden.data_classification.port.TaskCommandPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskCommandAdapter implements TaskCommandPort {

    @Override
    public void save(Task task) {

    }

    @Override
    public Task updateByDomain(String domain, Task task) {
        return null;
    }

}
