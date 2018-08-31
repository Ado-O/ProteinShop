package com.example.user.lesson_android_development.data.storage;

import com.example.user.lesson_android_development.data.Product;
import com.example.user.lesson_android_development.data.storage.local.product.ProductLocalDataSource;
import com.example.user.lesson_android_development.data.storage.remote.content.ProductsRemoteDataSource;
import com.example.user.lesson_android_development.data.storage.remote.response.BaseResponse;

import java.util.List;

public class ProductsRepository {

    public static final String TAG = ProductsRepository.class.getSimpleName();

    private static ProductsRepository sContentRepository = null;

    private final ProductsRemoteDataSource mRemoteDataSource;
    private final ProductLocalDataSource mLocalDataSource;

    public ProductsRepository(ProductsRemoteDataSource remoteDataSource,
                              ProductLocalDataSource localDataSource) {
        mRemoteDataSource = remoteDataSource;
        mLocalDataSource = localDataSource;
    }

    public static ProductsRepository getInstance(
            ProductsRemoteDataSource remoteDataSource,
            ProductLocalDataSource localDataSource) {

        if (sContentRepository == null) {
            sContentRepository = new ProductsRepository(remoteDataSource, localDataSource);
        }
        return sContentRepository;
    }

    public void getProductsContent(final GetProductsCallback callback) {

        mRemoteDataSource.getProducts(new ProductsRemoteDataSource.GetProductsCallback() {
            @Override
            public void onSuccess(BaseResponse baseResponse) {
                mLocalDataSource.getProduct(
                        baseResponse
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
        void onSuccess(List<Product> products);

        void onError();
    }
}
