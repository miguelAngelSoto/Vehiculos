package com.example.vehiculos.vehiculo;

public class Bici extends Vehiculo{
    private String modelo;
    private String cilindradas;

    public Bici(String modelo, String cilindradas,String marca) {
        this.modelo = modelo;
        this.cilindradas = cilindradas;
        this.setMarca(marca);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(String cilindradas) {
        this.cilindradas = cilindradas;
    }
}
