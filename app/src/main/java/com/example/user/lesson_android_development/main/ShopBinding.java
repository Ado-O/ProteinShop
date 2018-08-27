package com.example.user.lesson_android_development.main;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ShopBinding {


    //image
    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:loadImage"})
    public static void setImage(ImageView view, int img){
        //img
        Glide.with(view.getContext())
                .load(img)
                .into(view);
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:shopItems","app:shopBestSellingItems"})
    public static void setShopItems(RecyclerView recyclerView, List items, List bestSellingItems){

        if(items!=null && items.size() > 0){//TODO check best selling
            ((ShopAdapter)recyclerView.getAdapter()).setItems(items,bestSellingItems);

        }
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:shopBestSellingItems"})
    public static void setShopItems(RecyclerView recyclerView, List bestSellingItems){

        if(bestSellingItems!=null && bestSellingItems.size() > 0){//TODO check best selling
            ((ShopBestSellingAdapter)recyclerView.getAdapter()).setItems(bestSellingItems);
        }
    }
}
