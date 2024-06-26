package com.example.crud.models;

import java.util.Date;

public class Cita {
    private int numero;
    private Date fecha;
    private String hora;
    private String pacienteIdentificacion;
    private String medicoIdentificacion;
    private int consultorioNumero;
    private String estado;

    public Cita() {}

    public Cita(int numero, Date fecha, String hora, String pacienteIdentificacion, String medicoIdentificacion, int consultorioNumero, String estado) {
        this.numero = numero;
        this.fecha = fecha;
        this.hora = hora;
        this.pacienteIdentificacion = pacienteIdentificacion;
        this.medicoIdentificacion = medicoIdentificacion;
        this.consultorioNumero = consultorioNumero;
        this.estado = estado;
    }

}