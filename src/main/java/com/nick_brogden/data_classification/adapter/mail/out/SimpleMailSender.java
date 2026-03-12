package com.nick_brogden.data_classification.adapter.mail.out;

import com.nick_brogden.data_classification.adapter.mail.out.config.MailProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SimpleMailSender implements MailSender {

    private final MailProperties mailProperties;

    private final JavaMailSender javaMailSender;

    @Override
    public void send(String subject, String to, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject(subject);
        message.setText(text);
        message.setTo(to);
        message.setFrom(mailProperties.getFrom());
        message.setReplyTo(mailProperties.getReplyTo());

        javaMailSender.send(message);
    }

}
