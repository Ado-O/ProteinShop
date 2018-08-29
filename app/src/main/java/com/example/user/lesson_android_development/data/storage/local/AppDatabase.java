package com.example.user.lesson_android_development.data.storage.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.user.lesson_android_development.data.Supplement;
import com.example.user.lesson_android_development.data.storage.local.supplement.SupplementsDao;

@Database(entities = {
        Supplement.class
}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract SupplementsDao getSupplementsDao();

    public static final Object sLock = new Object();

    public static AppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app.db").build();
            }
            return INSTANCE;
        }
    }
}
