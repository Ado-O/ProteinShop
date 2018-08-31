package com.example.user.lesson_android_development.data.storage.remote.response;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class BaseResponse implements Serializable {

    @SerializedName("suplements")
    @Expose
    private List<SupplementsResponse> mSuplements;

    @SerializedName("products")
    @Expose
    private List<ProductsResponse> mProducts;

    public List<SupplementsResponse> getSuplements() {
        return mSuplements;
    }

    public void setSuplements(List<SupplementsResponse> suplements) {
        mSuplements = suplements;
    }

    public List<ProductsResponse> getProducts() {
        return mProducts;
    }

    public void setProducts(List<ProductsResponse> products) {
        mProducts = products;
    }

}
