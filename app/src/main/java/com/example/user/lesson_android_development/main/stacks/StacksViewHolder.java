package com.example.user.lesson_android_development.main.stacks;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.user.lesson_android_development.data.Shop;
import com.example.user.lesson_android_development.databinding.StacksItemBinding;

public class StacksViewHolder extends RecyclerView.ViewHolder {

    private StacksItemBinding mBinding;

    public StacksViewHolder(@NonNull StacksItemBinding binding) {
        super(binding.getRoot());

        mBinding = binding;

    }

    public void setup(Shop shop) {

     mBinding.setShop(shop);

    }
}