package com.nick_brogden.data_classification.adapter.csv;

import java.util.List;
import java.util.Map;

public interface CsvReader {

    List<Map<String, String>> parse(String csv);

}
