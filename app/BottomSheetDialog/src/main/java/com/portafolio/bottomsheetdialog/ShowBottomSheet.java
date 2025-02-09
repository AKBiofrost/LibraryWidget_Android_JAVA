package com.portafolio.bottomsheetdialog;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ShowBottomSheet {

    public static void showBottomSheet(Activity activity, String[] items) {

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(activity);
        View bottomSheetView = activity.getLayoutInflater().inflate(R.layout.bottom_sheet_layout, null);

// Initialize the ListView and the data
        ListView itemListView = bottomSheetView.findViewById(R.id.itemListView);

// Set up the ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(activity, android.R.layout.simple_list_item_1, items);
        itemListView.setAdapter(adapter);

// Set up the item click listener
        itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Get the clicked item
                String selectedItem = items[position];

                // Handle the click event (e.g., show a Toast or start a new Activity)
                Toast.makeText(activity.getApplicationContext(), "Clicked: " + selectedItem, Toast.LENGTH_SHORT).show();

                // Optionally dismiss the dialog after selection
                bottomSheetDialog.dismiss();
            }
        });

// Set the content view and show the dialog
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();


    }
}
