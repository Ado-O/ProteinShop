package com.example.user.lesson_android_development.main;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableList;
import android.support.annotation.NonNull;

import com.example.user.lesson_android_development.data.Supplement;
import com.example.user.lesson_android_development.data.storage.ShopRepository;
import com.example.user.lesson_android_development.util.SingleLiveEvent;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private final ShopRepository mShopRepository;

    public final ObservableList<Supplement> mSupplements = new ObservableArrayList<>();
    public final ObservableList<Supplement> mBestSellingItems = new ObservableArrayList<>();

    public final ObservableBoolean mError = new ObservableBoolean(false);

    public final SingleLiveEvent<Supplement> mOpenShopEvent = new SingleLiveEvent<>();


    public MainViewModel(@NonNull Application application, ShopRepository shopRepository) {
        super(application);

        mShopRepository = shopRepository;
    }

    /**
     * shops
     */
    public void startShops() {
        if (mSupplements.isEmpty()) {
            getShop();
        }
    }

    private void getShop() {

        mShopRepository.getShop(new ShopRepository.GetShopCallback() {
            @Override
            public void onSuccess(List<Supplement> supplements, List<Supplement> bestSellingItem) {
                mSupplements.clear();
                mSupplements.addAll(supplements);
                mError.set(mSupplements.isEmpty());
            }

            @Override
            public void onError() {

            }
        });
    }

    /**
     * bestSellingItems
     */
    public void startBestSellingItems() {
        if (mBestSellingItems.isEmpty()) {
            getBestSellingItem();
        }
    }

    private void getBestSellingItem() {

        mShopRepository.getShop(new ShopRepository.GetShopCallback() {
            @Override
            public void onSuccess(List<Supplement> supplements, List<Supplement> bestSellingItem) {
                mBestSellingItems.clear();
                mBestSellingItems.addAll(bestSellingItem);
                mError.set(mBestSellingItems.isEmpty());
            }

            @Override
            public void onError() {

            }
        });
    }

    public SingleLiveEvent<Supplement> getOpenShopEvent() {
        return mOpenShopEvent;
    }
}

