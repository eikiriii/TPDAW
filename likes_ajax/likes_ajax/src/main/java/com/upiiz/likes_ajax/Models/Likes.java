package com.upiiz.likes_ajax.Models;

public class Likes {
    private int imagen1;
    private int imagen2;
    private int imagen3;

    public Likes() {}

    public Likes(int imagen1, int imagen2, int imagen3) {
        this.imagen1 = imagen1;
        this.imagen2 = imagen2;
        this.imagen3 = imagen3;
    }

    public int getImagen1() {
        return imagen1;
    }

    public void setImagen1(int imagen1) {
        this.imagen1 = imagen1;
    }

    public int getImagen2() {
        return imagen2;
    }

    public void setImagen2(int imagen2) {
        this.imagen2 = imagen2;
    }

    public int getImagen3() {
        return imagen3;
    }

    public void setImagen3(int imagen3) {
        this.imagen3 = imagen3;
    }
}
