package com.jaimefuentesp.miscontactos.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jaimefuentesp.miscontactos.R;
import com.jaimefuentesp.miscontactos.adapter.ContactoAdaptador;
import com.jaimefuentesp.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);
        listaContactos = (RecyclerView) v.findViewById(R.id.rvContacto);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,2);

        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador () {
        ContactoAdaptador adaptador=new ContactoAdaptador(contactos,getActivity());
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
