package com.example.user.lesson_android_development.main.bestselling;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user.lesson_android_development.data.Shop;
import com.example.user.lesson_android_development.databinding.BestSellingItemBinding;

import java.util.ArrayList;

public class BestSellingAdapter extends RecyclerView.Adapter {

    ArrayList<Shop> data;
    private LayoutInflater mInflater;

    public BestSellingAdapter(Context context, ArrayList<Shop> dataLIst) {

        mInflater = LayoutInflater.from(context);
        data = dataLIst;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BestSellingViewHolder(BestSellingItemBinding.inflate(
               mInflater,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((BestSellingViewHolder) holder).setup(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}