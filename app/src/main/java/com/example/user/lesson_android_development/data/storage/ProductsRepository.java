package com.example.user.lesson_android_development.data.storage;

import android.content.Context;

import com.example.user.lesson_android_development.data.ProductImage;
import com.example.user.lesson_android_development.data.Products;
import com.example.user.lesson_android_development.data.storage.convertor.RemoteToLocal;
import com.example.user.lesson_android_development.data.storage.local.supplement.ProductsLocalDataSource;
import com.example.user.lesson_android_development.data.storage.remote.content.ProductsRemoteDataSource;
import com.example.user.lesson_android_development.data.storage.remote.response.BaseResponse;

import java.util.List;

public class ProductsRepository {

    public static final String TAG = ProductsRepository.class.getSimpleName();

    private static ProductsRepository sContentRepository = null;

    private final ProductsRemoteDataSource mRemoteDataSource;
    private final ProductsLocalDataSource mLocalDataSource;

    public ProductsRepository(Context context,
                              ProductsRemoteDataSource remoteDataSource,
                              ProductsLocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static ProductsRepository getInstance(
            Context context,
            ProductsRemoteDataSource remoteDataSource,
            ProductsLocalDataSource localDataSource) {

        if (sContentRepository == null) {
            sContentRepository = new ProductsRepository(context, remoteDataSource, localDataSource);
        }
        return sContentRepository;
    }

    public void getProductsContent(final GetProductsCallback callback) {

        mRemoteDataSource.getProducts(new ProductsRemoteDataSource.GetProductsCallback() {
            @Override
            public void onSuccess(BaseResponse baseResponse) {
                mLocalDataSource.getProducts(baseResponse
                        , callback);


            }

            @Override
            public void onError() {

            }
        });


    }

    /**
     * geting data from productsLocalDataSource
     */
    public interface GetProductsCallback {
        void onSuccess(List<Products> products);

        void onError();
    }
}
