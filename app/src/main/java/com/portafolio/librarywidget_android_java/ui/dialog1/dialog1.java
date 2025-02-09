package com.portafolio.librarywidget_android_java.ui.dialog1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.portafolio.librarywidget_android_java.R;
import com.portafolio.librarywidget_android_java.databinding.FragmentSlideshowBinding;


public class dialog1 extends Fragment {

    private FragmentSlideshowBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
         return inflater.inflate(R.layout.fragment_nav_dialog1, container, false);
    }
}