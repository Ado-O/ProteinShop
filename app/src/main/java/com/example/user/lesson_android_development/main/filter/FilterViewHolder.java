package com.example.user.lesson_android_development.main.filter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.example.user.lesson_android_development.data.Tag;
import com.example.user.lesson_android_development.databinding.FilterTagRowBinding;
import com.example.user.lesson_android_development.util.RecyclerViewClickListenerTag;

public class FilterViewHolder extends RecyclerView.ViewHolder {

    private FilterTagRowBinding mBinding;

    public FilterViewHolder(@NonNull FilterTagRowBinding binding, RecyclerViewClickListenerTag listener) {
        super(binding.getRoot());
        mBinding = binding;
        mBinding.setListener(listener);
    }

    public void setup(Tag tag) {
        mBinding.setTag(tag);
    }
}
