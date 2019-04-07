package com.jaimefuentesp.miscontactos.fragment;

import com.jaimefuentesp.miscontactos.adapter.ContactoAdaptador;
import com.jaimefuentesp.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();
    public ContactoAdaptador crearAdaptador(ArrayList<Contacto> contactos);
    public void inicializarAdaptadorRV(ContactoAdaptador adaptador);
}
