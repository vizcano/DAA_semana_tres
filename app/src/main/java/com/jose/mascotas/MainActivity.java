package com.jose.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

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

        View view = getSupportActionBar().getCustomView();

        // estrella
        ImageButton imageButtonHuella = (ImageButton)view.findViewById(R.id.action_bar_estrella);
        imageButtonHuella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });

        // Inicializar Mascotas
        List<Mascotas> items = new ArrayList<>();

        items.add(new Mascotas(R.drawable.sheep, "Dolly", 3));
        items.add(new Mascotas(R.drawable.bulldog, "Boby", 5));
        items.add(new Mascotas(R.drawable.hen, "Turuleca", 7));
        items.add(new Mascotas(R.drawable.cat, "Felix", 9));
        items.add(new Mascotas(R.drawable.pig, "Porky", 11));

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

    public void a(View v){
        Toast toast = Toast.makeText(getApplicationContext(), "Toast por defecto", Toast.LENGTH_SHORT);
        toast.show();
    }

}

