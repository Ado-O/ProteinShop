package com.example.user.lesson_android_development.main;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.lesson_android_development.R;
import com.example.user.lesson_android_development.data.Shop;
import com.example.user.lesson_android_development.main.bestselling.BestSellingAdapter;
import com.example.user.lesson_android_development.main.stacks.StacksAdapter;

import java.util.ArrayList;

import static com.example.user.lesson_android_development.main.MainActivity.getBestSelling;
import static com.example.user.lesson_android_development.main.MainActivity.getStacks;

public class MainAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final int BESTSELLING = 1;
    private final int STACKS = 2;

    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<Shop> mList;


    public MainAdapter(Context context, ArrayList<Shop> list) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mList = list;
    }

    //this method returns the number according to the Vertical/Horizontal object
    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return BESTSELLING;
        } else {
            return STACKS;
        }
    }

    //this method returns the holder that we've inflated according to the viewtype.
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == BESTSELLING) {
            return new BestSellingView(mInflater.inflate(
                    R.layout.best_selling_item,
                    parent,
                    false));
        } else if (viewType == STACKS) {
            return new StacksView(mInflater.inflate(
                    R.layout.stacks_item,
                    parent,
                    false));
        } else {
            throw new RuntimeException("The type has to be ONE or TWO");
        }

    }

    //here we bind view with data according to the position that we have defined.
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == BESTSELLING)
            bestSellingView((BestSellingView) holder);
        else if (holder.getItemViewType() == STACKS)
            stacksView((StacksView) holder);
    }

    private void bestSellingView(BestSellingView holder) {
        BestSellingAdapter adapter = new BestSellingAdapter(mContext, getBestSelling());
        holder.recyclerView.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
        holder.recyclerView.setAdapter(adapter);
    }

    private void stacksView(StacksView holder) {

        StacksAdapter adapter1 = new StacksAdapter(mContext, getStacks());
        holder.recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        holder.recyclerView.setAdapter(adapter1);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class BestSellingView extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        BestSellingView(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_bestSelling);
        }
    }

    public class StacksView extends RecyclerView.ViewHolder {
        RecyclerView recyclerView;

        StacksView(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.rv_stacks);
        }
    }
}
