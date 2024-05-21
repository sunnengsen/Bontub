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
import com.example.derleng.databinding.ViewHolderItemBinding;
import com.example.derleng.models.AllPlace;
import com.squareup.picasso.Picasso;

public class AllPlaceAdapter extends ListAdapter<AllPlace, AllPlaceAdapter.ProductViewHolder> {

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(AllPlace allPlace);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }
    public AllPlaceAdapter() {
        super(new DiffUtil.ItemCallback<AllPlace>() {
            @Override
            public boolean areItemsTheSame(@NonNull AllPlace oldItem, @NonNull AllPlace newItem) {
                return oldItem == newItem;
            }

            @SuppressLint("DiffUtilEquals")
            @Override
            public boolean areContentsTheSame(@NonNull AllPlace oldItem, @NonNull AllPlace newItem) {
                return oldItem.getId() == newItem.getId();

            }
        });
    }
    public AllPlaceAdapter(AsyncDifferConfig<AllPlace> config){
        super(config);
    }
    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewHolderItemBinding itemBinding = ViewHolderItemBinding.inflate(layoutInflater);
        return new ProductViewHolder(itemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        AllPlace allPlace = getItem(position);
        holder.bind(allPlace);
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        private final ViewHolderItemBinding binding;
        public ProductViewHolder( ViewHolderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(AllPlace allPlace) {
            Picasso.get().load(allPlace.getPageBannerUrl()).into(binding.imageView);
            this.binding.province.setText(allPlace.getProvinceName());
            this.binding.namePlace.setText(allPlace.getPageBannerTitle());

            // Set click listener on imageView
            binding.imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetailActivity.class);
                    intent.putExtra("image_url", allPlace.getPageBannerUrl());
                    intent.putExtra("province_name", allPlace.getProvinceName());
                    intent.putExtra("page_banner_title", allPlace.getPageBannerTitle());
                    intent.putExtra("page_banner_titles", allPlace.getPlaceTypeName());
                    intent.putExtra("section1_photo_url", allPlace.getSection1PhotoUrl());
                    intent.putExtra("section2_photo_url", allPlace.getSection2PhotoUrl());
                    intent.putExtra("section2_photo_url2", allPlace.getSection2PhotoUrl2());
                    intent.putExtra("section3_photo_url", allPlace.getSection3PhotoUrl());
                    intent.putExtra("des", allPlace.getDescription());
                    intent.putExtra("section1_photo_desc", allPlace.getSection1PhotoDesc());
                    intent.putExtra("section2_photo_desc", allPlace.getSection2PhotoDesc());
                    intent.putExtra("section3_photo_desc", allPlace.getSection3PhotoDesc());
                    intent.putExtra("star_count", allPlace.getStarCount());
                    v.getContext().startActivity(intent);

                }
            });

        }

    }
}