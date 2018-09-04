package com.example.user.lesson_android_development.data.storage.local.cartitem;

import com.example.user.lesson_android_development.data.CartItem;
import com.example.user.lesson_android_development.data.Product;
import com.example.user.lesson_android_development.data.ProductCartItem;
import com.example.user.lesson_android_development.data.storage.ProductsRepository;
import com.example.user.lesson_android_development.data.storage.convertor.RemoteToLocal;
import com.example.user.lesson_android_development.data.storage.local.product.ProductDao;
import com.example.user.lesson_android_development.data.storage.remote.response.BaseResponse;
import com.example.user.lesson_android_development.data.storage.remote.response.ProductsResponse;
import com.example.user.lesson_android_development.util.AppExecutors;

import java.util.List;

public class CartItemLocalDataSource {

    private static CartItemLocalDataSource sInstance = null;

    private final AppExecutors mAppExecutors;
    private final CartItemDao mCartItemDao;
    private final ProductDao mProductDao;

    public CartItemLocalDataSource(
            AppExecutors appExecutors,
            CartItemDao cartItemDao,
            ProductDao productDao) {
        mAppExecutors = appExecutors;
        mCartItemDao = cartItemDao;
        mProductDao = productDao;
    }

    public static CartItemLocalDataSource getInstance(
            AppExecutors appExecutors,
            CartItemDao cartItemDao,
            ProductDao productDao) {
        if (sInstance == null) {
            sInstance = new CartItemLocalDataSource(
                    appExecutors,
                    cartItemDao,
                    productDao);
        }
        return sInstance;
    }

    public void addCartItem(long id, int quantity){
        mCartItemDao.insert(new CartItem(id, quantity));
    }

    public void clearCartItem(long id){
        mCartItemDao.clearCartItem(id);
    }

    public void getCartItems(ProductsRepository.GetCardItemCallback callback) {
        mAppExecutors.diskIO().execute(() -> {

            List<ProductCartItem> productCartItems = mCartItemDao.getProductCartItems();

            mAppExecutors.mainThread().execute(() -> callback.onSuccess(productCartItems));
        });
    }

}
