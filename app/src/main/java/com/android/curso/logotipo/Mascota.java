package com.android.curso.logotipo;

/**
 * Created by DELL on 13/11/2016.
 */

public class Mascota {

    private String nombre;
    private int votos;
    private int foto;

    public Mascota(String nombre, int votos, int foto) {
        this.nombre = nombre;
        this.votos = votos;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
