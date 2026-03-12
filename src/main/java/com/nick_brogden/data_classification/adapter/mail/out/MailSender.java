package com.nick_brogden.data_classification.adapter.mail.out;

public interface MailSender {

    void send(String subject, String to, String text);

}