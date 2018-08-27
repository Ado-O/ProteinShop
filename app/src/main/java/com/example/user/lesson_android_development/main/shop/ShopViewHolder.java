package com.example.user.lesson_android_development.main.shop;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.user.lesson_android_development.data.Shop;
import com.example.user.lesson_android_development.databinding.ShopItemBinding;

public class ShopViewHolder extends RecyclerView.ViewHolder{

   private final ShopItemBinding mBinding;

    public ShopViewHolder(@NonNull ShopItemBinding binding) {
        super(binding.getRoot());

        mBinding=binding;
    }


    public void setup(Shop shop){
        mBinding.setShop(shop);
    }

}
