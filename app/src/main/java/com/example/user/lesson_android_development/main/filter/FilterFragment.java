package com.example.user.lesson_android_development.main.filter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.lesson_android_development.data.Product;
import com.example.user.lesson_android_development.data.Tag;
import com.example.user.lesson_android_development.databinding.FilterFragBinding;
import com.example.user.lesson_android_development.util.RecyclerViewClickListener;
import com.example.user.lesson_android_development.util.ViewModelFactory;

public class FilterFragment extends Fragment implements RecyclerViewClickListener {

    private static final String TAG = FilterFragment.class.getSimpleName();

    private FilterFragBinding mBinding;
    private Context mContext;
    private FilterViewModel mViewModel;

    public static FilterFragment newInstance() {
        return new FilterFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = FilterFragBinding.inflate(inflater, container, false);

        mContext = getActivity();

        mViewModel = ViewModelFactory.obtainViewModel(getActivity(), FilterViewModel.class);
        mViewModel.startFilter();

        mBinding.setViewModel(mViewModel);

        setupRecycle();

        return mBinding.getRoot();
    }

    public void setupRecycle() {

        FilterAdapter adapter = new FilterAdapter(mContext);

        mBinding.rvFilter.setLayoutManager(new LinearLayoutManager(
                mContext,
                LinearLayoutManager.VERTICAL,
                false));
        mBinding.rvFilter.setAdapter(adapter);

    }



    @Override
    public void recyclerViewListClicked(View v, Product product) {

    }
}