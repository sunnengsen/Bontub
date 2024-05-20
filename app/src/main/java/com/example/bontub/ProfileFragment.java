package com.example.bontub;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.example.bontub.adapters.AllPlaceAdapter;
import com.example.bontub.databinding.FragmentProfileBinding;
import com.example.bontub.models.AllPlace;
import com.example.bontub.services.ApiService;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ProfileFragment extends Fragment {
    private FragmentProfileBinding binding;
    @Nullable
    @Override
    public View onCreateView(@Nullable LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentProfileBinding.inflate(inflater, container, false);
        loadProfileList();
        return binding.getRoot();
    }

    private void loadProfileList() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.derleng.site")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<AllPlace>> task = apiService.listAllPlace();
        task.enqueue(new retrofit2.Callback<List<AllPlace>>() {
            @Override
            public void onResponse(Call<List<AllPlace>> call, retrofit2.Response<List<AllPlace>> response) {
                if (response.isSuccessful()) {
                    showAllPlace(response.body());
                    Log.v("Response", "Success: " + response.body());
                }
                else {
                    Log.v("Response", "Error: " + response.errorBody());
                }
            }
            @Override
            public void onFailure(Call<List<AllPlace>> call, Throwable t) {
                Log.v("Response", "Error: " + t.getMessage());
            }
        });
    }
    private void showAllPlace(List<AllPlace> allPlaces){
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        binding.recyclerView.setLayoutManager(gridLayoutManager);
        AllPlaceAdapter allPlaceAdapter = new AllPlaceAdapter();
        allPlaceAdapter.submitList(allPlaces);
        binding.recyclerView.setAdapter(allPlaceAdapter);
        allPlaceAdapter.setOnItemClickListener(allPlace -> {
            Intent intent = new Intent(getContext(), PlaceFragment.class);
            intent.putExtra("place_id", allPlace.getId());
            startActivity(intent);
        });
    }
}