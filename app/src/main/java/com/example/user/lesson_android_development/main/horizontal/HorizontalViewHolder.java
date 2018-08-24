package com.example.user.lesson_android_development.main.horizontal;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import com.example.user.lesson_android_development.data.SingleHorizontal;
import com.example.user.lesson_android_development.databinding.HorizontalSingleRowBinding;


public class HorizontalViewHolder extends RecyclerView.ViewHolder {

    private HorizontalSingleRowBinding mBinding;

    public HorizontalViewHolder(@NonNull HorizontalSingleRowBinding binding) {
        super(binding.getRoot());

        mBinding = binding;
    }

    public void setup(SingleHorizontal singleHorizontal) {

        mBinding.setHorizontal(singleHorizontal);
    }


}
