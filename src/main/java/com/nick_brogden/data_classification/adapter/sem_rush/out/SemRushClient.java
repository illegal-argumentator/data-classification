package com.nick_brogden.data_classification.adapter.sem_rush.out;

import com.nick_brogden.data_classification.adapter.http.ok_http.OkHttpService;
import com.nick_brogden.data_classification.adapter.http.ok_http.dto.OkResponseBody;
import com.nick_brogden.data_classification.adapter.csv.CsvReader;
import com.nick_brogden.data_classification.adapter.sem_rush.out.mapper.MetricMapper;
import com.nick_brogden.data_classification.adapter.sem_rush.out.path.SemRushPathService;
import com.nick_brogden.data_classification.domain.site.model.Metric;
import com.nick_brogden.data_classification.port.DomainMetricsProvider;
import lombok.RequiredArgsConstructor;
import okhttp3.Request;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class SemRushClient implements DomainMetricsProvider {

    private final CsvReader csvReader;
    private final OkHttpService httpService;
    private final SemRushPathService pathService;

    @Override
    public List<Metric> provide(String domain) {
        Request request = new Request.Builder()
                .url(pathService.getDomainSearch(domain))
                .get()
                .build();

        OkResponseBody response = httpService.execute(request);
        return parseMetrics(response.body());

    }

    private List<Metric> parseMetrics(String body) {
        List<Map<String, String>> parse = csvReader.parse(body);
        return parse.stream().map(MetricMapper::toMetric).toList();
    }
}
