package com.portafolio.bottomsheetdialogfragment_imagen.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.portafolio.bottomsheetdialogfragment_imagen.R;

import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private List<Integer> images;
    private Context context;
    private OnItemClickListener onItemClickListener;

    // Define an interface for click events
    public interface OnItemClickListener {
        void onItemClick(int position, Context context);
    }

    public ImageAdapter(Context context, OnItemClickListener listener, List<Integer> images) {
        this.context = context;
        this.images = images;
        this.onItemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(images.get(position));
        holder.itemView.setOnClickListener(v -> {
            // Call the onItemClick method from the listener
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(position, context);
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
