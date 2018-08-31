package com.example.user.lesson_android_development.data.storage.local.product;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.user.lesson_android_development.data.Product;
import com.example.user.lesson_android_development.data.ProductTag;
import com.example.user.lesson_android_development.data.Tag;

import java.util.List;

@Dao
public interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Product> products);

    //in this line we teak everting from exercise table
    @Query("SELECT * FROM products_table WHERE _id = :id")
    Product getSupplement(long id);

    @Query("SELECT * FROM products_table")
    List<Product> getSupplements();

    @Query("DELETE FROM products_table")
    void clear();

    @Query("SELECT tag_table.* FROM tag_table INNER JOIN product_tag_table ON " +
            "tag_table._id= product_tag_table.tag_id WHERE product_tag_table.product_id = :productId")
    List<Tag> getProductTags(long productId);

    @Insert
    void insertProductTags(List<ProductTag> productTags);

    @Query("DELETE FROM product_tag_table WHERE product_id=:productId")
    void clearTags(long productId);
}
