package com.jaimefuentesp.miscontactos.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.jaimefuentesp.miscontactos.R;
import com.jaimefuentesp.miscontactos.pojo.Contacto;

import java.sql.DatabaseMetaData;
import java.util.ArrayList;

public class ConstructorContactos {

    private static final int LIKE = 1;
    private Context context;

    public ConstructorContactos(Context context) {
        this.context=context;
    }

    public ArrayList<Contacto> obtenerDatos() {
        BaseDatos db = new BaseDatos(context);
        insertarTresContactos(db);
        return db.obtenerTodosLosContactos();
        /*
        ArrayList<Contacto> contactos = new ArrayList<Contacto>();
        contactos.add(new Contacto(R.drawable.foto_2, "Jaime Fuentes", "997890707", "jaime@mail.com", 0));
        contactos.add(new Contacto(R.drawable.del_piero,"Luis Alvarez", "991234567", "luis@mail.com", 0));
        contactos.add(new Contacto(R.drawable.buffin,"Cesar Soto", "999888777", "cesar@mail.com", 4));
        contactos.add(new Contacto(R.drawable.ronaldo,"Dony Tinoco", "999777555", "dony@mail.com", 0));
        contactos.add(new Contacto(R.drawable.juve1,"Caro Huertas", "999222333", "caro@mail.com", 0));*/
    }

    public void insertarTresContactos (BaseDatos db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_NOMBRE,"Jaime Fuentes");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_TELEFONO,"997890707");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_EMAIL,"jaimefuentesp@outlook.com");
        contentValues.put(ConstantesBaseDatos.TABLE_CONTACTS_FOTO,R.drawable.foto_2);
        db.insertarContacto(contentValues);
    }

    public void darLikeContacto (Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACTS_ID_CONTACTO,contacto.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_LIKES_CONTACTS_NUMERO_LIKES,LIKE);
        db.insertarLikeContacto(contentValues);
    }

    public int obtenerLikesContacto (Contacto contacto) {
        BaseDatos db = new BaseDatos(context);
        return db.obtenerLikesContacto(contacto);
    }

}
