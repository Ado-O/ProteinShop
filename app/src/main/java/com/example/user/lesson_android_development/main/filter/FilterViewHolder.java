package com.example.user.lesson_android_development.main.filter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.user.lesson_android_development.data.Tag;
import com.example.user.lesson_android_development.databinding.FilterTagRowBinding;

public class FilterViewHolder extends RecyclerView.ViewHolder {

    private FilterTagRowBinding mBinding;

    public FilterViewHolder(@NonNull FilterTagRowBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void setup(Tag tag){
        mBinding.setTag(tag);
    }
}
