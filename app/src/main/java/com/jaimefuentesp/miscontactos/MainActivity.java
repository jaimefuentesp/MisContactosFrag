package com.jaimefuentesp.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvContacto);

        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(this,2);


        listaContactos.setLayoutManager(glm);
        inicializarListaContactos();
        inicializarAdaptador();

        /*
        ArrayList<String> nombresContacto = new ArrayList<>();
        for (Contacto contacto : contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        inicializarListaContactos();

        ListView lstContactos;
        lstContactos = findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,nombresContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(MainActivity.this,DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pmail),contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });
        */


    }

    public void inicializarAdaptador () {
        ContactoAdaptador adaptador=new ContactoAdaptador(contactos,this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos () {
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.foto_2, "Jaime Fuentes", "997890707", "jaime@mail.com"));
        contactos.add(new Contacto(R.drawable.del_piero,"Luis Alvarez", "991234567", "luis@mail.com"));
        contactos.add(new Contacto(R.drawable.buffin,"Cesar Soto", "999888777", "cesar@mail.com"));
        contactos.add(new Contacto(R.drawable.ronaldo,"Dony Tinoco", "999777555", "dony@mail.com"));
        contactos.add(new Contacto(R.drawable.juve1,"Caro Huertas", "999222333", "caro@mail.com"));

    }
}
