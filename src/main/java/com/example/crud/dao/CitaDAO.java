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

    public void insertarCita(Cita cita) {
        String sql = "INSERT INTO citas (id, fecha, hora, descripcion) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, cita.getId());
            pstmt.setDate(2, new Date(cita.getFecha().getTime()));
            pstmt.setString(3, cita.getHora());
            pstmt.setString(4, cita.getDescripcion());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Cita> obtenerTodasLasCitas() {
        List<Cita> citas = new ArrayList<>();
        String sql = "SELECT * FROM citas";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                Date fecha = rs.getDate("fecha");
                String hora = rs.getString("hora");
                String descripcion = rs.getString("descripcion");
                citas.add(new Cita(id, fecha, hora, descripcion));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return citas;
    }

    public void actualizarCita(Cita cita) {
        String sql = "UPDATE citas SET fecha = ?, hora = ?, descripcion = ? WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setDate(1, new Date(cita.getFecha().getTime()));
            pstmt.setString(2, cita.getHora());
            pstmt.setString(3, cita.getDescripcion());
            pstmt.setInt(4, cita.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarCita(int citaId) {
        String sql = "DELETE FROM citas WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, citaId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}