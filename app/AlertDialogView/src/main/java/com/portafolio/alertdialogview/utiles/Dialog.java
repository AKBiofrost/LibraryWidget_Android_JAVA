package com.portafolio.alertdialogview.utiles;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import com.portafolio.alertdialogview.R;


public class Dialog {
    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog dialog;
    public void ViewDialogCallbak(String titulo, String mensaje, String BotonAceptar,
                                  String BotonCancelar, Context context, int icono,
                                  callbackDialog callbackDialog) {

        Activity activity = (Activity) context;
        LayoutInflater inflater = (LayoutInflater) activity.getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.custom_dialog, null);
        alertDialogBuilder = new AlertDialog.Builder(context, R.style.Theme_Dialog_Translucent);

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                TextView Titulo = dialogView.findViewById(R.id.dialog_title);
                TextView Mensaje = dialogView.findViewById(R.id.dialog_mensaje);
                Button aceptar = dialogView.findViewById(R.id.aceptar);
                Button cancelar = dialogView.findViewById(R.id.cancelar);
                aceptar.setText(BotonAceptar);
                Titulo.setText(titulo);
                Mensaje.setText(mensaje);

                // Verificar si BotonCancelar es nulo o vacío
                if (BotonCancelar == null || BotonCancelar.isEmpty()) {
                    cancelar.setVisibility(View.GONE); // Ocultar el botón
                } else {
                    cancelar.setText(BotonCancelar);
                    cancelar.setOnClickListener(v -> {
                        dialog.dismiss();
                        callbackDialog.ActionCancelar(context);
                    });
                }

                aceptar.setOnClickListener(v -> {
                    dialog.dismiss(); // curioso, se puede navegar en fragment con el dialog levantando
                    callbackDialog.ActionAceptar(context);
                });

                alertDialogBuilder.setView(dialogView).setCancelable(false);
                ImageView dialogIcon = dialogView.findViewById(R.id.dialog_icon);
                dialogIcon.setImageResource(icono);

                dialog = alertDialogBuilder.create();
                dialog.show();
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface arg0) {

                    }

                });
            }
        });
    }

}
