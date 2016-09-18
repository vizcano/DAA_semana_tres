package com.jose.mascotas;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;


public class FavoritosActivity extends ActionBarActivity {

    /*
    Declarar instancias globales
     */
    private RecyclerView recycler;
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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.back);

        View view = getSupportActionBar().getCustomView();

        // volver
        //ImageButton imageButtonVolver = (ImageButton)view.findViewById(R.id.action_bar_volver);
        /*imageButtonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/

        // ocultar estrella
        ImageButton imageButtonHuella = (ImageButton)view.findViewById(R.id.action_bar_estrella);
        imageButtonHuella.setVisibility(View.GONE);

        // Inicializar Mascotas
        List<Mascotas> items = new ArrayList<>();

        items.add(new Mascotas(R.drawable.pig, "Porky", 11));
        items.add(new Mascotas(R.drawable.cat, "Felix", 9));
        items.add(new Mascotas(R.drawable.hen, "Turuleca", 7));
        items.add(new Mascotas(R.drawable.bulldog, "Boby", 5));
        items.add(new Mascotas(R.drawable.sheep, "Dolly", 3));

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new MascotasAdapter(items);
        recycler.setAdapter(adapter);
    }
}

