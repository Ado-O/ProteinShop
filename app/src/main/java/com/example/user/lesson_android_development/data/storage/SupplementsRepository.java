package com.example.user.lesson_android_development.data.storage;

import android.content.Context;
import android.util.Log;

import com.example.user.lesson_android_development.data.Supplement;
import com.example.user.lesson_android_development.data.storage.remote.content.SupplementRemoteDataSource;
import com.example.user.lesson_android_development.data.storage.remote.response.BaseResponse;

import java.util.List;

public class SupplementsRepository {

    public static final String TAG = SupplementsRepository.class.getSimpleName();

    private static SupplementsRepository sContentRepository = null;

    private final SupplementRemoteDataSource mRemoteDataSource;

    public SupplementsRepository(Context context) {
        mRemoteDataSource = new SupplementRemoteDataSource(context);
    }

    public static SupplementsRepository getInstance(Context context) {
        if (sContentRepository == null) {
            sContentRepository = new SupplementsRepository(context);
        }
        return sContentRepository;
    }

    public void getSupplementContent(final GetSupplementCallback callback) {

        mRemoteDataSource.getSupplements(new SupplementRemoteDataSource.GetSupplementsCallback() {
            @Override
            public void onSuccess(List<Supplement> supplements) {
                callback.onSuccess(supplements);
            }

            @Override
            public void onError() {
                callback.onError();
            }
        });


    }

    public interface GetSupplementCallback {
        void onSuccess(List<Supplement> supplements);

        void onError();
    }
}
