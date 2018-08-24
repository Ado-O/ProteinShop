package com.example.user.lesson_android_development.main.vertical;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.SingleVertical;
import com.example.user.lesson_android_development.databinding.VerticalSingleRowBinding;

import java.util.ArrayList;

public class VerticalAdapter extends RecyclerView.Adapter {

    ArrayList<SingleVertical> data;
    private LayoutInflater mInflater;

    public VerticalAdapter(Context context, ArrayList<SingleVertical> dataLIst) {

        mInflater = LayoutInflater.from(context);
        data = dataLIst;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VerticalViewHolder(
                VerticalSingleRowBinding.inflate(
                        mInflater,
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((VerticalViewHolder)holder).setup(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}