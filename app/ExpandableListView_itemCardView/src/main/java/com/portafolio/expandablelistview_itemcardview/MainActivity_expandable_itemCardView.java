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
                Toast.makeText(getApplicationContext(), "Clicked: " + operation, Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setAdapter(expandableListAdapter);
        // Listener para manejar clics en los hijos


    }

    private void prepareListData() {
        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        // Añadir encabezados
        listDataHeader.add("Grupo 1");
        listDataHeader.add("Grupo 2");
        listDataHeader.add("Grupo 3");

        // Añadir hijos
        List<String> grupo1 = new ArrayList<>();
        grupo1.add("AAAAAA");
        grupo1.add("BBBBBB");
        grupo1.add("CCCCCC");

        List<String> grupo2 = new ArrayList<>();
        grupo2.add("111111");
        grupo2.add("222222");

        List<String> grupo3 = new ArrayList<>();
        grupo3.add("123456");
        grupo3.add("123456");

        listDataChild.put(listDataHeader.get(0), grupo1); // Grupo 1
        listDataChild.put(listDataHeader.get(1), grupo2); // Grupo 2
        listDataChild.put(listDataHeader.get(2), grupo3); // Grupo 3
    }

}