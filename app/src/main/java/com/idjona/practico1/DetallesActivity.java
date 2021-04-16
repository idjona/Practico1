package com.idjona.practico1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.idjona.practico1.Model.Fruta;

public class DetallesActivity extends AppCompatActivity {
    TextView txtNombreFruta, txtPrecioFruta, txtStockFruta;
    Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Fruta fruta = (Fruta) bundle.get("fruta");

        txtNombreFruta.setText(fruta.getNombre());
        txtPrecioFruta.setText("$" +fruta.getPrecio());
        txtStockFruta.setText("stock " + fruta.getStock());

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(DetallesActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }
}