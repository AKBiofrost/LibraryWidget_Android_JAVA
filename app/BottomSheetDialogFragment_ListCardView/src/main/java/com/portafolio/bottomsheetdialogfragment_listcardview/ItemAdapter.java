package com.portafolio.bottomsheetdialogfragment_listcardview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private String[] items;
    private Activity activity;
    private BottomSheetDialog bottomSheetDialog;
    private callbackDialog callbackDialog;

    public ItemAdapter(String[] items, Activity activity, BottomSheetDialog bottomSheetDialog, callbackDialog callbackDialog) {
        this.items = items;
        this.activity = activity;
        this.bottomSheetDialog = bottomSheetDialog;
        this.callbackDialog=callbackDialog;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = items[position];
        holder.itemTextView.setText(item);

        holder.itemView.setOnClickListener(v -> {

            bottomSheetDialog.dismiss();
            callbackDialog.ActionAceptar(activity,item);
        });
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.itemTextView);
        }
    }
}
