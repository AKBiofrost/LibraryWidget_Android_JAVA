package com.portafolio.bottomsheetdialogfragment_listcardview;

import static com.portafolio.bottomsheetdialogfragment_listcardview.showBottomSheet.showBottomSheet_cardView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity_bottomSheetDialogFragment_listCardView extends AppCompatActivity {
    String[] items = {"Elemento 1", "Elemento 2", "Elemento 3", "Elemento 4", "Elemento 5", "Elemento 6", "Elemento 7", "Elemento 8"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_bottom_sheet_dialog_fragment_list_card_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        showBottomSheet_cardView(this, items, new callbackDialog() {
            @Override
            public void ActionAceptar(Context context, String item) {
                Toast.makeText(MainActivity_bottomSheetDialogFragment_listCardView.this, "Clicked: " + item, Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}