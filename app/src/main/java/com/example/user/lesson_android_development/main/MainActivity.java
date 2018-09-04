package com.example.user.lesson_android_development.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.lesson_android_development.Injection;
import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.CartItem;
import com.example.user.lesson_android_development.data.Product;
import com.example.user.lesson_android_development.data.Tag;
import com.example.user.lesson_android_development.data.storage.ProductsRepository;
import com.example.user.lesson_android_development.data.storage.remote.response.BaseResponse;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ProductsRepository mRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        /**
         * send data
         */
        mRepository = Injection.provideProductsRepository(this);
        mRepository.getProductsContent(new ProductsRepository.GetProductsCallback() {
            @Override
            public void onSuccess(List<Product> products) {
                Log.e(TAG, String.valueOf(products.get(0).getTags().size()));
            }

            @Override
            public void onError() {

            }
        });

        mRepository.getAllTags(new ProductsRepository.GetAllTagsCallback() {
            @Override
            public void onSuccess(List<Tag> tags) {
                Log.e(TAG, String.valueOf(tags.get(0).getName()));

            }

            @Override
            public void onError() {

            }
        });


    }


}
