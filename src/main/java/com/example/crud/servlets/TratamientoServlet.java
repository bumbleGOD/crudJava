package com.example.crud.servlet;

import com.example.crud.dao.TratamientoDAO;
import com.example.crud.model.Tratamiento;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/tratamiento")
public class TratamientoServlet extends HttpServlet {
    private TratamientoDAO tratamientoDAO;

    public void init() {
        tratamientoDAO = new TratamientoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                addTratamiento(request, response);
                break;
            case "update":
                updateTratamiento(request, response);
                break;
            default:
                listTratamientos(request, response);
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
                deleteTratamiento(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "new":
                showNewForm(request, response);
                break;
            default:
                listTratamientos(request, response);
                break;
        }
    }

    private void listTratamientos(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("tratamientoList", tratamientoDAO.getAllTratamientos());
        request.getRequestDispatcher("/views/tratamiento/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/tratamiento/add.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Tratamiento tratamiento = tratamientoDAO.getTratamientoById(id);
        request.setAttribute("tratamiento", tratamiento);
        request.getRequestDispatcher("/views/tratamiento/edit.jsp").forward(request, response);
    }

    private void addTratamiento(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        String pacienteId = request.getParameter("pacienteId");
        Date fechaInicio = Date.valueOf(request.getParameter("fechaInicio"));
        Date fechaFin = Date.valueOf(request.getParameter("fechaFin"));
        String descripcion = request.getParameter("descripcion");

        Tratamiento newTratamiento = new Tratamiento(id, pacienteId, fechaInicio, fechaFin, descripcion);
        tratamientoDAO.saveTratamiento(newTratamiento);
        response.sendRedirect("tratamiento?action=list");
    }

    private void updateTratamiento(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        String pacienteId = request.getParameter("pacienteId");
        Date fechaInicio = Date.valueOf(request.getParameter("fechaInicio"));
        Date fechaFin = Date.valueOf(request.getParameter("fechaFin"));
        String descripcion = request.getParameter("descripcion");

        Tratamiento tratamiento = new Tratamiento(id, pacienteId, fechaInicio, fechaFin, descripcion);
        tratamientoDAO.updateTratamiento(tratamiento);
        response.sendRedirect("tratamiento?action=list");
    }

    private void deleteTratamiento(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        tratamientoDAO.deleteTratamiento(id);
        response.sendRedirect("tratamiento?action=list");
    }
}