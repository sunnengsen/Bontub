package com.example.derleng.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.derleng.DetailActivity;
import com.example.derleng.databinding.ActivityPlaceRecommentBinding;
import com.example.derleng.models.AllPlace;
import com.example.derleng.models.Recommend;
import com.squareup.picasso.Picasso;

public class RecommendAdapter extends ListAdapter<Recommend, RecommendAdapter.ProductViewHolder> {
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(AllPlace allPlace);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public RecommendAdapter() {
        super(new DiffUtil.ItemCallback<Recommend>() {
            @Override
            public boolean areItemsTheSame(@NonNull Recommend oldItem, @NonNull Recommend newItem) {
                return oldItem == newItem;
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull Recommend oldItem, @NonNull Recommend newItem) {
                return oldItem.getId() == newItem.getId();
            }
        });
    }

    public RecommendAdapter(AsyncDifferConfig<Recommend> config){
        super(config);
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ActivityPlaceRecommentBinding itemBinding = ActivityPlaceRecommentBinding.inflate(layoutInflater, parent, false);
        return new ProductViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Recommend recommend = getItem(position);
        holder.bind(recommend);
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        private final ActivityPlaceRecommentBinding binding;

        public ProductViewHolder(ActivityPlaceRecommentBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(Recommend recommend) {
            Picasso.get().load(recommend.getPageBannerUrl()).into(binding.imageViews);
            this.binding.provinces.setText(recommend.getProvinceName());
            this.binding.namePlaces.setText(recommend.getPageBannerTitle());
            this.binding.rate.setText(String.valueOf(recommend.getStarCount()));

            binding.imageViews.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra("image_url", recommend.getPageBannerUrl());
                    intent.putExtra("province_name", recommend.getProvinceName());
                    intent.putExtra("page_banner_title", recommend.getPageBannerTitle());
                    intent.putExtra("page_banner_titles", recommend.getPlaceTypeName());
                    intent.putExtra("section1_photo_url", recommend.getSection1PhotoUrl());
                    intent.putExtra("section2_photo_url", recommend.getSection2PhotoUrl());
                    intent.putExtra("section2_photo_url2", recommend.getSection2PhotoUrl2());
                    intent.putExtra("section3_photo_url", recommend.getSection3PhotoUrl());
                    intent.putExtra("des", recommend.getDescription());
                    intent.putExtra("section1_photo_desc", recommend.getSection1PhotoDesc());
                    intent.putExtra("section2_photo_desc", recommend.getSection2PhotoDesc());
                    intent.putExtra("section3_photo_desc", recommend.getSection3PhotoDesc());
                    intent.putExtra("star_count", recommend.getStarCount());
                    v.getContext().startActivity(intent);

                }
            });
        }
    }
}