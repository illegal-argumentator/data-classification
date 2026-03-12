package com.nick_brogden.data_classification.adapter.web.browser.nst;

import com.nick_brogden.data_classification.adapter.http.ok_http.OkHttpService;
import com.nick_brogden.data_classification.adapter.http.ok_http.dto.OkResponseBody;
import com.nick_brogden.data_classification.adapter.web.browser.ProfileService;
import com.nick_brogden.data_classification.adapter.web.browser.dto.CreateProfileResponse;
import com.nick_brogden.data_classification.adapter.web.browser.nst.config.NstProperties;
import com.nick_brogden.data_classification.adapter.web.browser.nst.dto.CreateProfileRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class NstBrowserClient implements ProfileService {

    private final ObjectMapper objectMapper;
    private final OkHttpService okHttpService;
    private final NstProperties nstProperties;

    @Override
    public CreateProfileResponse createProfile() {
        String json = objectMapper.writeValueAsString(buildRequest());
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, json);

        Request request = new Request.Builder()
                .url(nstProperties.getUrl() + "/profiles")
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .addHeader("x-api-key", nstProperties.getApiKey())
                .build();

        OkResponseBody execute = okHttpService.execute(request);

        if (!execute.isSuccessful()) {
            log.error("NST response error: {}", execute.body());
            throw new RuntimeException("NST API error: " + execute.body());
        }

        return objectMapper.readValue(execute.body(), CreateProfileResponse.class);
    }

    private CreateProfileRequest buildRequest() {
        HashMap<String, String> flags = new HashMap<>();
        flags.put("localization", "Custom");
        flags.put("geolocation", "Custom");
        flags.put("timezone", "Custom");

        CreateProfileRequest.Fingerprint.Geolocation geolocation = new CreateProfileRequest.Fingerprint.Geolocation("40.7128", "-74.0060", "40");
        CreateProfileRequest.Fingerprint.Localization localization = new CreateProfileRequest.Fingerprint.Localization(
                "America/New_York",
                false,
                "en-US",
                List.of("en-US", "en"), "en-US");
        CreateProfileRequest.Fingerprint fingerprint = new CreateProfileRequest.Fingerprint(flags, localization, geolocation);
        return new CreateProfileRequest(nstProperties.getGroupId(), "Windows", fingerprint);
    }

}
