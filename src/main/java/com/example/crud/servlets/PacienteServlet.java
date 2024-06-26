package com.example.crud.servlet;

import com.example.crud.dao.PacienteDAO;
import com.example.crud.model.Paciente;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/paciente")
public class PacienteServlet extends HttpServlet {
    private PacienteDAO pacienteDAO;

    public void init() {
        pacienteDAO = new PacienteDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                addPaciente(request, response);
                break;
            case "update":
                updatePaciente(request, response);
                break;
            default:
                listPacientes(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "delete":
                deletePaciente(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "new":
                showNewForm(request, response);
                break;
            default:
                listPacientes(request, response);
                break;
        }
    }

    private void listPacientes(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("pacienteList", pacienteDAO.getAllPacientes());
        request.getRequestDispatcher("/views/paciente/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/paciente/add.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Paciente paciente = pacienteDAO.getPacienteById(id);
        request.setAttribute("paciente", paciente);
        request.getRequestDispatcher("/views/paciente/edit.jsp").forward(request, response);
    }

    private void addPaciente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        Date fechaNacimiento = Date.valueOf(request.getParameter("fechaNacimiento"));
        String sexo = request.getParameter("sexo");

        Paciente newPaciente = new Paciente(id, nombres, apellidos, fechaNacimiento, sexo);
        pacienteDAO.savePaciente(newPaciente);
        response.sendRedirect("paciente?action=list");
    }

    private void updatePaciente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");
        Date fechaNacimiento = Date.valueOf(request.getParameter("fechaNacimiento"));
        String sexo = request.getParameter("sexo");

        Paciente paciente = new Paciente(id, nombres, apellidos, fechaNacimiento, sexo);
        pacienteDAO.updatePaciente(paciente);
        response.sendRedirect("paciente?action=list");
            }
            private void deletePaciente(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        pacienteDAO.deletePaciente(id);
        response.sendRedirect("paciente?action=list");
    }
}