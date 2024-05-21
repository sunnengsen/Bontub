package com.example.derleng.services;

import com.example.derleng.models.Recommend;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface RecommendService {
    @Headers("Accept-Language: en")
    @GET("api/place/android/recommend")
    Call<List<Recommend>> listRecommend();
}
