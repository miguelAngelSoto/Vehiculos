package com.example.vehiculos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vehiculos.vehiculo.Coche;

public class CocheActivity extends AppCompatActivity {

    //VARIABLES VISTA
    private  Button btnCancelar;
    private  Button btnAdd;
    private  EditText inputMarca;
    private  EditText inputPulgadas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coche);
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
                Coche coche = new Coche(Integer.parseInt(inputPulgadas.getText().toString()),inputMarca.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putSerializable("COCHE",coche);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    private void inicializarVistas() {
        btnCancelar = findViewById(R.id.btnCancelarCoche);
        btnAdd = findViewById(R.id.btnCrearCoche);
        inputMarca = findViewById(R.id.inputMarcaCoche);
        inputPulgadas = findViewById(R.id.inputPulgadasCoche);
    }
}