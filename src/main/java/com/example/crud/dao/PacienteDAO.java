package com.example.crud.dao;

import com.example.crud.models.Paciente;
import com.example.crud.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    private Connection connection;

    public PacienteDAO() {
        try {
            connection = ConexionBD.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}