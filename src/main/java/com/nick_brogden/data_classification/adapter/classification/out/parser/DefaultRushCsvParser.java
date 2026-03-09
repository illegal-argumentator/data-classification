package com.nick_brogden.data_classification.adapter.classification.out.parser;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DefaultRushCsvParser implements CsvParser {

    private static final String NEW_LINE_DELIMITER = "\n";
    private static final String SEMI_COLON_DELIMITER = ";";

    @Override
    public List<Map<String, String>> parse(String csv) {

        if (csv == null || csv.isBlank()) {
            throw new IllegalArgumentException("Csv is not specified.");
        }

        String[] rows = csv.split(NEW_LINE_DELIMITER);

        if (rows.length < 2) {
            throw new IllegalStateException("CSV must contain headers and at least one row.");
        }

        String[] headers = rows[0].split(SEMI_COLON_DELIMITER);

        List<Map<String, String>> result = new ArrayList<>();

        for (int i = 1; i < rows.length; i++) {

            String[] values = rows[i].split(SEMI_COLON_DELIMITER);

            Map<String, String> rowMap = new HashMap<>();

            for (int j = 0; j < headers.length; j++) {

                String header = headers[j];
                String value = j < values.length ? values[j] : "";

                rowMap.put(header, value);
            }

            result.add(rowMap);
        }

        return result;
    }
}
