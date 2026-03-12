package com.nick_brogden.data_classification.adapter.analytics.in;

import com.nick_brogden.data_classification.application.analytics.AnalyticsUserCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/analytics")
@RequiredArgsConstructor
public class AnalyticsController {

    private final AnalyticsUserCase analyticsUserCase;

    @GetMapping("/export-csv")
    public ResponseEntity<byte[]> exportCsv(@RequestParam String groupId) {
        byte[] bytes = analyticsUserCase.exportCsv(groupId);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=sites.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(bytes);
    }

}
