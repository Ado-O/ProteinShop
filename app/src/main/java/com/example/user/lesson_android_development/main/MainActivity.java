package com.example.user.lesson_android_development.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.lesson_android_development.Injection;
import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.MostSoldItem;
import com.example.user.lesson_android_development.data.Product;
import com.example.user.lesson_android_development.data.ProductCartItem;
import com.example.user.lesson_android_development.data.Tag;
import com.example.user.lesson_android_development.data.storage.ProductsRepository;

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
            public void onSuccess(List<Product> products, List<MostSoldItem> mostSoldItems) {
                Log.e(TAG, String.valueOf(mostSoldItems.size()));
            }

            @Override
            public void onError() {

            }
        });
    }
}
