package com.example.user.lesson_android_development.main;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Shop;
import com.example.user.lesson_android_development.main.shop.ShopFragment;
import com.example.user.lesson_android_development.util.ActivityUtils;
import com.example.user.lesson_android_development.util.ViewModelFactory;


public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private MainViewModel mMainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        mToolbar = findViewById(R.id.tb_main);
        mMainViewModel = ViewModelFactory.obtainViewModel(this, MainViewModel.class);

        //Setup
        setupToolbar();
        setupFragment();
        setupEvents();
    }

    /**
     * Setting up the toolbar, toolbar actions & title
     */
    private void setupToolbar() {
        //toolbar setup
        setSupportActionBar(mToolbar);
        //setting the toolbar title
        getSupportActionBar().setTitle("Shop");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.clear_white);
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
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    /**
     * button and toast message
     */
    public void onClickBtn(View view) {

        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.FILL_HORIZONTAL, 0, 300);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
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

    /**
     * get clickEvent from MainViewModel
     */
    private void setupEvents() {

        mMainViewModel.getOpenShopEvent().observe(MainActivity.this, new Observer<Shop>() {
            @Override
            public void onChanged(@Nullable Shop shop) {
                Toast.makeText(MainActivity.this, shop.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * FloatActionButton
     */
    public void onClickFAB(View view){
        Toast.makeText(MainActivity.this, "Float button", Toast.LENGTH_SHORT).show();

    }

}

