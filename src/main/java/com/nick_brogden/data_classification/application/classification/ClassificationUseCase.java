package com.nick_brogden.data_classification.application.classification;

import com.nick_brogden.data_classification.domain.task.model.Task;
import com.nick_brogden.data_classification.domain.task.type.Status;
import com.nick_brogden.data_classification.port.DomainContentRetriever;
import com.nick_brogden.data_classification.port.TaskCommandPort;
import com.nick_brogden.data_classification.port.TaskQueryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
public class ClassificationUseCase {

    private final TaskQueryPort queryPort;
    private final TaskCommandPort commandPort;
    private final DomainContentRetriever contentRetriever;

    public void process(String email, List<String> domains) {
        List<Task> tasks = start(domains);
        // TODO convert tasks to csv
        // TODO send data to email
    }

    private List<Task> start(List<String> domains) {
        List<CompletableFuture<Task>> futures = new ArrayList<>();

        for (String domain : domains) {
            if (queryPort.existsByDomain(domain)) {
                continue;
            }

            Task task = Task.builder().domain(domain).status(Status.PENDING).build();
            commandPort.save(task);
            futures.add(retrieveData(task.domain()));
        }

        return waitForTasks(futures);
    }

    @Async("taskExecutor")
    protected CompletableFuture<Task> retrieveData(String domain) {
        ResponseBody<String> content = contentRetriever.retrieve(domain);

        if (!content.isSuccessful()) {
            // TODO update to failed and return
        }

        Task updatedTask = commandPort.updateByDomain(domain, Task.builder().content(content.body()).build());
        return categorize(updatedTask);
    }

    @Async("taskExecutor")
    protected CompletableFuture<Task> categorize(Task task) {
        return provideMetrics(task);
    }

    @Async("taskExecutor")
    protected CompletableFuture<Task> provideMetrics(Task task) {
        return CompletableFuture.completedFuture(task);
    }

    private List<Task> waitForTasks(List<CompletableFuture<Task>> futures) {
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        return futures.stream()
                .map(CompletableFuture::join)
                .toList();
    }

}
