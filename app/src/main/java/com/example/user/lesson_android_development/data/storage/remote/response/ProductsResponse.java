package com.example.user.lesson_android_development.data.storage.remote.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class ProductsResponse implements Serializable{


    @SerializedName("id")
    @Expose
    private long mId;

    @SerializedName("name")
    @Expose
    private String mTitle;

    @SerializedName("description")
    @Expose
    private String mDes;

    @SerializedName("pictures")
    @Expose
    private List<String> mPictures = null;

    @SerializedName("price")
    @Expose
    private String mPrice;

    @SerializedName("discounted")
    @Expose
    private String mDiscounte;

    public long getId() {
        return mId;
    }

    public void setId(long id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDes() {
        return mDes;
    }

    public void setDes(String des) {
        mDes = des;
    }

    public List<String> getPictures() {
        return mPictures;
    }

    public void setPictures(List<String> pictures) {
        mPictures = pictures;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getDiscounte() {
        return mDiscounte;
    }

    public void setDiscounte(String discounte) {
        mDiscounte = discounte;
    }
}
