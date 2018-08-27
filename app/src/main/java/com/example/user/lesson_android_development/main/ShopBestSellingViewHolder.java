package com.example.user.lesson_android_development.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Shop;
import com.example.user.lesson_android_development.databinding.ShopBestSellingItemBinding;

import java.util.List;

public class ShopBestSellingViewHolder extends RecyclerView.ViewHolder {

    private ShopBestSellingItemBinding mBinding;

    public ShopBestSellingViewHolder(@NonNull ShopBestSellingItemBinding binding) {
        super(binding.getRoot());

        mBinding = binding;

        ShopBestSellingAdapter adapter = new ShopBestSellingAdapter(
                itemView.getContext());
        mBinding.rvBestSelling.setLayoutManager(new LinearLayoutManager(
                        itemView.getContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
        );
        mBinding.rvBestSelling.setAdapter(adapter);

    }

    public void setup(List<Shop> items) {
        mBinding.setItems(items);
    }

}
