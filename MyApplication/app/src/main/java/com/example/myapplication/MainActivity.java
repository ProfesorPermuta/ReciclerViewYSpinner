package com.example.myapplication;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/*Este proyecto es un ejemplo de como crear un recyclerView personalizado haciendo uso de fragments,

 reciclerView, ViewHolder y Adapter

 Crearemos una tarjeta capaz de mostrar el contenido de una imagen, y un texto descripción */
public class MainActivity extends AppCompatActivity {


    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        /*Recycler View*/
        ArrayList<Animal> animales = new ArrayList<Animal>();
        animales.add(new Animal(animales.size() + 1, "León", "El rey de la jungla", R.drawable.leon));
        animales.add(new Animal(animales.size() + 1, "Elefante", "Es enorme", R.drawable.elefante));

        rv = findViewById(R.id.rvContainer);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new AnimalesListAdapter(animales));
        /*Fin recycler view*/


        /*Inicio Spinner*/

        Spinner sp = findViewById(R.id.spinner);

        ArrayList<String> animalesSpinner = new ArrayList<String>();
        animalesSpinner.add("Morsa");
        animalesSpinner.add("Axolotl");
        animalesSpinner.add("Ornitorrinco");

        sp.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, animalesSpinner));

        /*Fin Spinner*/
    }
}