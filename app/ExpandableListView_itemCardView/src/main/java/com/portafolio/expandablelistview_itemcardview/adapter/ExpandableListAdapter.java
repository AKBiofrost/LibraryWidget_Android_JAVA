package com.portafolio.expandablelistview_itemcardview.adapter;

// ExpandableListAdapter.java

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import com.portafolio.expandablelistview_itemcardview.Callback.CallBack;
import com.portafolio.expandablelistview_itemcardview.Callback.CallBack_child;
import com.portafolio.expandablelistview_itemcardview.R;

import java.util.HashMap;
import java.util.List;

// ExpandableListAdapter.java


public class ExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> listDataHeader; // Encabezados de la lista
    private HashMap<String, List<String>> listDataChild; // Datos de los hijos
    private CallBack callBack;

    private CallBack_child callBackChild;

    public ExpandableListAdapter(Context context, List<String> listDataHeader,
                                 HashMap<String, List<String>> listDataChild, CallBack callBack, CallBack_child callBackChild) {
        this.context = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
        this.callBack = callBack;
        this.callBackChild = callBackChild;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.header_item_layout, null);
        }
        // Configurar el Button dentro del CardView
        Button botonCompra = convertView.findViewById(R.id.boton_compra);
        botonCompra.setText(headerTitle); // Usar el texto del encabezado como texto del botón


        // Configurar un OnClickListener para el botón
        botonCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes manejar el clic del botón
                // Por ejemplo, mostrar un mensaje o realizar una acción
                callBack.Response(isExpanded, groupPosition);
                // Expande o colapsa el grupo
                if (isExpanded) {
                    //    expandableListView.collapseGroup(groupPosition);
                    System.out.println("Botón clickeado: " + headerTitle);
                } else {
                    // expandableListView.expandGroup(groupPosition, true);
                    System.out.println("Botón clickeado: ------------" + headerTitle);
                }
            }
        });

        return convertView;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_item_layout, null);
        }

        // Configurar el Button dentro del CardView
        Button botonCompra = convertView.findViewById(R.id.boton_compra);
        botonCompra.setText(childText); // Usar el texto del hijo como texto del botón

        // Configurar un OnClickListener para el botón
        botonCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aquí puedes manejar el clic del botón
                // Por ejemplo, mostrar un mensaje o iniciar una nueva actividad
                System.out.println("Botón clickeado: " + childText);
                callBackChild.Response(childText);
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}