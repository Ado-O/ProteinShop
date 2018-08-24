package com.example.user.lesson_android_development.main.vertical;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.SingleVertical;
import com.example.user.lesson_android_development.databinding.VerticalSingleRowBinding;

public class VerticalViewHolder extends RecyclerView.ViewHolder {

    private VerticalSingleRowBinding mBinding;

    public VerticalViewHolder(@NonNull VerticalSingleRowBinding binding) {
        super(binding.getRoot());

        mBinding = binding;

    }

    public void setup(SingleVertical singleVertical) {

     mBinding.setVertical(singleVertical);

    }
}