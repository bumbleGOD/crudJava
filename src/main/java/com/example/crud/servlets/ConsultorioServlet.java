package com.example.crud.servlets;

import com.example.crud.dao.ConsultorioDAO;
import com.example.crud.models.Consultorio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/consultorios/*")
public class ConsultorioServlet extends HttpServlet {

    private ConsultorioDAO consultorioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        consultorioDAO = new ConsultorioDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) {
            action = "/";
        }
        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertConsultorio(request, response);
                break;
            case "/delete":
                deleteConsultorio(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updateConsultorio(request, response);
                break;
            default:
                listConsultorios(request, response);
                break;
        }
    }

    private void listConsultorios(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Consultorio> listConsultorios = consultorioDAO.obtenerTodosConsultorios();
        request.setAttribute("listConsultorios", listConsultorios);
        request.getRequestDispatcher("/consultorios/index.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/consultorios/nuevo.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int numero = Integer.parseInt(request.getParameter("numero"));
        Consultorio existingConsultorio = consultorioDAO.obtenerConsultorio(numero);
        request.setAttribute("consultorio", existingConsultorio);
        request.getRequestDispatcher("/consultorios/editar.jsp").forward(request, response);
    }

    private void insertConsultorio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int numero = Integer.parseInt(request.getParameter("numero"));
        String nombre = request.getParameter("nombre");
        Consultorio newConsultorio = new Consultorio(numero, nombre);
        consultorioDAO.crearConsultorio(newConsultorio);
        response.sendRedirect(request.getContextPath() + "/consultorios/");
    }

    private void updateConsultorio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int numero = Integer.parseInt(request.getParameter("numero"));
        String nombre = request.getParameter("nombre");
        Consultorio consultorio = new Consultorio(numero, nombre);
        consultorioDAO.actualizarConsultorio(consultorio);
        response.sendRedirect(request.getContextPath() + "/consultorios/");
    }

    private void deleteConsultorio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int numero = Integer.parseInt(request.getParameter("numero"));
        consultorioDAO.eliminarConsultorio(numero);
        response.sendRedirect(request.getContextPath() + "/consultorios/");
    }
}