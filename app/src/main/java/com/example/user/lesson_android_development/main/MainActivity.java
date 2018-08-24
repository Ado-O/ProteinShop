package com.example.user.lesson_android_development.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.SingleHorizontal;
import com.example.user.lesson_android_development.data.SingleVertical;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Object> objects = new ArrayList<>();
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_atv);

        mToolbar = findViewById(R.id.tb_main);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_View);

        MainAdapter adapter = new MainAdapter(this, getObject());
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

    private ArrayList<Object> getObject() {
        objects.add(getHorizontalData().get(0));
        objects.add(getVerticalData().get(0));
        return objects;
    }

    public static ArrayList<SingleVertical> getVerticalData() {

       ArrayList<SingleVertical> singleVerticals = new ArrayList<>();
        singleVerticals.add(new SingleVertical("Jim Carrey", R.drawable.image_1));
        singleVerticals.add(new SingleVertical("Jim Carrey", R.drawable.image_1));
        singleVerticals.add(new SingleVertical("Jim Carrey", R.drawable.image_1));
        singleVerticals.add(new SingleVertical("Jim Carrey", R.drawable.image_1));
        singleVerticals.add(new SingleVertical("Jim Carrey", R.drawable.image_1));
        singleVerticals.add(new SingleVertical("Jim Carrey", R.drawable.image_1));
        return singleVerticals;
    }


    public static ArrayList<SingleHorizontal> getHorizontalData() {

        ArrayList<SingleHorizontal> singleHorizontals = new ArrayList<>();
        singleHorizontals.add(new SingleHorizontal("Jim Carrey", R.drawable.image_1));
        singleHorizontals.add(new SingleHorizontal("Jim Carrey", R.drawable.image_1));
        singleHorizontals.add(new SingleHorizontal("Jim Carrey", R.drawable.image_1));
        singleHorizontals.add(new SingleHorizontal("Jim Carrey", R.drawable.image_1));
        singleHorizontals.add(new SingleHorizontal("Jim Carrey", R.drawable.image_1));
        singleHorizontals.add(new SingleHorizontal("Jim Carrey", R.drawable.image_1));
        return singleHorizontals;
    }


}

