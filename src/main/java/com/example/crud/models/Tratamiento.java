package com.example.crud.models;

import java.util.Date;

public class Tratamiento {
    private int numero;
    private Date fechaAsignado;
    private String descripcion;
    private Date fechaInicio;
    private Date fechaFin;
    private String observaciones;
    private String pacienteIdentificacion;

    public Tratamiento() {}

    public Tratamiento(int numero, Date fechaAsignado, String descripcion, Date fechaInicio, Date fechaFin, String observaciones, String pacienteIdentificacion) {
        this.numero = numero;
        this.fechaAsignado = fechaAsignado;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.observaciones = observaciones;
        this.pacienteIdentificacion = pacienteIdentificacion;
    }

}