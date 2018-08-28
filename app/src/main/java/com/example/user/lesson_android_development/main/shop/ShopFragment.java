package com.example.user.lesson_android_development.main.shop;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.lesson_android_development.data.Shop;
import com.example.user.lesson_android_development.databinding.ShopFragBinding;
import com.example.user.lesson_android_development.main.MainViewModel;
import com.example.user.lesson_android_development.util.RecyclerViewClickListener;
import com.example.user.lesson_android_development.util.ViewModelFactory;

public class ShopFragment extends Fragment implements RecyclerViewClickListener{

    private ShopFragBinding mBinding;
    private Context mContext;
    private MainViewModel mMainViewModelShop;
    private MainViewModel mMainViewModelItems;


    public static ShopFragment newInstance(){ return new ShopFragment();}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = ShopFragBinding.inflate(inflater, container, false);

        mContext = getActivity();

        //shop model
        mMainViewModelShop = ViewModelFactory.obtainViewModel(getActivity(), MainViewModel.class);
        mMainViewModelShop.startShops();

        //items model
        mMainViewModelItems = ViewModelFactory.obtainViewModel(getActivity(), MainViewModel.class);
        mMainViewModelItems.startBestSellingItems();

        setupRecycle();

        return mBinding.getRoot();
    }

    private void setupRecycle(){

        ShopAdapter adapter = new ShopAdapter(mContext, ShopFragment.this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(mContext,2);
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(position==0){
                    return 2;
                }else{
                    return 1;
                }
            }
        });
        mBinding.recyclerView.setLayoutManager(gridLayoutManager);
        mBinding.recyclerView.setAdapter(adapter);

       mBinding.setViewModel(mMainViewModelShop);
       mBinding.setViewModel(mMainViewModelItems);

    }

    @Override
    public void recyclerViewListClicked(View v, Shop shop) {
        mMainViewModelShop.getOpenShopEvent().setValue(shop);
        mMainViewModelItems.getOpenShopEvent().setValue(shop);

    }

}
