package com.SKP2.ClientApplication.rest;

import com.SKP2.ClientApplication.MainFrame;
import com.SKP2.ClientApplication.dto.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.util.List;

public class RentalService {
    public static final String URL = "http://localhost:8082/api";
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public List<CarDto> getAllCars() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/car")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<CarDto>>() {
            });

        throw new IOException();
    }

    public CarDto getCarById(Long id) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/car/" + id)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, CarDto.class);

        throw new IOException();
    }

    public List<CarDto> sortASC() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/car/sortASC")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<CarDto>>() {
            });

        throw new IOException();
    }

    public List<CarDto> sortDESC() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/car/sortDESC")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<CarDto>>() {
            });

        throw new IOException();
    }

    public List<CarDto> filter(CarFilterDto carFilterDto) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(carFilterDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/car/search")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<CarDto>>() {
            });

        throw new IOException();
    }

    public CarDto registerCar(CarCreateDto carCreateDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(carCreateDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/car/registration")
                .addHeader("authorization", "Bearer " + token)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, CarDto.class);

        throw new IOException();
    }

    public Boolean deleteCar(Long id) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/car/" + id)
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

    public CarDto updateCar(CarDto carDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(carDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/car/")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, CarDto.class);

        throw new IOException();
    }

    public List<CompanyDto> getAllCompanies() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/company")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<CompanyDto>>() {
            });

        throw new IOException();
    }

    public CompanyDto getCompanyById(Long id) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/company/" + id)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, CompanyDto.class);

        throw new IOException();
    }

    public List<CompanyDto> sortCompaniesByRate() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/company/sortCompanies")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<CompanyDto>>() {
            });

        throw new IOException();
    }

    public CompanyDto registerCompany(CompanyCreateDto companyCreateDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(companyCreateDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/company/registration")
                .addHeader("authorization", "Bearer " + token)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, CompanyDto.class);

        throw new IOException();
    }

    public Boolean deleteCompany(Long id) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/company/" + id)
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

    public CompanyDto updateCompany(CompanyDto companyDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(companyDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/company/")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, CompanyDto.class);

        throw new IOException();
    }

    public List<ModelDto> getAllModels() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/model")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<ModelDto>>() {
            });

        throw new IOException();
    }

    public ModelDto getModelById(Long id) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/model/" + id)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, ModelDto.class);

        throw new IOException();
    }

    public ModelDto registerModel(ModelCreateDto modelCreateDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(modelCreateDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/model/registration")
                .addHeader("authorization", "Bearer " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, ModelDto.class);

        throw new IOException();
    }

    public Boolean deleteModel(Long id) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/model/" + id)
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

    public ModelDto updateModel(ModelDto modelDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(modelDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/model/")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, ModelDto.class);

        throw new IOException();
    }

    public ReservationDto addReservation(ReservationCreateDto reservationCreateDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(reservationCreateDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/reservation/")
                .addHeader("authorization", "Bearer " + token)
                .post(body)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, ReservationDto.class);

        throw new IOException();
    }

    public Boolean cancelReservation(Long id) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/reservation/" + id)
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

    public List<ReviewDto> findAll() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/review")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<ReviewDto>>() {
            });

        throw new IOException();
    }

    public ReviewDto findById(Long id) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/review/" + id)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, ReviewDto.class);

        throw new IOException();
    }

    public List<ReviewDto> filterReview(ReviewFilterDto reviewFilterDto) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(reviewFilterDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/review/filterReview")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<ReviewDto>>() {
            });

        throw new IOException();
    }

    public ReviewDto add(ReviewCreateDto reviewCreateDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(reviewCreateDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/review/registration")
                .addHeader("authorization", "Bearer " + token)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful()) {
            return objectMapper.readValue(json, ReviewDto.class);
        }

        throw new IOException();
    }

    public Boolean delete(Long id) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/review/" + id)
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

    public ReviewDto update(ReviewDto reviewDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(reviewDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/review")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful()) {
            return objectMapper.readValue(json, ReviewDto.class);
        }

        throw new IOException();
    }

    public List<TypeDto> getAllTypes() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/type")
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, new TypeReference<List<TypeDto>>() {
            });

        throw new IOException();
    }

    public TypeDto getTypeById(Long id) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/type/" + id)
                .addHeader("authorization", "Bearer " + token)
                .get()
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, TypeDto.class);

        throw new IOException();
    }

    public TypeDto registerType(TypeCreateDto typeCreateDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(typeCreateDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/type/registration")
                .addHeader("authorization", "Bearer " + token)
                .post(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful()) {
            return objectMapper.readValue(json, TypeDto.class);
        }

        throw new IOException();
    }

    public Boolean deleteType(Long id) throws IOException {
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/type/" + id)
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

    public TypeDto updateType(TypeDto typeDto) throws IOException {
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(typeDto));
        String token = MainFrame.getInstance().getToken();

        Request request = new Request.Builder()
                .url(URL + "/rental/type/")
                .addHeader("authorization", "Bearer " + token)
                .put(body)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String json = response.body().string();
        response.body().close();

        if (response.isSuccessful())
            return objectMapper.readValue(json, TypeDto.class);

        throw new IOException();
    }
}
