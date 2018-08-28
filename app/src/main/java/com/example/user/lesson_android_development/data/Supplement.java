package com.example.user.lesson_android_development.data;

public class Supplement {

    private int mImage;
    private String mTitle;
    private String mPrice;

    public Supplement(int image, String title, String price) {
        this.mImage = image;
        this.mTitle = title;
        this.mPrice = price;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        this.mImage = image;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }
}
