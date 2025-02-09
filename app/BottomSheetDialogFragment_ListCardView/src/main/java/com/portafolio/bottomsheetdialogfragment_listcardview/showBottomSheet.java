package com.portafolio.bottomsheetdialogfragment_listcardview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class showBottomSheet {

    public static void showBottomSheet_cardView(Activity activity, String[] items, callbackDialog callbackDialog) {
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        View bottomSheetView = activity.getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);

        // Initialize the RecyclerView
        RecyclerView itemRecyclerView = bottomSheetView.findViewById(R.id.itemRecyclerView);
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(activity));

        // Set up the Adapter
        ItemAdapter adapter = new ItemAdapter(items, activity, bottomSheetDialog, new callbackDialog() {
            @Override
            public void ActionAceptar(Context context, String item) {
                callbackDialog.ActionAceptar(context,item);
            }
        });
        itemRecyclerView.setAdapter(adapter);

        // Set the content view and show the dialog
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }

}
