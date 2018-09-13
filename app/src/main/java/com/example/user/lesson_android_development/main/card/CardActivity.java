package com.example.user.lesson_android_development.main.card;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.main.shop.ShopActivity;
import com.example.user.lesson_android_development.util.ActivityUtils;

public class CardActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    public static void startActivity(Activity activity) {
        Intent intent = new Intent(activity, CardActivity.class);
        activity.startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_act);

        mToolbar = findViewById(R.id.tlb_card);
        setupToolbar();
        setupFragment();

    }

    /**
     * Setting up the toolbar, toolbar actions & title
     */
    private void setupToolbar() {
        //toolbar setup
        setSupportActionBar(mToolbar);
        //setting the toolbar title
        getSupportActionBar().setTitle("Cart");
        //  getSupportActionBar().setHomeAsUpIndicator(R.drawable.clear_white);
        //setting up the back button on the toolbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    /**
     * OnClickListener for the toolbar back button
     */
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    /**
     * Fragment
     */
    private void setupFragment() {
//        ActivityUtils.replaceFragmentInActivity(
//                getSupportFragmentManager(),
//                CardFragment.newInstance(),
//                R.id.frag_card
//
//        );
    }

}
