package edu.upc.dsa.models;

import java.util.ArrayList;
import java.util.List;

public class Muestra {

    private Usuario usuario;
    private String idMuestra;
    private String idDoctor;
    private String fecha;
    private String idLab;

    public Muestra(String idMuestra, String idDoctor, String fecha, String idLab){
        this.idMuestra=idMuestra;
        this.idDoctor=idDoctor;
        this.fecha=fecha;
        this.idLab=idLab;
    }

    public Muestra(){ }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setIdDoctor(String idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getIdDoctor() {
        return idDoctor;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha() {
        return fecha;
    }

    public void setIdLab(String idLab) {
        this.idLab = idLab;
    }

    public String getIdLab() {
        return idLab;
    }

    public void setIdMuestra(String idMuestra) {
        this.idMuestra = idMuestra;
    }

    public String getIdMuestra() {
        return idMuestra;
    }

    @Override
    public String toString() {
        return "Muestra{" +
                "usuario=" + usuario +
                ", idMuestra='" + idMuestra + '\'' +
                ", idDoctor='" + idDoctor + '\'' +
                ", fecha='" + fecha + '\'' +
                ", idLab='" + idLab + '\'' +
                '}';
    }
}
