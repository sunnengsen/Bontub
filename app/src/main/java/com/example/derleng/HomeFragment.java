package com.example.derleng;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.derleng.adapters.AllPlaceAdapter;
import com.example.derleng.adapters.RecommendAdapter;
import com.example.derleng.databinding.FragmentHomeBinding;
import com.example.derleng.models.AllPlace;
import com.example.derleng.models.Recommend;
import com.example.derleng.services.ApiService;
import com.example.derleng.services.RecommendService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        loadProfileList();
        return binding.getRoot();
    }

    private void loadProfileList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.derleng.site")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Load AllPlace list
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<AllPlace>> allPlaceTask = apiService.listAllPlace();
        allPlaceTask.enqueue(new retrofit2.Callback<List<AllPlace>>() {
            @Override
            public void onResponse(Call<List<AllPlace>> call, retrofit2.Response<List<AllPlace>> response) {
                if (response.isSuccessful()) {
                    showAllPlace(response.body());
                    Log.v("Response", "Success: " + response.body());
                } else {
                    Log.v("Response", "Error: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<AllPlace>> call, Throwable t) {
                Log.v("Response", "Error: " + t.getMessage());
            }
        });

        // Load Recommend list
        RecommendService recommendService = retrofit.create(RecommendService.class);
        Call<List<Recommend>> recommendTask = recommendService.listRecommend();
        recommendTask.enqueue(new retrofit2.Callback<List<Recommend>>() {
            @Override
            public void onResponse(Call<List<Recommend>> call, retrofit2.Response<List<Recommend>> response) {
                if (response.isSuccessful()) {
                    showAllPlaces(response.body());
                    Log.v("Response", "Success: " + response.body());
                } else {
                    Log.v("Response", "Error: " + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<List<Recommend>> call, Throwable t) {
                Log.v("Response", "Error: " + t.getMessage());
            }
        });
    }
    private void showAllPlace(List<AllPlace> allPlaces) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerViews.setLayoutManager(linearLayoutManager);
        AllPlaceAdapter allPlaceAdapter = new AllPlaceAdapter();
        allPlaceAdapter.submitList(allPlaces);
        binding.recyclerViews.setAdapter(allPlaceAdapter);
        allPlaceAdapter.setOnItemClickListener(allPlace -> {
            Intent intent = new Intent(getContext(), PlaceFragment.class);
            intent.putExtra("place_id", allPlace.getId());
            startActivity(intent);
        });
    }
    private void showAllPlaces(List<Recommend> recommends) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        binding.recyclerRecommend.setLayoutManager(linearLayoutManager);
        RecommendAdapter recommendAdapter = new RecommendAdapter();
        recommendAdapter.submitList(recommends);
        binding.recyclerRecommend.setAdapter(recommendAdapter);
        recommendAdapter.setOnItemClickListener(recommend -> {
            Intent intent = new Intent(getContext(), PlaceFragment.class);
            intent.putExtra("place_id", recommend.getId());
            startActivity(intent);
        });
    }
}
