package com.example.user.lesson_android_development.data.storage;

import android.content.Context;

import com.example.user.lesson_android_development.data.Supplement;
import com.example.user.lesson_android_development.data.storage.local.supplement.SupplementLocalDataSource;
import com.example.user.lesson_android_development.data.storage.remote.content.SupplementRemoteDataSource;

import java.util.List;

public class SupplementsRepository {

    public static final String TAG = SupplementsRepository.class.getSimpleName();

    private static SupplementsRepository sContentRepository = null;

    private final SupplementRemoteDataSource mRemoteDataSource;
    private final SupplementLocalDataSource mLocalDataSource;

    public SupplementsRepository(Context context, SupplementRemoteDataSource remoteDataSource, SupplementLocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static SupplementsRepository getInstance(Context context, SupplementRemoteDataSource remoteDataSource, SupplementLocalDataSource localDataSource) {
        if (sContentRepository == null) {
            sContentRepository = new SupplementsRepository(context, remoteDataSource, localDataSource);
        }
        return sContentRepository;
    }

    public void getSupplementContent(final GetSupplementCallback callback) {

        mRemoteDataSource.getSupplements(new SupplementRemoteDataSource.GetSupplementsCallback() {
            @Override
            public void onSuccess(List<Supplement> supplements) {
                mLocalDataSource.getSuplements(supplements,callback);
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
