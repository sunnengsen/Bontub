package com.example.bontub.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncDifferConfig;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bontub.databinding.ViewHolderItemBinding;
import com.example.bontub.models.AllPlace;
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

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private final ViewHolderItemBinding binding;
        public ProductViewHolder( ViewHolderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        public void bind(AllPlace allPlace) {
            Picasso.get().load(allPlace.getPhotoUrl()).into(binding.imageView);
            this.binding.titleText.setText(String.valueOf(allPlace.getId()));

            itemView.setOnClickListener(v->{
                if (listener != null){
                    listener.onItemClick(allPlace);
                }
            });
        }

    }
}
