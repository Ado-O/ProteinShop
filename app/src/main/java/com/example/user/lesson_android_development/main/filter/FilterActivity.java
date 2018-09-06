package com.example.user.lesson_android_development.main.filter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Tag;
import com.example.user.lesson_android_development.util.ActivityUtils;
import com.example.user.lesson_android_development.util.ViewModelFactory;

public class FilterActivity extends AppCompatActivity {

    public static int RC_FILTER = 100;

    public static void startActivity(Activity activity){
        activity.startActivityForResult(new Intent(activity,FilterActivity.class), RC_FILTER);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_act);


        setupFragment();
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

    public void returnToActivity(Tag tag){
        Intent intent=new Intent();
        intent.putExtra("filter",tag.getId());
        setResult(RESULT_OK,intent);
    }
}
