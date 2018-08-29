package com.example.user.lesson_android_development.data.storage.convertor;

import com.example.user.lesson_android_development.data.Supplement;
import com.example.user.lesson_android_development.data.storage.remote.response.ProductsResponse;

import java.util.ArrayList;
import java.util.List;

public class RemoteToLocal {

    public static List<Supplement> productsConvertor(List<ProductsResponse> productsResponses){

        List<Supplement> supplements = new ArrayList<>();

        for(ProductsResponse p : productsResponses){
            supplements.add(
                    new Supplement(
                            p.getId(),
                            p.getTitle(),
                            p.getDes(),
                            p.getPictures(),
                            p.getPrice(),
                            p.getDiscounte())
            );
        }
        return supplements;
    }
}
