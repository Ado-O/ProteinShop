package com.example.user.lesson_android_development;

import com.example.user.lesson_android_development.data.storage.ShopRepository;

public class Injection {

    public static ShopRepository getShopRepository(){
        return ShopRepository.getInstance();
    }
}
