package com.example.user.lesson_android_development.main.description;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Description;
import com.example.user.lesson_android_development.data.Product;
import com.example.user.lesson_android_development.databinding.DescriptionScrollingBinding;


public class DescriptionActivity extends AppCompatActivity {

    private static final String TAG = DescriptionActivity.class.getSimpleName();

    private DescriptionScrollingBinding mDescriptionScrollingBinding;

    private String mImg;
    private String mNam;
    private String mDsc;
    private String mPrc;

    public static void startActivity(Activity activity, Product product) {

        Intent intent = new Intent(activity, DescriptionActivity.class);
        intent.putExtra("image", product.getPictures());
        intent.putExtra("name", product.getTitle());
        intent.putExtra("discount", product.getPrice());
        intent.putExtra("price", product.getDiscounte());

        activity.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.description_act);

        mDescriptionScrollingBinding = DataBindingUtil.setContentView(this, R.layout.description_scrolling);

        //TODO add toolbar back array
        setupData();
    }

    /**
     * add data in layout
     */
    private void setupData() {

        mNam = getIntent().getExtras().getString("name");
        mDsc = getIntent().getExtras().getString("discount");
        mPrc = getIntent().getExtras().getString("price");
        mImg = getIntent().getExtras().getString("image");


        Description description = new Description(mNam, mDsc, mPrc);
        mDescriptionScrollingBinding.setDescription(description);

    }
}
