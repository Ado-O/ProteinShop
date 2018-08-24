package com.example.user.lesson_android_development.main.horizontal;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.SingleHorizontal;
import com.example.user.lesson_android_development.databinding.HorizontalSingleRowBinding;

import java.util.ArrayList;

public class HorizontalAdapter extends RecyclerView.Adapter {

    ArrayList<SingleHorizontal> data;
    private LayoutInflater mInflater;

    public HorizontalAdapter(Context context, ArrayList<SingleHorizontal> dataLIst) {

        mInflater = LayoutInflater.from(context);
        data = dataLIst;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HorizontalViewHolder(HorizontalSingleRowBinding.inflate(
               mInflater,
                parent,
                false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((HorizontalViewHolder) holder).setup(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}