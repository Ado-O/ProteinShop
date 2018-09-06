package com.example.user.lesson_android_development.util;

import android.view.View;

import com.example.user.lesson_android_development.data.Product;

public interface RecyclerViewClickListener {
    public void recyclerViewListClicked(View v, Product product);
}