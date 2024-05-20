package com.example.bontub.services;

import com.example.bontub.models.AllPlace;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiService {
    @Headers("Accept-Language: en")
    @GET("api/place/android")
    Call<List<AllPlace>> listAllPlace();
}
