package com.example.vehiculos;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.vehiculos.vehiculo.Bici;
import com.example.vehiculos.vehiculo.Coche;
import com.example.vehiculos.vehiculo.Moto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //VARIABLES VISTA
    private static TextView txtCoche ;
    private static Button btnCoche;
    private static TextView txtMotos ;
    private static Button btnMotos;
    private static TextView txtBicis ;
    private static Button btnBicis;


    //Variables Logica
    private ArrayList<Coche> listaCoche;
    private ArrayList<Moto> listaMoto;
    private ArrayList<Bici> listaBici;
    private ActivityResultLauncher<Intent> cochesLauncher;
    private ActivityResultLauncher<Intent> motosLauncher;
    private ActivityResultLauncher<Intent> bicisLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarLogica();
        inicializarVista();
        activitiesResult();
        crearEventos();
    }

    private void inicializarLogica() {
        listaCoche = new ArrayList<>();
        listaBici = new ArrayList<>();
        listaMoto = new ArrayList<>();
    }

    private void activitiesResult() {
        cochesLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK && result.getData() != null){
                            Coche coche =  (Coche) result.getData().getExtras().getSerializable("COCHE");
                            listaCoche.add(coche);
                            txtCoche.setText(listaCoche.size()+ " Coches");
                        }
                    }
                });
        motosLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK && result.getData() != null){
                            Moto moto =  (Moto) result.getData().getExtras().getSerializable("MOTO");
                            listaMoto.add(moto);
                            txtMotos.setText(listaMoto.size()+ " Motos");
                        }
                    }
                });
        bicisLauncher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if(result.getResultCode() == RESULT_OK && result.getData() != null){
                    Bici bici =  (Bici) result.getData().getExtras().getSerializable("BICI");
                    listaBici.add(bici);
                    txtBicis.setText(listaBici.size()+ " Bicis");
            }
        }
    });
    }

    private void crearEventos() {
        btnCoche.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CocheActivity.class);
                cochesLauncher.launch(intent);
            }
        });
        btnMotos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,MotoActivity.class);
                motosLauncher.launch(intent);
            }
        });
        btnBicis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,BiciActivity.class);
                bicisLauncher.launch(intent);
            }
        });
    }

    private void inicializarVista(){
     txtCoche = findViewById(R.id.txtCocheMain);
     btnCoche = findViewById(R.id.btnCocheMain);
     txtMotos = findViewById(R.id.txtMotoMain);
     btnMotos = findViewById(R.id.btnMotoMain);
     txtBicis = findViewById(R.id.txtBiciMain);
     btnBicis = findViewById(R.id.btnBiciMain);
    }
}