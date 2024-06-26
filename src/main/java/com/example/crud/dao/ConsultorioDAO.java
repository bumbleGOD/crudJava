package com.example.crud.dao;

import com.example.crud.models.Consultorio;
import com.example.crud.util.ConexionBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConsultorioDAO {

    private Connection connection;

    public ConsultorioDAO() {
        try {
            connection = ConexionBD.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos CRUD para Consultorio
    public void crearConsultorio(Consultorio consultorio) {
        try {
            String query = "INSERT INTO Consultorios (ConNumero, ConNombre) VALUES (?, ?)";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, consultorio.getNumero());
            ps.setString(2, consultorio.getNombre());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Consultorio obtenerConsultorio(int numero) {
        Consultorio consultorio = null;
        try {
            String query = "SELECT * FROM Consultorios WHERE ConNumero=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                consultorio = new Consultorio(rs.getInt("ConNumero"), rs.getString("ConNombre"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultorio;
    }

    public List<Consultorio> obtenerTodosConsultorios() {
        List<Consultorio> consultorios = new ArrayList<>();
        try {
            String query = "SELECT * FROM Consultorios";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Consultorio consultorio = new Consultorio(rs.getInt("ConNumero"), rs.getString("ConNombre"));
                consultorios.add(consultorio);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultorios;
    }

    public void actualizarConsultorio(Consultorio consultorio) {
        try {
            String query = "UPDATE Consultorios SET ConNombre=? WHERE ConNumero=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, consultorio.getNombre());
            ps.setInt(2, consultorio.getNumero());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarConsultorio(int numero) {
        try {
            String query = "DELETE FROM Consultorios WHERE ConNumero=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, numero);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}