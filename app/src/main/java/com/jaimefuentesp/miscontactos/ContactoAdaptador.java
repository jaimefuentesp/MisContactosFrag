package com.jaimefuentesp.miscontactos;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {

    ArrayList<Contacto> contactos;
    Activity activity;

    public ContactoAdaptador (ArrayList<Contacto> contactos,Activity activity) {
        this.contactos=contactos;
        this.activity=activity;
    }

    @NonNull
    @Override
    public ContactoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto, parent,false);
        return new ContactoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoViewHolder contactoViewHolder, int position) {
        final Contacto contacto = contactos.get(position);
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());

        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Intent intentDetatlleContacto = new Intent(activity,DetalleContacto.class);
                intentDetatlleContacto.putExtra("nombre",contacto.getNombre());
                intentDetatlleContacto.putExtra("telefono",contacto.getTelefono());
                intentDetatlleContacto.putExtra("email",contacto.getEmail());
                activity.startActivity(intentDetatlleContacto);
            }
        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Diste like a "+contacto.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return contactos.size();
    }

    public static class ContactoViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTelefonoCV;
        private ImageButton btnLike;

        public ContactoViewHolder (View itemView) {
            super(itemView);
            imgFoto     =(ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV  =(TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV=(TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike     =(ImageButton) itemView.findViewById(R.id.btnLike);
        }
    }

}
