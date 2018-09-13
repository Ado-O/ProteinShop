package com.example.user.lesson_android_development.main.card;

import android.support.v4.app.Fragment;

import com.example.user.lesson_android_development.main.shop.ShopFragment;

public class CardFragment extends Fragment {

    public static ShopFragment newInstance() {
        return new ShopFragment();
    }

}
