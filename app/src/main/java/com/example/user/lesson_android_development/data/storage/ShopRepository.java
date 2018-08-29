package com.example.user.lesson_android_development.data.storage;

import com.example.user.lesson_android_development.data.Supplement;

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

        /*
        data
        ArrayList<Supplement> objects = new ArrayList<>();
        objects.add(new Supplement(R.drawable.image_1, "Protein","$139.99"));
        objects.add(new Supplement(R.drawable.image_2, "Whey protein","$120.99"));
        objects.add(new Supplement(R.drawable.image_1, "Casein protein","$58.99"));
        objects.add(new Supplement(R.drawable.image_3, "Creatin","$22.99"));
        objects.add(new Supplement(R.drawable.image_2, "Amino protein","$99.99"));
        objects.add(new Supplement(R.drawable.image_3, "Gainer protein","$11.99"));
        objects.add(new Supplement(R.drawable.image_1, "Granola protein","$100.99"));
        if (objects != null) {
            callback.onSuccess(objects, objects);
        } else {
            callback.onError();
        }
 */
    }

    public interface GetShopCallback {
        void onSuccess(List<Supplement> supplements, List<Supplement> bestSellingItem);

        void onError();
    }
}

