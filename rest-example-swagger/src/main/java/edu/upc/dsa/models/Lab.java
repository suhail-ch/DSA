package edu.upc.dsa.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class Lab {

    public String nombre;
    private String identificador;

    @JsonIgnore
    private int numLab = 0;

    public Lab(){}


    public Lab(String nombre, String identificador) {
        this.nombre = nombre;
        this.identificador = identificador;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setNumLab(int numLab) {
        this.numLab = numLab;
    }

    public int getNumLab() {
        return numLab;
    }

    @Override
    public String toString() {
        return "Lab{" +
                "nombre='" + nombre + '\'' +
                ", identificador='" + identificador + '\'' +
                ", numLab=" + numLab +
                '}';
    }
}

