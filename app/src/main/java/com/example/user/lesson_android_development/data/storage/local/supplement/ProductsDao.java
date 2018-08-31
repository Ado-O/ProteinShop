package com.example.user.lesson_android_development.data.storage.local.supplement;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.user.lesson_android_development.data.Products;

import java.util.List;

@Dao
public interface ProductsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Products> products);

    //in this line we teak everting from exercise table
    @Query("SELECT * FROM products_table WHERE _id = :id")
    Products getSupplement(long id);

    @Query("SELECT * FROM products_table")
    List<Products> getSupplements();

    @Query("DELETE FROM products_table")
    void clear();
}
