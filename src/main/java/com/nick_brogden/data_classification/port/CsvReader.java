package com.nick_brogden.data_classification.port;

import java.util.List;
import java.util.Map;

public interface CsvReader {

    List<Map<String, String>> parse(String csv);

}
