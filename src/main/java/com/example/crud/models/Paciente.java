package com.example.crud.models;

import java.util.Date;

public class Paciente {
    private String identificacion;
    private String nombres;
    private String apellidos;
    private Date fechaNacimiento;
    private String sexo;

    public Paciente() {}

    public Paciente(String identificacion, String nombres, String apellidos, Date fechaNacimiento, String sexo) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.sexo = sexo;
    }

}