package com.jose.mascotas;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MascotasPerfilAdapter extends RecyclerView.Adapter<MascotasPerfilAdapter.MascotasViewHolder> {
    private List<Mascotas> items;

    public static class MascotasViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public ImageView imagen;
        public TextView visitas;

        public MascotasViewHolder(View v) {
            super(v);
            imagen = (ImageView) v.findViewById(R.id.imagen);
            visitas = (TextView) v.findViewById(R.id.visitas);
        }
    }

    public MascotasPerfilAdapter(List<Mascotas> items) {
        this.items = items;
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public MascotasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.mascota_perfil_card, viewGroup, false);
        return new MascotasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotasViewHolder viewHolder, int i) {
        viewHolder.imagen.setImageResource(items.get(i).getImagen());
        viewHolder.visitas.setText(String.valueOf(items.get(i).getVisitas()));
    }
}
