package com.example.vehiculos.vehiculo;

public class Coche extends Vehiculo{
    private int pulgadas;

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public Coche(int pulgadas,String marca) {
        this.pulgadas = pulgadas;
        this.setMarca(marca);
    }
}
