package com.example.user.lesson_android_development.data.storage.convertor;

import android.util.Log;

import com.example.user.lesson_android_development.data.ProductDescription;
import com.example.user.lesson_android_development.data.ProductImage;
import com.example.user.lesson_android_development.data.Products;
import com.example.user.lesson_android_development.data.storage.remote.response.ProductsResponse;
import com.example.user.lesson_android_development.data.storage.remote.response.SupplementsResponse;

import java.util.ArrayList;
import java.util.List;

public class RemoteToLocal {
    public static final String TAG = RemoteToLocal.class.getSimpleName();

    public static List<Products> productsConvertor(List<ProductsResponse> productsResponses) {

        List<Products> products = new ArrayList<>();

        for (ProductsResponse p : productsResponses) {


            products.add(
                    new Products(
                            p.getId(),
                            p.getTitle(),
                            p.getDes(),
                            p.getPrice(),
                            p.getDiscounte(),
                            p.getPictures().get(0)
                    )

            );
        }
        return products;
    }

    public static List<ProductImage> productImageConverter(
            ProductsResponse productsResponse,
            List<SupplementsResponse> supplementsResponses) {

        List<ProductImage> productImages = new ArrayList<>();

        if (productsResponse.getPictures() != null && productsResponse.getPictures().size() > 0) {
            productImages.add(new ProductImage(productsResponse.getId(), productsResponse.getPictures().get(0)));
        }

        if (productsResponse.getSuplements().size() > 1) {
            for (long sId : productsResponse.getSuplements()) {
                for (SupplementsResponse s : supplementsResponses) {
                    if (sId == s.getId()) {
                        for (String imageUrl : s.getPictures()) {
                            productImages.add(new ProductImage(productsResponse.getId(), imageUrl));
                        }
                        break;
                    }
                }
            }

        }
        return productImages;
    }

    public static List<ProductDescription> productDescriptionConverter(
            ProductsResponse productsResponse,
            List<SupplementsResponse> supplementsResponses) {
        List<ProductDescription> productDescriptions = new ArrayList<>();

        if (productsResponse.getSuplements().size() > 1) {
            for (long sId : productsResponse.getSuplements()) { //get ever id from productResponse
                for (SupplementsResponse s : supplementsResponses) { //get everting from supplementResponse
                    if (sId == s.getId()) { //compare id which we get from productsResponse.getSuplements() to supplementResponse
                        productDescriptions.add(new ProductDescription(productsResponse.getId(), s.getTitle(), s.getDes()));
                        break;
                    }
                }
            }
        }


        return productDescriptions;
    }
}
