package com.portafolio.expandablelistview_itemcardview;

import android.os.Bundle;
import android.widget.ExpandableListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.portafolio.expandablelistview_itemcardview.Callback.CallBack;
import com.portafolio.expandablelistview_itemcardview.Callback.CallBack_child;
import com.portafolio.expandablelistview_itemcardview.adapter.ExpandableListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity_expandable_itemCardView extends AppCompatActivity {


    private ExpandableListView expandableListView;
    private ExpandableListAdapter expandableListAdapter;
    private List<String> listDataHeader; // Encabezados de los grupos
    private HashMap<String, List<String>> listDataChild; // Hijos de cada grupo

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main_expandable_item_card_view);

        expandableListView = findViewById(R.id.expandableListView);
        prepareListData();
        expandableListAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild, new CallBack() {
            @Override
            public void Response(boolean isExpanded, int groupPosition) {
                if (isExpanded) {
                    expandableListView.collapseGroup(groupPosition);

                } else {
                    expandableListView.expandGroup(groupPosition, true);

                }

            }
        }, new CallBack_child() {
            @Override
            public void Response(String operation) {

            }
        });
        expandableListView.setAdapter(expandableListAdapter);
        // Listener para manejar clics en los hijos
        expandableListView.setOnChildClickListener((parent, v, groupPosition, childPosition, id) -> {
            String childText = (String) expandableListAdapter.getChild(groupPosition, childPosition);
            Toast.makeText(getApplicationContext(), "Clicked: " + childText, Toast.LENGTH_SHORT).show();
            return false;
        });


    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Añadir encabezados
        listDataHeader.add("Transacciones");
        listDataHeader.add("Consultas");
        listDataHeader.add("Miscelaneos");

        // Añadir hijos
        List<String> grupo1 = new ArrayList<>();
        grupo1.add("COMPRA");
        grupo1.add("C@MBIO");
        grupo1.add("ANULACION");

        List<String> grupo2 = new ArrayList<>();
        grupo2.add("ULT VOUCHER");
        grupo2.add("CIERRE");

        List<String> grupo3 = new ArrayList<>();
        grupo3.add("CALIBRAR");
        grupo3.add("BLOQUEAR");

        listDataChild.put(listDataHeader.get(0), grupo1); // Grupo 1
        listDataChild.put(listDataHeader.get(1), grupo2); // Grupo 2
        listDataChild.put(listDataHeader.get(2), grupo3); // Grupo 3
    }

}