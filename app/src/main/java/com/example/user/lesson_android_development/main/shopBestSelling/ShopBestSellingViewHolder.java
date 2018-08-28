package com.example.user.lesson_android_development.main.shopBestSelling;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.user.lesson_android_development.data.Supplement;
import com.example.user.lesson_android_development.databinding.ShopBestSellingItemBinding;
import com.example.user.lesson_android_development.util.RecyclerViewClickListener;

import java.util.List;

public class ShopBestSellingViewHolder extends RecyclerView.ViewHolder {

    private ShopBestSellingItemBinding mBinding;

    public ShopBestSellingViewHolder(@NonNull ShopBestSellingItemBinding binding, RecyclerViewClickListener listener) {
        super(binding.getRoot());

        mBinding = binding;

        ShopBestSellingAdapter adapter = new ShopBestSellingAdapter(
                itemView.getContext(), listener);
        mBinding.rvBestSelling.setLayoutManager(new LinearLayoutManager(
                        itemView.getContext(),
                        LinearLayoutManager.HORIZONTAL,
                        false
                )
        );
        mBinding.rvBestSelling.setAdapter(adapter);

    }

    public void setup(List<Supplement> items) {
        mBinding.setItems(items);
    }

}
