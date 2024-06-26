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

    public void insertarTratamiento(Tratamiento tratamiento) {
        String sql = "INSERT INTO tratamientos (id, descripcion, costo) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, tratamiento.getId());
            pstmt.setString(2, tratamiento.getDescripcion());
            pstmt.setDouble(3, tratamiento.getCosto());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Tratamiento> obtenerTodosLosTratamientos() {
        List<Tratamiento> tratamientos = new ArrayList<>();
        String sql = "SELECT * FROM tratamientos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                double costo = rs.getDouble("costo");
                tratamientos.add(new Tratamiento(id, descripcion, costo));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tratamientos;
    }

    public void actualizarTratamiento(Tratamiento tratamiento) {
        String sql = "UPDATE tratamientos SET descripcion = ?, costo = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setString(1, tratamiento.getDescripcion());
            pstmt.setDouble(2, tratamiento.getCosto());
            pstmt.setInt(3, tratamiento.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarTratamiento(int tratamientoId) {
        String sql = "DELETE FROM tratamientos WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, tratamientoId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}