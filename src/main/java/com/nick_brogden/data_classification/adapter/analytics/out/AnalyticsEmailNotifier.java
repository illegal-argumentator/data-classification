package com.nick_brogden.data_classification.adapter.analytics.out;

import com.nick_brogden.data_classification.adapter.mail.out.MailSender;
import com.nick_brogden.data_classification.adapter.server.out.config.AppProps;
import com.nick_brogden.data_classification.port.MailNotifier;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class AnalyticsEmailNotifier implements MailNotifier {

    private static final String DOWNLOAD_LINK_TEMPLATE = "http://%s:%d%s/analytics/export-csv?groupId=%s";
    private static final String SUBJECT = "Your analytics data is ready for download.";
    private static final String CONTENT_TEMPLATE = """
            Hello,
            
            Your analytics data is ready.
            
            You can download the CSV file using the link below:
            %s
            
            If you have any questions, feel free to contact us.
            
            Best regards,
            The Team""";
    private final AppProps appProps;
    private final MailSender mailSender;

    @Override
    public void notify(String to, String text) {
        mailSender.send(SUBJECT, to, CONTENT_TEMPLATE.formatted(buildDownloadLink(text)));
        log.info("Successfully sent email to {}.", to);
    }

    private String buildDownloadLink(String groupId) {
        return DOWNLOAD_LINK_TEMPLATE.formatted(appProps.getHost(), appProps.getPort(), appProps.getServlet().getContextPath(), groupId);
    }
}
