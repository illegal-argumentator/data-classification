package com.nick_brogden.data_classification.port;

public interface EmailNotifier {

    void send(String email, String content);

}
