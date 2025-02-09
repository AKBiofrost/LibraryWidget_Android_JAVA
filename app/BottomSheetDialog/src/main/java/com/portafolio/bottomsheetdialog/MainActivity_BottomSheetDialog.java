package com.portafolio.bottomsheetdialog;

import static com.portafolio.bottomsheetdialog.ShowBottomSheet.showBottomSheet;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity_BottomSheetDialog extends AppCompatActivity {
    private BottomSheetDialog bottomSheetDialog;
    String[] items = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5", "Elemento 6", "Elemento 7", "Elemento 8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_bottom_sheet_dialog);

        showBottomSheet(this, items);
        /*
        Button openSheetButton = findViewById(R.id.openSheetButton);
        openSheetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheet();
            }
        });
*/
    }


}





