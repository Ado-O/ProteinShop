package com.example.user.lesson_android_development.data;

import java.util.List;

public class Description {

    private String mName;
    private String mPrice;
    private String mDiscount;

    public Description(String name, String price, String discount) {
        mName = name;
        mPrice = price;
        mDiscount = discount;

    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPrice() {
        return mPrice;
    }

    public void setPrice(String price) {
        mPrice = price;
    }

    public String getDiscount() {
        return mDiscount;
    }

    public void setDiscount(String discount) {
        mDiscount = discount;
    }
}
