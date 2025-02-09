package com.portafolio.bottomsheetdialogfragment_imagen;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.portafolio.bottomsheetdialogfragment_imagen.DialogFragment.MyDialogFragmentImagen;

public class MainActivity_bottomsheetDialogfragment_imagen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_bottomsheet_dialogfragment_imagen);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        /*-----------------------------------------------------------------------------------------*/
        MyDialogFragmentImagen dialog = new MyDialogFragmentImagen();
        dialog.show(getSupportFragmentManager(), dialog.getTag());
/*
        MyBottomSheetDialog bottomSheet = new MyBottomSheetDialog();
        bottomSheet.show(getSupportFragmentManager(), bottomSheet.getTag());
*/
        /*-----------------------------------------------------------------------------------------*/

    }
}