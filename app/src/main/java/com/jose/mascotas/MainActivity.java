package com.jose.mascotas;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

        // Inicializar Mascotas
        List<Mascotas> items = new ArrayList<>();

        items.add(new Mascotas(R.drawable.sheep, "Dolly", 3));
        items.add(new Mascotas(R.drawable.bulldog, "Boby", 5));
        items.add(new Mascotas(R.drawable.hen, "Turuleca", 7));
        items.add(new Mascotas(R.drawable.cat, "Felix", 9));
        items.add(new Mascotas(R.drawable.pig, "Porky", 11));

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.reciclador);

        try
        {
            recycler.setHasFixedSize(true);
        }
        catch (NullPointerException nullPointer)
        {
           Log.v("Error", String.valueOf(nullPointer));
        }
        // Usar un administrador para LinearLayout
        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        // Crear un nuevo adaptador
        adapter = new MascotasAdapter(items);
        recycler.setAdapter(adapter);

        // estrella
        ImageButton imageButtonEstrella = (ImageButton)view.findViewById(R.id.action_bar_estrella);
        imageButtonEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });
    }

    // Añadiendo las opciones de menú
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // Añadiendo funcionalidad a las opciones de menú
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.btContacto:
                intent = new Intent(MainActivity.this, FormularioActivity.class);
                startActivity(intent);
                return true;
            case R.id.btAcercaDe:
                intent = new Intent(MainActivity.this, DetalleMascotaActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}

