package com.example.crud.servlet;

import com.example.crud.dao.CitaDAO;
import com.example.crud.model.Cita;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/cita")
public class CitaServlet extends HttpServlet {
    private CitaDAO citaDAO;

    public void init() {
        citaDAO = new CitaDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                addCita(request, response);
                break;
            case "update":
                updateCita(request, response);
                break;
            default:
                listCitas(request, response);
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
                deleteCita(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "new":
                showNewForm(request, response);
                break;
            default:
                listCitas(request, response);
                break;
        }
    }

    private void listCitas(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("citaList", citaDAO.getAllCitas());
        request.getRequestDispatcher("/views/cita/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/cita/add.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Cita cita = citaDAO.getCitaById(id);
        request.setAttribute("cita", cita);
        request.getRequestDispatcher("/views/cita/edit.jsp").forward(request, response);
    }

    private void addCita(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        String pacienteId = request.getParameter("pacienteId");
        Date fechaCita = Date.valueOf(request.getParameter("fechaCita"));
        String observaciones = request.getParameter("observaciones");

        Cita newCita = new Cita(id, pacienteId, fechaCita, observaciones);
        citaDAO.saveCita(newCita);
        response.sendRedirect("cita?action=list");
    }

    private void updateCita(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        String pacienteId = request.getParameter("pacienteId");
        Date fechaCita = Date.valueOf(request.getParameter("fechaCita"));
        String observaciones = request.getParameter("observaciones");

        Cita cita = new Cita(id, pacienteId, fechaCita, observaciones);
        citaDAO.updateCita(cita);
        response.sendRedirect("cita?action=list");
    }

    private void deleteCita(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        citaDAO.deleteCita(id);
        response.sendRedirect("cita?action=list");
    }
}