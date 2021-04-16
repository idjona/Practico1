package com.idjona.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.idjona.practico1.Model.BaseDatos;
import com.idjona.practico1.Model.Fruta;

public class MainActivity extends AppCompatActivity {

    ListView listFrutas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GenerarFrutas();
        listFrutas = findViewById(R.id.listFrutas);

        ArrayAdapter<Fruta> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, BaseDatos.Frutas);
        listFrutas.setAdapter(adapter);

        listFrutas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetallesActivity.class);
                Fruta f = BaseDatos.Frutas.get(position);
                intent.putExtra("fruta", f);
                startActivity(intent);
            }
        });



    }

    public void GenerarFrutas(){
        Fruta f1 = new Fruta(1, "Manzana", 1500, 100);
        Fruta f2 = new Fruta(2, "Pera", 800, 200);
        Fruta f3 = new Fruta(3, "Naranja", 2200, 10);
        Fruta f4 = new Fruta(4, "Durazno", 1200, 500);

        BaseDatos.Frutas.add(f1);
        BaseDatos.Frutas.add(f2);
        BaseDatos.Frutas.add(f3);
        BaseDatos.Frutas.add(f4);
    }
}