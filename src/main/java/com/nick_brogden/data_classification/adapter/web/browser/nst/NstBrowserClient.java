package com.nick_brogden.data_classification.adapter.web.browser.nst;

import com.nick_brogden.data_classification.adapter.http.ok_http.OkHttpService;
import com.nick_brogden.data_classification.adapter.http.ok_http.dto.OkResponseBody;
import com.nick_brogden.data_classification.adapter.web.browser.ProfileService;
import com.nick_brogden.data_classification.adapter.web.browser.nst.config.NstProperties;
import com.nick_brogden.data_classification.adapter.web.browser.nst.dto.CreateProfileRequest;
import com.nick_brogden.data_classification.adapter.web.browser.dto.CreateProfileResponse;
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
        return objectMapper.readValue(execute.body(), CreateProfileResponse.class);
    }

    private CreateProfileRequest buildRequest() {
        HashMap<String, String> flags = new HashMap<>();
        flags.put("localization", "Custom");
        flags.put("geolocation", "Custom");
        flags.put("timezone", "Custom");

        CreateProfileRequest.Fingerprint.Geo geo = new CreateProfileRequest.Fingerprint.Geo("US");
        CreateProfileRequest.Fingerprint.Localization localization = new CreateProfileRequest.Fingerprint.Localization(
                "en-US",
                List.of("en-US", "en"),"en-Us", flags);
        CreateProfileRequest.Fingerprint fingerprint = new CreateProfileRequest.Fingerprint(localization, "America/New_York", geo);
        return new CreateProfileRequest(nstProperties.getGroupId(), fingerprint);
    }

}
