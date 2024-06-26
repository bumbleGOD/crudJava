package com.example.crud.models;

public class Medico {
    private String identificacion;
    private String nombres;
    private String apellidos;

    public Medico() {}

    public Medico(String identificacion, String nombres, String apellidos) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
    }
}