package com.SKP2.ClientApplication.rest;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class UserService {
    public static final String URL = "http://localhost:8080/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public TokenResponseDto login(TokenRequestDto tokenRequestDto) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(tokenRequestDto));

        Request request = new Request.Builder()
                .url(URL + "/users/login")
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.code() == 200) {
            return objectMapper.readValue(json, TokenResponseDto.class);
        }
        throw new IOException();
    }

    public List<ClientDto> getAllClients() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/client")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<ClientDto>>() {
            });
        throw new IOException();
    }

    public ClientDto getClientById(Long id) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/client/" + id)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, ClientDto.class);

        throw new IOException();
    }

    public DiscountDto getDiscount(Long id) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/client/" + id + "/discount")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, DiscountDto.class);

        throw new IOException();
    }

    public ClientDto registerClient(ClientCreateDto clientCreateDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(clientCreateDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/client/registration")
                .addHeader("authorization", "Bearer " + token)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful()) {
            return objectMapper.readValue(json, ClientDto.class);
        }

        throw new IOException();
    }

    public Boolean deleteClient(Long id) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/client/" + id)
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

    public ClientDto updateClient(ClientDto clientDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(clientDto));

        Request request = new Request.Builder()
                .url(URL + "/users/client")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, ClientDto.class);

        throw new IOException();
    }

    public Boolean verificationEmail(String link) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/client/registration/" + link)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        response.body().close();

        if (response.isSuccessful())
            return true;

        throw new IOException();
    }

    public List<ManagerDto> getAllManagers() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/manager")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<ManagerDto>>() {
            });

        throw new IOException();
    }

    public ManagerDto getManagerById(Long id) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/manager/" + id)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, ManagerDto.class);

        throw new IOException();
    }

    public ManagerDto registerManager(ManagerCreateDto managerCreateDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(managerCreateDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/manager/registration")
                .addHeader("authorization", "Bearer " + token)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful()) {
            return objectMapper.readValue(json, ManagerDto.class);
        }

        throw new IOException();
    }

    public Boolean deleteManager(Long id) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/manager/" + id)
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

    public ManagerDto updateManager(ManagerDto managerDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(managerDto));

        Request request = new Request.Builder()
                .url(URL + "/users/manager")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, ManagerDto.class);

        throw new IOException();
    }

    public Boolean verificationEmailManager(String link) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/manager/registration/" + link)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        response.body().close();

        if (response.isSuccessful())
            return true;

        throw new IOException();
    }

    public AdminDto getAdminById(Long id) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/admin/" + id)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, AdminDto.class);

        throw new IOException();
    }

    public AdminDto updateAdmin(AdminDto adminDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(adminDto));

        Request request = new Request.Builder()
                .url(URL + "/users/admin")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, AdminDto.class);

        throw new IOException();
    }

    public Boolean forbid(Long id) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/users/admin/forbid/" + id)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        response.body().close();

        if (response.isSuccessful())
            return true;

        throw new IOException();
    }

    public RankDto addRank(RankCreateDto rankCreateDto) throws IOException {
        String token = MainFrame.getInstance().getToken();
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(rankCreateDto));

        Request request = new Request.Builder()
                .url(URL + "/users/admin/setRank")
                .addHeader("authorization", "Bearer " + token)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful()) {
            return objectMapper.readValue(json, RankDto.class);
        }

        throw new IOException();
    }
}
