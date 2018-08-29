package com.example.user.lesson_android_development.data.storage.remote.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BaseResponse implements Serializable {

    @SerializedName("products")
    @Expose
    public List<ProductsResponse> mProducts;

    public List<ProductsResponse> getProducts() {
        return mProducts;
    }

    public void setProducts(List<ProductsResponse> products) {
        mProducts = products;
    }

}
