package com.jose.mascotas;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DetalleMascotaActivity extends AppCompatActivity {

    /*
    Declarar instancias globales
     */
    private RecyclerView recicler_d;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // toolbar
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setDisplayShowCustomEnabled(true);
        getSupportActionBar().setCustomView(R.layout.custom_action_bar_main);

        // volver
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);

        // Inicializar Mascotas
        List<Mascotas> items = new ArrayList<>();

        items.add(new Mascotas(R.drawable.sheep, "Dolly", 3));
        items.add(new Mascotas(R.drawable.sheep2_48, "Dolly", 5));
        items.add(new Mascotas(R.drawable.sheep3_48, "Dolly", 7));
        items.add(new Mascotas(R.drawable.sheep4_48, "Dolly", 9));
        items.add(new Mascotas(R.drawable.sheep, "Dolly", 11));
        items.add(new Mascotas(R.drawable.sheep2_48, "Dolly", 1));

        // Obtener el Recycler
        recicler_d = (RecyclerView) findViewById(R.id.reciclador_detalle);
        try
        {
            recicler_d.setHasFixedSize(true);
            recicler_d.setLayoutManager(new GridLayoutManager(this, 2));
        }
        catch (NullPointerException nullPointer)
        {
            Log.v("Error", String.valueOf(nullPointer));
        }

        /*
        recyclerView.addItemDecoration(new MarginDecoration(this));
        recyclerView.setAdapter(new NumberedAdapter(30));*/

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        try {
            recicler_d.setLayoutManager(lManager);
        }
        catch (NullPointerException nullPointer)
        {
            Log.v("Error", String.valueOf(nullPointer));
        }

        // Crear un nuevo adaptador
        adapter = new MascotasPerfilAdapter(items);

            recicler_d.setAdapter(adapter);

    }
}

