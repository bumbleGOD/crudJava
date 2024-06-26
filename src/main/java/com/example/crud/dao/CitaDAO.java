package com.example.crud.dao;

import com.example.crud.models.Cita;
import com.example.crud.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitaDAO {

    private Connection connection;

    public CitaDAO() {
        try {
            connection = ConexionBD.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}