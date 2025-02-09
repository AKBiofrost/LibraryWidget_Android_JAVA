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
import com.portafolio.bottomsheetdialogfragment_imagen.Adapter.MyAdapter2;
import com.portafolio.bottomsheetdialogfragment_imagen.R;

import java.util.Arrays;
import java.util.List;

public class MyBottomSheetDialog extends BottomSheetDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        // Aquí puedes establecer el adaptador para el RecyclerView
        MyAdapter2 adapter2 = new MyAdapter2(getData(),
                new MyAdapter2.OnItemClickListener() {
            @Override
            public void onItemClick(int position, Context context) {
                // Handle the click event
                String clickedItem = getData().get(position);

                Log.d("TAG", "onItemClick: " + clickedItem);
                 Toast.makeText(context, "Clicked: " + clickedItem, Toast.LENGTH_SHORT).show();
            }
        }, getContext());
        recyclerView.setAdapter(adapter2);

        return view;
    }

    private List<String> getData() {
        // Devuelve una lista de datos para mostrar en el RecyclerView
        return Arrays.asList("Item 1", "Item 2", "Item 3", "Item 4","Item 5", "Item 6", "Item 7", "Item 8");
    }
}
