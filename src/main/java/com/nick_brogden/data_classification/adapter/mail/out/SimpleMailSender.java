package com.nick_brogden.data_classification.adapter.mail.out;

import com.nick_brogden.data_classification.adapter.mail.out.config.MailProperties;
import com.nick_brogden.data_classification.bootstrap.FlowStepProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleMailSender implements MailSender {

    private final FlowStepProperties props;
    private final MailProperties mailProperties;
    private final JavaMailSender javaMailSender;

    @Override
    public void send(String subject, String to, String text) {
        if (props.getNotifier().isDisabled()) return;

        SimpleMailMessage message = new SimpleMailMessage();

        message.setSubject(subject);
        message.setText(text);
        message.setTo(to);
        message.setFrom(mailProperties.getFrom());
        message.setReplyTo(mailProperties.getReplyTo());

        javaMailSender.send(message);

        log.info("Successfully sent email to {}.", to);
    }

}
