package com.nick_brogden.data_classification.port;

public interface MailNotifier {

    void notify(String email, String content);

}
