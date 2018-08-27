package com.example.user.lesson_android_development.data.storage;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Shop;

import java.util.ArrayList;
import java.util.List;

public class ShopRepository {

    private static ShopRepository sShopRepository = null;

    public static ShopRepository getInstance() {
        if (sShopRepository == null) {
            sShopRepository = new ShopRepository();
        }
        return sShopRepository;
    }

    public void getShop(GetShopCallback callback) {

        ArrayList<Shop> objects = new ArrayList<>();
        objects.add(new Shop(R.drawable.image_1, "Stacks","$139.99"));
        objects.add(new Shop(R.drawable.image_1, "Stacks","$139.99"));
        objects.add(new Shop(R.drawable.image_1, "Stacks","$139.99"));
        objects.add(new Shop(R.drawable.image_1, "Stacks","$139.99"));
        objects.add(new Shop(R.drawable.image_1, "Stacks","$139.99"));
        objects.add(new Shop(R.drawable.image_1, "Stacks","$139.99"));
        objects.add(new Shop(R.drawable.image_1, "Stacks","$139.99"));


        if (objects != null) {
            callback.onSuccess(objects, objects);
        } else {
            callback.onError();
        }

    }


    public interface GetShopCallback {
        void onSuccess(List<Shop> shops, List<Shop> bestSellingItem);

        void onError();
    }
}
