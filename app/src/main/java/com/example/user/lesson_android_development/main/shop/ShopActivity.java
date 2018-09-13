package com.example.user.lesson_android_development.main.shop;

import android.content.Intent;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.main.description.DescriptionActivity;
import com.example.user.lesson_android_development.main.card.BottomSheetFragment;
import com.example.user.lesson_android_development.main.filter.FilterActivity;
import com.example.user.lesson_android_development.util.ActivityUtils;
import com.example.user.lesson_android_development.util.ViewModelFactory;


public class ShopActivity extends AppCompatActivity {

    private static final String TAG = ShopActivity.class.getSimpleName();
    private Toolbar mToolbar;
    private ShopViewModel mShopViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shop_act);

        mToolbar = findViewById(R.id.tb_main);
        mShopViewModel = ViewModelFactory.obtainViewModel(this, ShopViewModel.class);

        //Setup
        setupToolbar();
        setupFragment();
        setupEvents();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == FilterActivity.RC_FILTER && resultCode == RESULT_OK) {
            Log.e(TAG, String.valueOf(data.getExtras().get("filter")));

            mShopViewModel.getFilterItem(data.getExtras().getLong("filter"));

        }

    }

    /**
     * Setting up the toolbar, toolbar actions & title
     */
    private void setupToolbar() {
        //toolbar setup
        setSupportActionBar(mToolbar);
        //setting the toolbar title
        getSupportActionBar().setTitle("Shop");
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
     * setting overflow menu
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_contacts:
                FilterActivity.startActivity(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * Fragment
     */
    private void setupFragment() {
        ActivityUtils.replaceFragmentInActivity(
                getSupportFragmentManager(),
                ShopFragment.newInstance(),
                R.id.frag_shop

        );
    }

    /**
     * get clickEvent from MainViewModel
     */
    private void setupEvents() {

        mShopViewModel.getOpenShopEvent().observe(ShopActivity.this, product ->
                DescriptionActivity.startActivity(ShopActivity.this, product)
        );

        mShopViewModel.getOpenShopEvent().observe(ShopActivity.this, product ->
                BottomSheetFragment.startActivity(ShopActivity.this, product)
        );
    }

    /**
     * FloatActionButton
     */
    public void onClickMainFAB(View view) {
       //TODO connect fab with bottomSheet
//        BottomSheetDialogFragment bottomSheetDialogFragment = new BottomSheetFragment();
//        bottomSheetDialogFragment.show(getSupportFragmentManager(), "Bottom Sheet Dialog Fragment");

    }

}