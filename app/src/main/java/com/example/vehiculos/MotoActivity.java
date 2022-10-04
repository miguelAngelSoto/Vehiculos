package com.example.vehiculos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.vehiculos.vehiculo.Coche;
import com.example.vehiculos.vehiculo.Moto;

public class MotoActivity extends AppCompatActivity {

    //VISTA
    private EditText inputModelo;
    private EditText inputMarca;
    private EditText inputColor;
    private Button btnCrear;
    private Button btnCancelar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moto);
        inicializarVistas();
        crearEventos();
    }

    private void crearEventos() {
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Moto moto = new Moto(inputModelo.getText().toString(),inputColor.getText().toString(),inputMarca.getText().toString());
                Bundle bundle = new Bundle();
                bundle.putSerializable("MOTO",moto);
                Intent intent = new Intent();
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void inicializarVistas() {
        inputModelo = findViewById(R.id.inputModeloMoto);
        inputMarca = findViewById(R.id.inputMarcaMoto);
        inputColor = findViewById(R.id.inputColorMoto);
        btnCrear = findViewById(R.id.btnCrearMoto);
        btnCancelar = findViewById(R.id.btnCancelarMoto);
    }
}