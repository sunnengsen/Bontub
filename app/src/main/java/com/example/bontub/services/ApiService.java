package com.example.bontub.services;

import com.example.bontub.models.AllPlace;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("api/v1/banner")
    Call<List<AllPlace>> listAllPlace();
}
