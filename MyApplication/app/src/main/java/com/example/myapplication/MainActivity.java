package com.example.myapplication;

import static android.widget.Toast.LENGTH_LONG;

import android.app.Activity;
import android.os.Bundle;
import android.text.style.IconMarginSpan;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.ArrayRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


/*Este proyecto es un ejemplo de como crear un recyclerView personalizado haciendo uso de fragments,

 reciclerView, ViewHolder y Adapter

 Crearemos una tarjeta capaz de mostrar el contenido de una imagen, y un texto descripción */
public class MainActivity extends AppCompatActivity {


    private RecyclerView rv;

    private AnimalViewModel animalViewModel;

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

        /*View Model*/
            animalViewModel = new ViewModelProvider(this).get(AnimalViewModel.class);

        /*Fin ViewModel*/


        animalViewModel.animales.observe(this, animals -> {
            rv.setAdapter(new AnimalesListAdapter(animals));
        });

        /* Recycler View */

        rv = findViewById(R.id.rvContainer);
        rv.setLayoutManager(new LinearLayoutManager(this));

        /*Fin recycler view*/


        /* Inicio Spinner */

        Spinner sp = findViewById(R.id.spinner);

        ArrayList<String> animalesSpinner = new ArrayList<String>();
        animalesSpinner.add("Morsa");
        animalesSpinner.add("Axolotl");
        animalesSpinner.add("Ornitorrinco");

        sp.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, animalesSpinner));

        /* Fin Spinner */

        /* Inicio toolbar */

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /* Fin ToolBar */

    }
    /* Metodos sobreescritos para gestionar las opciones del toolbar */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int op = item.getItemId();

        if(op == R.id.detalles){
            animalViewModel.addAnimal(new Animal(3, "León 2", "El rey de la jungla 2", R.drawable.leon));

            return true;
        }

        if (op == R.id.contacto){
            return true;
        }

        if (op == R.id.solicitud){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}