package com.example.user.lesson_android_development.main.horizontal;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class HorizontalBinding {


    //image
    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:loadImage"})
    public static void setImage(ImageView view, int img){
        //img
        Glide.with(view.getContext())
                .load(img)
                .into(view);
    }
}
