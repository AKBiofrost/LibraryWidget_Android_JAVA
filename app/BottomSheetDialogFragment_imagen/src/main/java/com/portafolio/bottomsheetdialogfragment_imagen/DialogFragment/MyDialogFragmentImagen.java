package com.portafolio.bottomsheetdialogfragment_imagen.DialogFragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.portafolio.bottomsheetdialogfragment_imagen.Adapter.ImageAdapter;
import com.portafolio.bottomsheetdialogfragment_imagen.R;

import java.util.Arrays;
import java.util.List;

public class MyDialogFragmentImagen extends BottomSheetDialogFragment {
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);

        List<Integer> images = Arrays.asList(R.drawable.item1, R.drawable.item1,
                R.drawable.item3, R.drawable.item3,
                R.drawable.item3, R.drawable.item3,
                R.drawable.item3, R.drawable.item3,
                R.drawable.item3, R.drawable.item3,
                R.drawable.item3, R.drawable.item3); // Añade tus imágenes aquí
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        // Agregar espaciado entre elementos
        int spacingInPixels = getResources().getDimensionPixelSize(R.dimen.spacing);
        recyclerView.addItemDecoration(new SpacesItemDecoration(spacingInPixels));
        ImageAdapter adapter = new ImageAdapter(getActivity(), new ImageAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Context context) {
                String clickedItem = String.valueOf(images.get(position));

                Log.d("TAG", "onItemClick: " + position);
                 Toast.makeText(context, "Clicked: " + clickedItem, Toast.LENGTH_SHORT).show();

            }
        }, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        return view;
    }


}