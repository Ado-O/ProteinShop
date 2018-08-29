package com.example.user.lesson_android_development.data.storage.local.supplement;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.user.lesson_android_development.data.Supplement;

import java.util.List;

@Dao
public interface SupplementsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<Supplement> supplements);

    //in this line we teak everting from exercise table
    @Query("SELECT * FROM supplement_table WHERE _id = :id")
    Supplement getSupplement(long id);

    @Query("SELECT * FROM supplement_table")
    List<Supplement> getSupplements();

    @Query("DELETE FROM supplement_table")
    void clear();
}
