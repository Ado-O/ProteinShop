package com.example.user.lesson_android_development.data.storage.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.user.lesson_android_development.data.ProductDescription;
import com.example.user.lesson_android_development.data.ProductImage;
import com.example.user.lesson_android_development.data.Products;
import com.example.user.lesson_android_development.data.storage.local.productImage.ProductImageDao;
import com.example.user.lesson_android_development.data.storage.local.productdescription.ProductDescriptionDao;
import com.example.user.lesson_android_development.data.storage.local.supplement.ProductsDao;

import java.io.File;

@Database(entities = {
        Products.class, ProductImage.class, ProductDescription.class
}, version = 5, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase INSTANCE;

    public abstract ProductsDao getProductsDao();

    public abstract ProductImageDao getProductImageDao();

    public abstract ProductDescriptionDao getProductDescriptionDao();

    public static final Object sLock = new Object();

    public static AppDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app.db").build();
                pragmaCheckpoint(context);
            }
            return INSTANCE;
        }
    }

    /**
     * cod for db editor
     */
    private static void pragmaCheckpoint(Context context) {
        String dbpath = (context).getDatabasePath("spartan.db").getPath();
        if (ifDBExists(dbpath)) {
            SQLiteDatabase db = SQLiteDatabase.openDatabase(dbpath, null, Context.MODE_PRIVATE);
            Cursor csr = db.rawQuery("PRAGMA wal_checkpoint", null);
            while (csr.moveToNext()) {
                StringBuilder sb = new StringBuilder();
                for (int c = 0; c < csr.getColumnCount(); c++) {
                    sb.append("\n\tColumnName = ").append(csr.getColumnName(c)).append(" Value=").append(csr.getString(c));
                }
                android.util.Log.d("INFO", sb.toString());
            }
            db.close();
        }
    }

    private static boolean ifDBExists(String dbpath) {
        File db = new File(dbpath);
        if (db.exists()) return true;
        File dir = new File(db.getParent());
        if (!dir.exists()) {
            dir.mkdirs();
        }
        return false;
    }
}
