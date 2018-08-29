package com.example.user.lesson_android_development.data.storage.remote.content;


import android.content.Context;
import android.util.Log;

import com.example.user.lesson_android_development.data.Supplement;
import com.example.user.lesson_android_development.data.storage.convertor.RemoteToLocal;
import com.example.user.lesson_android_development.util.MockJson;
import com.example.user.lesson_android_development.data.storage.remote.response.BaseResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class SupplementRemoteDataSource {

    private static final String TAG = SupplementRemoteDataSource.class.getSimpleName();

    private static SupplementRemoteDataSource sInstance;
    private final Context mContext;

    public SupplementRemoteDataSource(Context context) {

        mContext = context;
    }

    public static SupplementRemoteDataSource getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new SupplementRemoteDataSource(context);
        }
        return sInstance;
    }

    public void getSupplements(final GetSupplementsCallback callback) {

        /**
         * cod for MockJson
         */
        BaseResponse baseResponse =
                new Gson().fromJson(
                        MockJson.getJsonFromAsset(
                                mContext, "mock.txt"
                        ),
                        new TypeToken<BaseResponse>() {
                        }.getType()
                );

        callback.onSuccess(RemoteToLocal.productsConvertor(
                baseResponse.getProducts()
        ));

    }

    public interface GetSupplementsCallback {
        void onSuccess(List<Supplement> supplements);

        void onError();
    }
}
