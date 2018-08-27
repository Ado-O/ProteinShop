package com.example.user.lesson_android_development.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.main.shop.ShopFragment;
import com.example.user.lesson_android_development.util.ActivityUtils;


public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        mToolbar = findViewById(R.id.tb_main);

        //Setup
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
        getSupportActionBar().setTitle("Shop");
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
     * setting overflow menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * Fragment
     */
    private void setupFragment() {
        ActivityUtils.replaceFragmentInActivity(
                getSupportFragmentManager(),
                ShopFragment.newInstance(),
                R.id.frag_main
        );
    }

}

