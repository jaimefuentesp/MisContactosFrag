package com.jaimefuentesp.miscontactos.presentador;

import android.content.Context;

import com.jaimefuentesp.miscontactos.db.ConstructorContactos;
import com.jaimefuentesp.miscontactos.fragment.IRecyclerViewFragmentView;
import com.jaimefuentesp.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class RecycletViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    IRecyclerViewFragmentView iRecyclerViewFragmentView;
    Context context;
    private ConstructorContactos constructorContactos;
    ArrayList<Contacto> contactos;

    public RecycletViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView,Context context) {
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context=context;
        obtenerContactosBaseDatos();
    }

    @Override
    public void obtenerContactosBaseDatos() {
        constructorContactos=new ConstructorContactos(context);
        contactos=constructorContactos.obtenerDatos();
        mostrarContactosRV();
    }

    @Override
    public void mostrarContactosRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(contactos));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
