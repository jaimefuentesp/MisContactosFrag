package com.jaimefuentesp.miscontactos;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.jaimefuentesp.miscontactos.adapter.ContactoAdaptador;
import com.jaimefuentesp.miscontactos.adapter.PageAdapter;
import com.jaimefuentesp.miscontactos.fragment.PerfilFragment;
import com.jaimefuentesp.miscontactos.fragment.RecyclerViewFragment;
import com.jaimefuentesp.miscontactos.pojo.Contacto;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    private Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = (Toolbar) findViewById(R.id.toolBar);
        tabLayout= (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        if (toolBar!=null) {
            setSupportActionBar(toolBar);
        }

        //inicializarConRecyclerView();

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

    private ArrayList<Fragment> agregarFragments () {
        ArrayList<Fragment> fragmentos = new ArrayList<>();
        fragmentos.add(new RecyclerViewFragment());
        fragmentos.add(new PerfilFragment());
        return fragmentos;
    }

    private void setUpViewPager () {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_contact);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_person);
    }

    public void inicializarConRecyclerView () {
        listaContactos = (RecyclerView) findViewById(R.id.rvContacto);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoutManager(this,2);

        listaContactos.setLayoutManager(llm);
        //inicializarListaContactos();
        //inicializarAdaptador();
    }


}
