package com.upiiz.segundoparcial.Models;

import java.time.LocalDate;

public class PublicacionesModel {
    private int id;
    private String titulo;
    private String contenido;
    private int id_categoria;
    private LocalDate fecha_publicacion;

    public PublicacionesModel(int id, String titulo, String contenido, int id_categoria, LocalDate fecha_publicacion) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.id_categoria = id_categoria;
        this.fecha_publicacion = fecha_publicacion;
    }
    
    public PublicacionesModel() {
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public int getId_categoria() {
        return id_categoria;
    }
    public void setId_categoria(int id_categoria) {
        this.id_categoria = id_categoria;
    }
    public LocalDate getFecha_publicacion() {
        return fecha_publicacion;
    }
    public void setFecha_publicacion(LocalDate fecha_publicacion) {
        this.fecha_publicacion = fecha_publicacion;
    }
}
