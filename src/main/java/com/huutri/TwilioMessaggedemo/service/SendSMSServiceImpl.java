package com.huutri.TwilioMessaggedemo.service;

import com.huutri.TwilioMessaggedemo.dto.SendRequest;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SendSMSServiceImpl implements SendSMSService {

    private static final String BASE_URL = "https://3gmyqw.api.infobip.com";
    private static final String API_KEY = "App 1cafa5622aed4b29ea3129fb0413c129-98d8be76-a8da-4a6c-8d21-8491bbf4f098";
    private static final String MEDIA_TYPE = "application/json";

    private static final String SENDER = "InfoSMS";
    private static final String RECIPIENT = "84862478150";

    @Autowired
    public SendSMSServiceImpl() {

    }

    @Override
    public void sendSms(SendRequest sendRequest) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        String bodyJson = String.format("{\"messages\":[{\"from\":\"%s\",\"destinations\":[{\"to\":\"%s\"}],\"text\":\"%s\"}]}",
                SENDER,
                RECIPIENT,
                sendRequest.getMessage()
        );

        MediaType mediaType = MediaType.parse(MEDIA_TYPE);
        RequestBody body = RequestBody.create(bodyJson, mediaType);

        Request request = prepareHttpRequest(body);
        Response response = client.newCall(request).execute();

        System.out.println("HTTP status code: " + response.code());
        System.out.println("Response body: " + response.body().string());
    }

    private static Request prepareHttpRequest(RequestBody body) {
        return new Request.Builder()
                .url(String.format("%s/sms/2/text/advanced", BASE_URL))
                .method("POST", body)
                .addHeader("Authorization", API_KEY)
                .addHeader("Content-Type", MEDIA_TYPE)
                .addHeader("Accept", MEDIA_TYPE)
                .build();
    }
}
