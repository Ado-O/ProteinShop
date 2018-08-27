package com.example.user.lesson_android_development.main;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Shop;
import com.example.user.lesson_android_development.databinding.ShopActBinding;

import java.util.ArrayList;

public class ShopActivity extends AppCompatActivity {

    private ShopActBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this,R.layout.shop_act);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_View);

        ArrayList<Shop> objects = new ArrayList<>();
        objects.add(new Shop(R.drawable.image_1, "Stacks"));
        objects.add(new Shop(R.drawable.image_1, "Stacks"));
        objects.add(new Shop(R.drawable.image_1, "Stacks"));
        objects.add(new Shop(R.drawable.image_1, "Stacks"));


        ShopAdapter adapter = new ShopAdapter(this);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
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
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);

        //Setup
        setupToolbar();

        mBinding.setShopItems(objects);
        mBinding.setBestSellingItems(objects);


    }

    /**
     * Setting up the toolbar, toolbar actions & title
     */
    private void setupToolbar() {
        //toolbar setup
        setSupportActionBar(mBinding.tbMain);
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
//
//    public static ArrayList<Shop> getBestSelling() {
//
//        ArrayList<Shop> bestSelling = new ArrayList<>();
//        bestSelling.add(new Shop(R.drawable.image_1, "Stacks"));
//        bestSelling.add(new Shop(R.drawable.image_1, "Stacks"));
//        bestSelling.add(new Shop(R.drawable.image_1, "Stacks"));
//        return bestSelling;
//    }
//
//    public static ArrayList<Shop> getStacks() {
//
//       ArrayList<Shop> stacks = new ArrayList<>();
//        stacks.add(new Shop(R.drawable.image_1, "Stacks"));
//        stacks.add(new Shop(R.drawable.image_1, "Stacks"));
//        stacks.add(new Shop(R.drawable.image_1, "Stacks"));
//        return stacks;
//    }

}

