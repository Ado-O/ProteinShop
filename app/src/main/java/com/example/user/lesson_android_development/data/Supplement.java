package com.example.user.lesson_android_development.data;

import java.util.List;

public class Supplement {

    private long mId;
    private String mTitle;
    private String mDes;
    private List<String> mImage;
    private String mPrice;
    private String mDiscounte;

    public Supplement(long id, String title, String des, List<String> image, String price, String discounte) {
        mId = id;
        mTitle = title;
        mDes = des;
        mImage = image;
        mPrice = price;
        mDiscounte = discounte;
    }

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

    public List<String> getImage() {
        return mImage;
    }

    public void setImage(List<String> image) {
        mImage = image;
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