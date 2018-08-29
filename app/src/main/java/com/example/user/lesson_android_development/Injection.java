package com.example.user.lesson_android_development;

import android.content.Context;

import com.example.user.lesson_android_development.data.storage.SupplementsRepository;
import com.example.user.lesson_android_development.data.storage.local.AppDatabase;
import com.example.user.lesson_android_development.data.storage.local.supplement.SupplementLocalDataSource;
import com.example.user.lesson_android_development.data.storage.remote.content.SupplementRemoteDataSource;
import com.example.user.lesson_android_development.util.AppExecutors;

public class Injection {

    public static AppDatabase provideAppDatabase(Context context) {
        return AppDatabase.getInstance(context.getApplicationContext());
    }

    public static AppExecutors provideAppExecutors() {
        return new AppExecutors();
    }

    public static SupplementRemoteDataSource provideSupplementRemoteDataSource(Context context){
        return SupplementRemoteDataSource.getInstance(context);
    }

    public static SupplementLocalDataSource provideSupplementLocalDataSource(Context context){
        return SupplementLocalDataSource.getInstance(
                provideAppDatabase(context.getApplicationContext()).getSupplementsDao(),
                provideAppExecutors()
        );
    }

    public static SupplementsRepository provideSupplementsRepository(Context context){
        return SupplementsRepository.getInstance(
                context,
                provideSupplementRemoteDataSource(context),
                provideSupplementLocalDataSource(context)
        );
    }

}
