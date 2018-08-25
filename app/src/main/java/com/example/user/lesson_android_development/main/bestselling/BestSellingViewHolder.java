package com.example.user.lesson_android_development.main.bestselling;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Shop;
import com.example.user.lesson_android_development.databinding.BestSellingItemBinding;


public class BestSellingViewHolder extends RecyclerView.ViewHolder {

    private BestSellingItemBinding mBinding;

    public BestSellingViewHolder(@NonNull BestSellingItemBinding binding) {
        super(binding.getRoot());

        mBinding = binding;

    }

    public void setup(Shop shop) {

        mBinding.setShop(shop);
    }

}
