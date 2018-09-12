package com.example.user.lesson_android_development.main.filter;

import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Tag;
import com.example.user.lesson_android_development.main.shop.ShopActivity;
import com.example.user.lesson_android_development.main.shop.ShopFragment;
import com.example.user.lesson_android_development.util.ActivityUtils;
import com.example.user.lesson_android_development.util.ViewModelFactory;

public class FilterActivity extends AppCompatActivity {

    private static final String TAG = FilterActivity.class.getSimpleName();

    public static int RC_FILTER = 100;

    private ImageView mImageView;
    private FilterViewModel mViewModel;

    public static void startActivity(Activity activity) {
        activity.startActivityForResult(new Intent(activity, FilterActivity.class), RC_FILTER);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_act);

        mImageView = findViewById(R.id.iv_clear);
        mViewModel = ViewModelFactory.obtainViewModel(this, FilterViewModel.class);

        setupFragment();
        onClickFAB();
        setupEvents();
    }
    /**
     * back button
     **/
    public void onClickFAB() {

        mImageView.setOnClickListener(v -> finish());
    }

    /**
     * Fragment
     */
    private void setupFragment() {
        ActivityUtils.replaceFragmentInActivity(
                getSupportFragmentManager(),
                FilterFragment.newInstance(),
                R.id.frag_filter
        );
    }


    public void returnToActivity(Tag tag) {
        Intent intent = new Intent();
        intent.putExtra("filter", tag.getId());
        Log.e(TAG, String.valueOf(tag.getId()));
        setResult(RESULT_OK, intent);
        finish();
    }


    /**
     * get clickEvent from MainViewModel
     */
    private void setupEvents() {
        mViewModel.getOpenShopEvent().observe(this, tag ->
                returnToActivity(tag)
        );
    }
}
