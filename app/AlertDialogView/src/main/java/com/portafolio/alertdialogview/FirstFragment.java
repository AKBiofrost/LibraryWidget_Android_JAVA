package com.portafolio.alertdialogview;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.portafolio.alertdialogview.databinding.FragmentFirstBinding;
import com.portafolio.alertdialogview.utiles.Dialog;
import com.portafolio.alertdialogview.utiles.callbackDialog;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        new Dialog().ViewDialogCallbak("Dialog widget", "El mas reutilizable", "Aceptar",
                "Cancelar", getContext(), R.drawable.alert, new callbackDialog() {
                    @Override
                    public void ActionAceptar(Context context) {
                        NavHostFragment.findNavController(FirstFragment.this)
                                .navigate(R.id.action_FirstFragment_to_SecondFragment);

                    }

                    @Override
                    public void ActionCancelar(Context context) {

                        getActivity().finish();
                    }
                });


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}