package com.portafolio.librarywidget_android_java.ui.dialog1;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.portafolio.alertdialogview.MainActivity_alertDialogView;
import com.portafolio.bottomsheetdialog.MainActivity_BottomSheetDialog;
import com.portafolio.librarywidget_android_java.R;
import com.portafolio.librarywidget_android_java.databinding.FragmentSlideshowBinding;


public class dialog1 extends Fragment {

    private FragmentSlideshowBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_nav_dialog1, container, false);
        Button button = view.findViewById(R.id.button);

        button.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), MainActivity_alertDialogView.class);
            startActivity(intent);

        });
         return view;
    }
}