package com.example.user.lesson_android_development.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.example.user.lesson_android_development.data.Shop;
import com.example.user.lesson_android_development.data.storage.ShopRepository;
import com.example.user.lesson_android_development.util.SingleLiveEvent;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final ShopRepository mShopRepository;

    public final ObservableList<Shop> mShops = new ObservableArrayList<>();

    public final ObservableBoolean mError = new ObservableBoolean(false);

    private final SingleLiveEvent<Shop> mOpenShopEvent = new SingleLiveEvent<>();


    public MainViewModel(@NonNull Application application, ShopRepository shopRepository) {
        super(application);

        mShopRepository = shopRepository;
    }

    public void startShops() {
        if (mShops.isEmpty()) {
            getShop();
        }
    }

    public void getShop() {

        mShopRepository.getShop(new ShopRepository.GetShopCallback() {
            @Override
            public void onSuccess(List<Shop> shops) {
                mShops.clear();
                mShops.addAll(shops);
                mError.set(mShops.isEmpty());
            }

            @Override
            public void onError() {

            }
        });
    }

    }

