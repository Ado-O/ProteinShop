package com.example.user.lesson_android_development.data.storage.local.supplement;

import com.example.user.lesson_android_development.data.Supplement;
import com.example.user.lesson_android_development.data.storage.SupplementsRepository;
import com.example.user.lesson_android_development.data.storage.convertor.RemoteToLocal;
import com.example.user.lesson_android_development.data.storage.remote.response.ProductsResponse;
import com.example.user.lesson_android_development.util.AppExecutors;

import java.util.List;

public class SupplementLocalDataSource {

    private static SupplementLocalDataSource sInstance = null;

    private final SupplementsDao mSupplementsDao;
    private final AppExecutors mAppExecutors;

    private SupplementLocalDataSource(SupplementsDao supplementsDao, AppExecutors appExecutors) {
        mSupplementsDao = supplementsDao;

        mAppExecutors = appExecutors;
    }

    public static SupplementLocalDataSource getInstance(SupplementsDao supplementsDao, AppExecutors appExecutors) {
        if (sInstance == null) {
            sInstance = new SupplementLocalDataSource(supplementsDao, appExecutors);
        }
        return sInstance;
    }


    public void insertSupplement(List<ProductsResponse> supplementResponse) {

        mSupplementsDao.insert(
                RemoteToLocal.productsConvertor(supplementResponse));
    }

    public void getSuplements(List<Supplement> supplementResponse, final SupplementsRepository.GetSupplementCallback callback) {
        mAppExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {

                if (supplementResponse != null && !supplementResponse.isEmpty()) {
                    mSupplementsDao.clear();

                    mSupplementsDao.insert(
                            supplementResponse);
                }


                final List<Supplement> supplements = mSupplementsDao.getSupplements();

                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(supplements);
                    }
                });
            }
        });
    }


    public interface GetSupplementsCallback {
        void onSuccess(List<Supplement> supplements);

        void onError();
    }
}
