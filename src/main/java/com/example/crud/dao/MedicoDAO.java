package com.example.crud.dao;

import com.example.crud.models.Medico;
import com.example.crud.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    private Connection connection;

    public MedicoDAO() {
        try {
            connection = ConexionBD.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
