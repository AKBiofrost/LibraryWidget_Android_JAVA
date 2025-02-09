package com.portafolio.bottomsheetdialogfragment_imagen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {

    private List<String> dataList;
    private Context context;
    private OnItemClickListener onItemClickListener;

    // Define an interface for click events
    public interface OnItemClickListener {
        void onItemClick(int position, Context context);
    }

    // Constructor with OnItemClickListener
    public MyAdapter2(List<String> dataList, OnItemClickListener listener, Context context) {
        this.dataList = dataList;
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.textView.setText(dataList.get(position));
        holder.itemView.setOnClickListener(v -> {
            // Call the onItemClick method from the listener
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position, context);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(android.R.id.text1);
        }
    }
}
