package com.nick_brogden.data_classification.port;

import com.nick_brogden.data_classification.domain.task.model.Task;

public interface TaskCommandPort {

    void save(Task task);

    Task updateByDomain(String domain, Task task);

}
