package com.example.user.lesson_android_development.main;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.user.lesson_android_development.Injection;
import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Supplement;
import com.example.user.lesson_android_development.data.storage.SupplementsRepository;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private SupplementsRepository mRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_act);

        /**
         * send data
         */

        mRepository = Injection.provideSupplementsRepository(this);
        mRepository.getSupplementContent(new SupplementsRepository.GetSupplementCallback() {
            @Override
            public void onSuccess(List<Supplement> supplements) {
                Log.e(TAG, supplements.get(0).getTitle());
            }

            @Override
            public void onError() {

            }
        });




    }


}

