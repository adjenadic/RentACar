package com.SKP2.ClientApplication.rest;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.EmailDto;
import com.SKP2.ClientApplication.dto.FilterEmailDto;
import com.SKP2.ClientApplication.dto.NotificationTypeCreateDto;
import com.SKP2.ClientApplication.dto.NotificationTypeDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class NotificationService {
    public static final String URL = "http://localhost:8081/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public List<EmailDto> getAllEmails() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/notifications/email")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<EmailDto>>() {
            });

        throw new IOException();
    }

    public List<EmailDto> getFilterEmails(FilterEmailDto filterEmailDto) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(filterEmailDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/notifications/email/filter")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<EmailDto>>() {
            });
        throw new IOException();
    }

    public List<NotificationTypeDto> getAllNotificationTypes() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/notifications/notificationType")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<NotificationTypeDto>>() {
            });

        throw new IOException();
    }

    public NotificationTypeDto getNotificationTypeById(Long id) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/notifications/notificationType/" + id)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.code() == 200)
            return objectMapper.readValue(json, NotificationTypeDto.class);

        throw new IOException();
    }

    public NotificationTypeDto registerNotificationType(NotificationTypeCreateDto notificationTypeCreateDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(notificationTypeCreateDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/notifications/notificationType/registration")
                .addHeader("authorization", "Bearer " + token)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, NotificationTypeDto.class);

        throw new IOException();
    }

    public Boolean deleteNotificationType(Long id) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/notifications/notificationType/" + id)
                .addHeader("authorization", "Bearer " + token)
                .delete()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        response.body().close();

        if (response.isSuccessful())
            return true;

        throw new IOException();
    }

    public NotificationTypeDto updateNotificationType(NotificationTypeDto notificationTypeDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(notificationTypeDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/notifications/notificationType")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, NotificationTypeDto.class);

        throw new IOException();
    }
}
