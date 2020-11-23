package edu.upc.dsa.models;

import java.util.LinkedList;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;

public class Usuario {
    String idUsuario;
    String nombre;
    String apellido;
    int edad;
    String salud;

    @JsonIgnore
    @ApiModelProperty(hidden = true)
    LinkedList<Muestra>  muestraList;

    //Constructor usuario
    public Usuario(String idUsuario, String nombre,String apellido, int edad, String salud){
        this.idUsuario=idUsuario;
        this.apellido=apellido;
        this.nombre=nombre;
        this.edad=edad;
        this.salud=salud;
        this.muestraList= new LinkedList<>(); //Inicialitzar llista encadenada comandes
    }
    public Usuario(){ }

    //GETS: Lectura y escritura de NIF y Name
    public void setNombre(String name) {
        this.nombre = nombre;
    }
    public String getNombre() { return nombre; }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }
    public String getIdUsuario() { return idUsuario; }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario='" + idUsuario + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edad=" + edad +
                ", salud='" + salud + '\'' +
                '}';
    }



    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }

    public String getSalud() {
        return salud;
    }


    public LinkedList<Muestra> getOrderList() {
        return this.muestaList;
    }
    public void setOrderList(LinkedList<Muestra> orderList) {
        this.muestraList = orderList;
    }


    public void addMuestra(LinkedList<Muestra>  muestraList){
        this.muestraList.add(muestraList);
    }



}
