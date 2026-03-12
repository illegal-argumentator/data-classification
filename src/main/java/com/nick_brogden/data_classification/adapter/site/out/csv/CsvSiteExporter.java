package com.nick_brogden.data_classification.adapter.site.out.csv;

import com.nick_brogden.data_classification.domain.site.model.Site;
import com.nick_brogden.data_classification.port.CsvExporter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;

@Component
public class CsvSiteExporter implements CsvExporter<List<Site>> {

    private static final String[] HEADERS = new String[]{"id", "domain", "categories", "metrics"};

    @Override
    public byte[] export(List<Site> data) {

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(
                     new OutputStreamWriter(out, StandardCharsets.UTF_8),
                     CSVFormat.DEFAULT.withHeader(HEADERS))
        ) {

            for (Site site : data) {
                csvPrinter.printRecord(
                        site.id(),
                        site.domain(),
                        site.categories(),
                        site.metrics()
                );
            }

            csvPrinter.flush();
            return out.toByteArray();

        } catch (Exception e) {
            throw new RuntimeException("Failed to export CSV", e);
        }
    }
}
