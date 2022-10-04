package com.example.vehiculos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vehiculos.vehiculo.Bici;
import com.example.vehiculos.vehiculo.Moto;

public class BiciActivity extends AppCompatActivity {

    //VISTAS
    private EditText inputMarca;
    private EditText inputModelo;
    private EditText inputCc;
    private Button btnAdd;
    private Button btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bici);
        inicializarVistas();
        crearEventos();
    }

    private void crearEventos() {
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bici bici = new Bici(inputModelo.getText().toString(),inputCc.getText().toString(),inputMarca.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putSerializable("BICI",bici);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    private void inicializarVistas() {
        inputMarca = findViewById(R.id.inputMarcaBici);
        inputModelo = findViewById(R.id.inputModeloBici);
        inputCc = findViewById(R.id.inputCcBici);
        btnAdd = findViewById(R.id.btnCrearBici);
        btnCancelar = findViewById(R.id.btnCancelarBici);
    }
}