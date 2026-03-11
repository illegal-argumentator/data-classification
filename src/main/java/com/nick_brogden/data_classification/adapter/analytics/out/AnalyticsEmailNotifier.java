package com.nick_brogden.data_classification.adapter.analytics.out;

import com.nick_brogden.data_classification.port.EmailNotifier;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsEmailNotifier implements EmailNotifier {

    @Override
    public void send(String email, String content) {

    }

}
