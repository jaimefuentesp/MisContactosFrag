package com.jaimefuentesp.miscontactos.db;

import android.content.Context;

import com.jaimefuentesp.miscontactos.R;
import com.jaimefuentesp.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class ConstructorContactos {

    private Context context;

    public ConstructorContactos(Context context) {
        this.context=context;
    }

    public ArrayList<Contacto> obtenerDatos() {
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.foto_2, "Jaime Fuentes", "997890707", "jaime@mail.com", 0));
        contactos.add(new Contacto(R.drawable.del_piero,"Luis Alvarez", "991234567", "luis@mail.com", 0));
        contactos.add(new Contacto(R.drawable.buffin,"Cesar Soto", "999888777", "cesar@mail.com", 4));
        contactos.add(new Contacto(R.drawable.ronaldo,"Dony Tinoco", "999777555", "dony@mail.com", 0));
        contactos.add(new Contacto(R.drawable.juve1,"Caro Huertas", "999222333", "caro@mail.com", 0));
        return contactos;
    }
}
