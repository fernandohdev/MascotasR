package com.android.curso.logotipo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {


    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public MascotaAdaptador adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        miActionBar.setLogo(R.drawable.huella);
        miActionBar.setTitleMarginStart(265);
        setSupportActionBar(miActionBar);


        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);

        inicializarListaMascotas();
        inicializarAdaptador();


    }


    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Ardillita", 0, R.drawable.ardilla));
        mascotas.add(new Mascota("Dino",      0, R.drawable.dino));
        mascotas.add(new Mascota("Garfield",  0, R.drawable.garfield));
        mascotas.add(new Mascota("Gata",      0, R.drawable.gata));
        mascotas.add(new Mascota("Gato",      0, R.drawable.gato));
        mascotas.add(new Mascota("Odi",       0, R.drawable.odi));
        mascotas.add(new Mascota("Pluto",     0, R.drawable.pluto));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_opciones, menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch( item.getItemId() )
        {
            case R.id.mRaiting:

                //Toast.makeText(this, "Diste click en el boton de Raiting", Toast.LENGTH_SHORT).show();

                EnlaceMascotas.clear();

                //mascotas.

                Collections.sort(mascotas, new Comparator<Mascota>() {
                    @Override
                    public int compare(Mascota m1, Mascota m2) {
                        return new Integer(m2.getVotos()).compareTo(new Integer(m1.getVotos()));
                    }
                });

                EnlaceMascotas.setMascotasAll(new ArrayList<Mascota>(mascotas.subList(0, 5)));

                Intent intent = new Intent(this, ActivityRaiting.class);
                startActivity(intent);

                break;
        }
        return super.onOptionsItemSelected(item);
    }


}
