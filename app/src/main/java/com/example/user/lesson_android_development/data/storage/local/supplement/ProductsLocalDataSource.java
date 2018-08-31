package com.example.user.lesson_android_development.data.storage.local.supplement;

import com.example.user.lesson_android_development.data.Products;
import com.example.user.lesson_android_development.data.storage.ProductsRepository;
import com.example.user.lesson_android_development.data.storage.convertor.RemoteToLocal;
import com.example.user.lesson_android_development.data.storage.local.productImage.ProductImageDao;
import com.example.user.lesson_android_development.data.storage.remote.response.BaseResponse;
import com.example.user.lesson_android_development.data.storage.remote.response.ProductsResponse;
import com.example.user.lesson_android_development.data.storage.remote.response.SupplementsResponse;
import com.example.user.lesson_android_development.util.AppExecutors;

import java.util.List;

public class ProductsLocalDataSource {

    private static ProductsLocalDataSource sInstance = null;

    private final ProductsDao mProductsDao;
    private final AppExecutors mAppExecutors;
    private final ProductImageDao mProductImageDao;


    private ProductsLocalDataSource(ProductsDao productsDao,
                                    AppExecutors appExecutors,
                                    ProductImageDao productImageDao) {
        mProductsDao = productsDao;

        mAppExecutors = appExecutors;
        mProductImageDao = productImageDao;
    }

    public static ProductsLocalDataSource getInstance(ProductsDao productsDao,
                                                      AppExecutors appExecutors,
                                                      ProductImageDao productImageDao) {
        if (sInstance == null) {
            sInstance = new ProductsLocalDataSource(productsDao, appExecutors, productImageDao);
        }
        return sInstance;
    }

    /**
     * send this respons in supplementsRepository
     *
     * @param callback - callback from supplementsRepository
     */
    public void getProducts(BaseResponse baseResponse,
                            List<Products>products,
                            final ProductsRepository.GetProductsCallback callback) {

        mAppExecutors.diskIO().execute(new Runnable() {
            @Override
            public void run() {

                List < SupplementsResponse > supplements = baseResponse.getSuplements();
                List < ProductsResponse > productsResponses = baseResponse.getProducts();

                /**
                 * insert data in localDB
                 */
                if (productsResponses != null && !productsResponses.isEmpty()) {
                    mProductsDao.clear();
                    mProductImageDao.clear();

                    mProductsDao.insert(
                            RemoteToLocal.productsConvertor(productsResponses));

                    for (ProductsResponse p : productsResponses) {
                        mProductImageDao.insert(
                                RemoteToLocal.productImageConverter(
                                        p,
                                        supplements
                                ));
                    }
                }


                /**
                 * get same data from localDB
                 */
                final List<Products> products = mProductsDao.getSupplements();

                for (Products p : products) {
                    p.setProductImages(mProductImageDao.getProductImage(p.getId()));
                }
                mAppExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        callback.onSuccess(products);
                    }
                });
            }
        });
    }
}
