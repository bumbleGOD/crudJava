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

    public void insertarMedico(Medico medico) {
        String sql = "INSERT INTO medicos (id, nombre, especialidad) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, medico.getId());
            pstmt.setString(2, medico.getNombre());
            pstmt.setString(3, medico.getEspecialidad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Medico> obtenerTodosLosMedicos() {
        List<Medico> medicos = new ArrayList<>();
        String sql = "SELECT * FROM medicos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String especialidad = rs.getString("especialidad");
                medicos.add(new Medico(id, nombre, especialidad));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }

    public void actualizarMedico(Medico medico) {
        String sql = "UPDATE medicos SET nombre = ?, especialidad = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, medico.getNombre());
            pstmt.setString(2, medico.getEspecialidad());
            pstmt.setInt(3, medico.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarMedico(int medicoId) {
        String sql = "DELETE FROM medicos WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, medicoId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}