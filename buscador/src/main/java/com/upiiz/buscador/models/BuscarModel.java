package com.upiiz.buscador.models;

public class BuscarModel {
    private int id;
    private String nombre;

    public BuscarModel() {
    }

    public BuscarModel(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
