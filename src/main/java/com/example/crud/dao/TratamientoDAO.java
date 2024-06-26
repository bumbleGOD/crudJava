package com.example.crud.dao;

import com.example.crud.models.Tratamiento;
import com.example.crud.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TratamientoDAO {

    private Connection connection;

    public TratamientoDAO() {
        try {
            connection = ConexionBD.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}