package com.example.crud.servlet;

import com.example.crud.dao.MedicoDAO;
import com.example.crud.models.Medico;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/medico")
public class MedicoServlet extends HttpServlet {
    private MedicoDAO medicoDAO;

    public void init() {
        medicoDAO = new MedicoDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "add":
                addMedico(request, response);
                break;
            case "update":
                updateMedico(request, response);
                break;
            default:
                listMedicos(request, response);
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
                deleteMedico(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "new":
                showNewForm(request, response);
                break;
            default:
                listMedicos(request, response);
                break;
        }
    }

    private void listMedicos(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        request.setAttribute("medicoList", medicoDAO.getAllMedicos());
        request.getRequestDispatcher("/views/medico/list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/views/medico/add.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("id");
        Medico medico = medicoDAO.getMedicoById(id);
        request.setAttribute("medico", medico);
        request.getRequestDispatcher("/views/medico/edit.jsp").forward(request, response);
    }

    private void addMedico(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");

        Medico newMedico = new Medico(id, nombres, apellidos);
        medicoDAO.saveMedico(newMedico);
        response.sendRedirect("medico?action=list");
    }

    private void updateMedico(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        String nombres = request.getParameter("nombres");
        String apellidos = request.getParameter("apellidos");

        Medico medico = new Medico(id, nombres, apellidos);
        medicoDAO.updateMedico(medico);
        response.sendRedirect("medico?action=list");
    }

    private void deleteMedico(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String id = request.getParameter("id");
        medicoDAO.deleteMedico(id);
        response.sendRedirect("medico?action=list");
    }
}
