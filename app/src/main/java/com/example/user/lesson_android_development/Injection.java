package com.example.user.lesson_android_development;

import android.content.Context;

import com.example.user.lesson_android_development.data.storage.ProductsRepository;
import com.example.user.lesson_android_development.data.storage.local.AppDatabase;
import com.example.user.lesson_android_development.data.storage.local.supplement.ProductsLocalDataSource;
import com.example.user.lesson_android_development.data.storage.remote.content.ProductsRemoteDataSource;
import com.example.user.lesson_android_development.util.AppExecutors;

public class Injection {

    public static AppDatabase provideAppDatabase(Context context) {
        return AppDatabase.getInstance(context.getApplicationContext());
    }

    public static AppExecutors provideAppExecutors() {
        return new AppExecutors();
    }

    public static ProductsRemoteDataSource provideProductsRemoteDataSource(Context context){
        return ProductsRemoteDataSource.getInstance(context);
    }

    public static ProductsLocalDataSource provideProductsLocalDataSource(Context context){
        return ProductsLocalDataSource.getInstance(
                provideAppDatabase(context.getApplicationContext()).getProductsDao(),
                provideAppExecutors(),
                provideAppDatabase(context.getApplicationContext()).getProductImageDao()
        );
    }

    public static ProductsRepository provideProductsRepository(Context context){
        return ProductsRepository.getInstance(
                context,
                provideProductsRemoteDataSource(context),
                provideProductsLocalDataSource(context)
        );
    }

}
