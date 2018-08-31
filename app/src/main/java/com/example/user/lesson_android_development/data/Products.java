package com.example.user.lesson_android_development.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "products_table")
public class Products {

    @ColumnInfo(name = "_id")
    @PrimaryKey(autoGenerate = true)
    private long mId;

    @ColumnInfo(name = "title")
    private String mTitle;

    @ColumnInfo(name = "description")
    private String mDes;

    @ColumnInfo(name = "pictures")
    private String mPictures;

    @ColumnInfo(name = "price")
    private String mPrice;

    @ColumnInfo(name = "discounte")
    private String mDiscounte;

    @Ignore
    private List<ProductImage> mProductImages = null;

    @Ignore
    private List<ProductDescription> mProductDescriptions = null;

    public Products(long id, String title, String des, String price, String discounte, String pictures) {
        mId = id;
        mTitle = title;
        mDes = des;
        mPrice = price;
        mDiscounte = discounte;
        mPictures = pictures;
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

    public String getPictures() {
        return mPictures;
    }

    public void setPictures(String pictures) {
        mPictures = pictures;
    }

    public List<ProductImage> getProductImages() {
        return mProductImages;
    }

    public void setProductImages(List<ProductImage> productImages) {
        mProductImages = productImages;
    }

    public List<ProductDescription> getProductDescriptions() {
        return mProductDescriptions;
    }

    public void setProductDescriptions(List<ProductDescription> productDescriptions) {
        mProductDescriptions = productDescriptions;
    }
}
