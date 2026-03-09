package com.nick_brogden.data_classification.adapter.classification.out.parser;

import java.util.List;
import java.util.Map;

public interface CsvParser {

    List<Map<String, String>> parse(String csv);

}
