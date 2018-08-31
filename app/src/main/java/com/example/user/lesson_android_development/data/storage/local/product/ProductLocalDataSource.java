package com.example.user.lesson_android_development.data.storage.local.product;

import com.example.user.lesson_android_development.data.Product;
import com.example.user.lesson_android_development.data.storage.ProductsRepository;
import com.example.user.lesson_android_development.data.storage.convertor.RemoteToLocal;
import com.example.user.lesson_android_development.data.storage.local.productImage.ProductImageDao;
import com.example.user.lesson_android_development.data.storage.local.productdescription.ProductDescriptionDao;
import com.example.user.lesson_android_development.data.storage.local.tag.TagDao;
import com.example.user.lesson_android_development.data.storage.remote.response.BaseResponse;
import com.example.user.lesson_android_development.data.storage.remote.response.ProductsResponse;
import com.example.user.lesson_android_development.data.storage.remote.response.SupplementsResponse;
import com.example.user.lesson_android_development.data.storage.remote.response.TagsResponse;
import com.example.user.lesson_android_development.util.AppExecutors;

import java.util.List;

public class ProductLocalDataSource {

    private static ProductLocalDataSource sInstance = null;

    private final ProductDao mProductDao;
    private final AppExecutors mAppExecutors;
    private final ProductImageDao mProductImageDao;
    private final ProductDescriptionDao mProductDescriptionDao;
    private final TagDao mTagDao;


    private ProductLocalDataSource(ProductDao productDao,
                                   AppExecutors appExecutors,
                                   ProductImageDao productImageDao,
                                   ProductDescriptionDao productDescriptionDao,
                                   TagDao tagDao) {
        mProductDao = productDao;
        mAppExecutors = appExecutors;
        mProductImageDao = productImageDao;
        mProductDescriptionDao = productDescriptionDao;
        mTagDao = tagDao;
    }

    public static ProductLocalDataSource getInstance(ProductDao productDao,
                                                     AppExecutors appExecutors,
                                                     ProductImageDao productImageDao,
                                                     ProductDescriptionDao productDescriptionDao,
                                                     TagDao tagDao) {
        if (sInstance == null) {
            sInstance = new ProductLocalDataSource(productDao, appExecutors, productImageDao, productDescriptionDao, tagDao);
        }
        return sInstance;
    }

    /**
     * send this respons in supplementsRepository
     *
     * @param callback - callback from supplementsRepository
     */
    public void getProduct(BaseResponse baseResponse,
                           final ProductsRepository.GetProductsCallback callback) {

        mAppExecutors.diskIO().execute(() -> {

            List<SupplementsResponse> supplements = baseResponse.getSuplements();
            List<ProductsResponse> productsResponses = baseResponse.getProducts();
            List<TagsResponse> tagsResponses = baseResponse.getTagsResponses();

            /**
             * insert data in localDB
             */
            if (productsResponses != null && !productsResponses.isEmpty()) {
                mProductDao.clear();
                mProductImageDao.clear();
                mProductDescriptionDao.clear();


                mProductDao.insert(
                        RemoteToLocal.productsConvertor(productsResponses));

                mTagDao.insert(
                        RemoteToLocal.tagConverter(tagsResponses)
                );

                for (ProductsResponse p : productsResponses) {

                    //image
                    mProductImageDao.insert(
                            RemoteToLocal.productImageConverter(
                                    p,
                                    supplements
                            ));

                    //description
                    mProductDescriptionDao.insert(
                            RemoteToLocal.productDescriptionConverter(
                                    p,
                                    supplements
                            ));

                    //tags
                    mProductDao.clearTags(p.getId());
                    mProductDao.insertProductTags(RemoteToLocal.productTagConverter(
                            p.getId(),
                            p.getTags()
                    ));
                }
            }

            /**
             * get same data from localDB
             */
            final List<Product> products = mProductDao.getSupplements();

            for (Product p : products) {
                //image
                p.setProductImages(mProductImageDao.getProductImage(p.getId()));
                //description
                p.setProductDescriptions(mProductDescriptionDao.getProductDescription(p.getId()));
                //tags
                p.setTags(mProductDao.getProductTags(p.getId()));

            }
            mAppExecutors.mainThread().execute(() -> callback.onSuccess(products));
        });
    }
}
