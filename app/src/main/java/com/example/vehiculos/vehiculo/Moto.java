package com.example.vehiculos.vehiculo;

public class Moto extends Vehiculo{
    private String modelo;
    private String color;

    public Moto(String modelo, String color,String marca) {
        this.modelo = modelo;
        this.color = color;
        this.setMarca(marca);
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
