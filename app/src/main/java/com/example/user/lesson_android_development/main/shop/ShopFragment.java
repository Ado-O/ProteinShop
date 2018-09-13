package com.example.user.lesson_android_development.main.shop;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.lesson_android_development.data.Product;
import com.example.user.lesson_android_development.data.Tag;
import com.example.user.lesson_android_development.databinding.ShopFragBinding;
import com.example.user.lesson_android_development.main.card.CardActivity;
import com.example.user.lesson_android_development.main.filter.FilterViewModel;
import com.example.user.lesson_android_development.util.RecyclerViewClickListener;
import com.example.user.lesson_android_development.util.ViewModelFactory;


public class ShopFragment extends Fragment implements RecyclerViewClickListener {

    private static final String TAG = ShopFragment.class.getSimpleName();

    private ShopFragBinding mBinding;
    private Context mContext;
    private ShopViewModel mMainViewModelProduct;
    private ShopViewModel mMainViewModelBestSelling;
    private long tadId;

    public static ShopFragment newInstance() {
        return new ShopFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = ShopFragBinding.inflate(inflater, container, false);

        mContext = getActivity();

        mMainViewModelProduct = ViewModelFactory.obtainViewModel(getActivity(), ShopViewModel.class);
        mMainViewModelProduct.startProduct(tadId);

        mMainViewModelBestSelling = ViewModelFactory.obtainViewModel(getActivity(), ShopViewModel.class);
        mMainViewModelBestSelling.startBestSelling();


        setupRecycle();
        onClickCheckout();

        return mBinding.getRoot();
    }

    private void setupRecycle() {

        ShopAdapter adapter = new ShopAdapter(mContext, ShopFragment.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext, 2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position == 0) {
                    return 2;
                } else {
                    return 1;
                }
            }
        });
        mBinding.recyclerView.setLayoutManager(gridLayoutManager);
        mBinding.recyclerView.setAdapter(adapter);

        mBinding.setViewModel(mMainViewModelProduct);
        mBinding.setViewModel(mMainViewModelBestSelling);

    }


    @Override
    public void recyclerViewListClicked(View v, Product product) {
        mMainViewModelProduct.getOpenShopEvent().setValue(product);
        mMainViewModelBestSelling.getOpenShopEvent().setValue(product);
    }

    /**
     * open second activity that is CardActivity
     */
    public void onClickCheckout() {
        mBinding.btnCheckout.setOnClickListener(v -> {
           CardActivity.startActivity(getActivity());
        });

    }
}
