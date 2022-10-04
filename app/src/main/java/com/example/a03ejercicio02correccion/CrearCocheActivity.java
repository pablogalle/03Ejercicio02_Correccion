package com.example.a03ejercicio02correccion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a03ejercicio02correccion.modelos.CocheModel;

public class CrearCocheActivity extends AppCompatActivity {

    //Variables de Vista
    private EditText txtMarca;
    private EditText txtModelo;
    private EditText txtColor;
    private Button btnCrear;
    private Button btnCancelar;

    //Variables Logicas


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_coche);

        inicializaVistas();

        inicializaEventos();
    }

    private void inicializaEventos() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CANCELED);
                finish();
            }
        });
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String marca = txtMarca.getText().toString();
                String modelo = txtModelo.getText().toString();
                String color = txtColor.getText().toString();

                if (!marca.isEmpty() && !modelo.isEmpty() && !color.isEmpty()){
                    Intent intent = new Intent();
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("COCHE", new CocheModel(marca, modelo, color));
                    intent.putExtras(bundle);
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else{
                    Toast.makeText(CrearCocheActivity.this, "FALTAN DATOS", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void inicializaVistas() {
        txtMarca = findViewById(R.id.txtMarcaCrearCoche);
        txtModelo = findViewById(R.id.txtModeloCrearCoche);
        txtColor = findViewById(R.id.txtColorCrearCoche);
        btnCrear = findViewById(R.id.btnCrearCrearCoche);
        btnCancelar = findViewById(R.id.btnCancelarCrearCoche);
    }
}