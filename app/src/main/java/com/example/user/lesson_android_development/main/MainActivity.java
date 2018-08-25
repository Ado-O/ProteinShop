package com.example.user.lesson_android_development.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Shop;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        mToolbar = findViewById(R.id.tb_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_View);

        ArrayList<Shop> objects = new ArrayList<>();
        objects.add(getBestSelling().get(0));
        objects.add(getStacks().get(0));

        MainAdapter adapter = new MainAdapter(this, objects);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        //Setup
        setupToolbar();
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

    public static ArrayList<Shop> getBestSelling() {

        ArrayList<Shop> bestSelling = new ArrayList<>();
        bestSelling.add(new Shop(R.drawable.image_1, "Stacks"));
        bestSelling.add(new Shop(R.drawable.image_1, "Stacks"));
        bestSelling.add(new Shop(R.drawable.image_1, "Stacks"));
        return bestSelling;
    }

    public static ArrayList<Shop> getStacks() {

       ArrayList<Shop> stacks = new ArrayList<>();
        stacks.add(new Shop(R.drawable.image_1, "Stacks"));
        stacks.add(new Shop(R.drawable.image_1, "Stacks"));
        stacks.add(new Shop(R.drawable.image_1, "Stacks"));
        return stacks;
    }

}

