package com.nick_brogden.data_classification.adapter.classification.out.web.jsoup;

import com.nick_brogden.data_classification.application.classification.ResponseBody;
import com.nick_brogden.data_classification.port.DomainContentRetriever;
import org.springframework.stereotype.Component;

@Component
public class JsoupContentRetriever implements DomainContentRetriever {

    @Override
    public ResponseBody<String> retrieve(String domain) {

        return ResponseBody.<String>builder().build();
    }

}
