package com.example.user.lesson_android_development.main.card;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.user.lesson_android_development.data.DescriptionList;
import com.example.user.lesson_android_development.data.Product;
import com.example.user.lesson_android_development.databinding.DescriptionBottomSheetBinding;

public class BottomSheetFragment extends BottomSheetDialogFragment {

    private DescriptionBottomSheetBinding mDescriptionBottomSheetBinding;
    private String mImg, mNam, mDsc, mPrc;

    public static void startActivity(Activity activity, Product product){

        Intent intent = new Intent(activity, BottomSheetFragment.class);
        intent.putExtra("image", product.getPictures());
        intent.putExtra("name", product.getTitle());
        intent.putExtra("discount", product.getDiscounte());
        intent.putExtra("price", product.getPrice());

        activity.startActivity(intent);

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDescriptionBottomSheetBinding = DescriptionBottomSheetBinding.inflate(inflater, container, false);

        mNam = getActivity().getIntent().getExtras().getString("name");
        mDsc = getActivity().getIntent().getExtras().getString("discount");
        mPrc = getActivity().getIntent().getExtras().getString("price");
        mImg = getActivity().getIntent().getExtras().getString("image");


        DescriptionList descriptionList = new DescriptionList(mImg, mNam,mPrc,mDsc,null);
        mDescriptionBottomSheetBinding.setDescriptionList(descriptionList);


        return mDescriptionBottomSheetBinding.getRoot();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);

        dialog.setOnShowListener(dialogInterface -> {
            BottomSheetDialog d = (BottomSheetDialog) dialogInterface;

            FrameLayout bottomSheet = (FrameLayout) d.findViewById(android.support.design.R.id.design_bottom_sheet);
            BottomSheetBehavior bsb = BottomSheetBehavior
                    .from(bottomSheet);

            bsb.setState(BottomSheetBehavior.STATE_EXPANDED);

        });


        return dialog;
    }


}
