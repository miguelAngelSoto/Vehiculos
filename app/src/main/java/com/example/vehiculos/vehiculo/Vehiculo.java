package com.example.vehiculos.vehiculo;

import java.io.Serializable;

public class Vehiculo implements Serializable {
    private String marca;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String Marca) {
        marca = Marca;
    }
}
