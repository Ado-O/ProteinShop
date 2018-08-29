package com.example.user.lesson_android_development.main.shop;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.user.lesson_android_development.main.shopBestSelling.ShopBestSellingAdapter;

import java.util.List;

public class ShopBinding {

    /*
    image Glide
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:loadImage"})
    public static void setImage(ImageView view, int img){
        //img
//        Glide.with(view.getContext())
//                .load(img)
//                .into(view);
    }

    /*
   passing data through Adapter
     */
    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:shopItems","app:shopBestSellingItems"})
    public static void setShopItems(RecyclerView recyclerView, List items, List bestSellingItems){

        if(items!=null && items.size() > 0){
            ((ShopAdapter)recyclerView.getAdapter()).setItems(items, bestSellingItems);
        }
    }

    /*
  passing data through Adapter
    */
    @SuppressWarnings("unchecked")
    @BindingAdapter({"app:shopBestSellingItems"})
    public static void setBestSellingItems(RecyclerView recyclerView, List bestSellingItems){

        if(bestSellingItems!=null && bestSellingItems.size() > 0){
            ((ShopBestSellingAdapter)recyclerView.getAdapter()).setItems(bestSellingItems);
        }
    }
}
