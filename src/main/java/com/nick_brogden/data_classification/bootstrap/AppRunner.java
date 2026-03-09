package com.nick_brogden.data_classification.bootstrap;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class AppRunner implements ApplicationRunner {

    @Value("${server.port}")
    private int port;
    @Value("${server.host}")
    private String host;
    @Value("${server.servlet.context-path}")
    private String contextPath;

    private static final String URL_TEMPLATE = "http://%s:%d%s/swagger-ui/index.html";

    @Override
    public void run(@NotNull ApplicationArguments args) {
        log.info("Swagger UI: {}", URL_TEMPLATE.formatted(host, port, contextPath));
    }

}
