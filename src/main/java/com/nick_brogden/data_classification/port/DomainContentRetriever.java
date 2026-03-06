package com.nick_brogden.data_classification.port;

import com.nick_brogden.data_classification.application.classification.ResponseBody;

public interface DomainContentRetriever {

    ResponseBody<String> retrieve(String domain);

}
