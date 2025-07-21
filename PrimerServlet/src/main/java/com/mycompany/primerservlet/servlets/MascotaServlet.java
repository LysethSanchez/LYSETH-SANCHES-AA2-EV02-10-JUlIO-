package com.mycompany.primerservlet.servlets;

import com.mycompany.primerservlet.servlets.MascotaDAO;
import com.mycompany.primerservlet.servlets.Mascota;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

//@WebServlet("/MascotaServlet")
public class MascotaServlet extends HttpServlet {
    private MascotaDAO mascotaDAO;

    @Override
    public void init() {
        mascotaDAO = new MascotaDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "listar";

        switch (action) {
            case "listar":
                listarMascotas(request, response);
                break;
            case "eliminar":
                eliminarMascota(request, response);
                break;
            case "editar":
                mostrarFormularioEdicion(request, response);
                break;
            default:
                listarMascotas(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) action = "insertar";

        switch (action) {
            case "insertar":
                insertarMascota(request, response);
                break;
            case "actualizar":
                actualizarMascota(request, response);
                break;
            default:
                listarMascotas(request, response);
        }
    }

    private void listarMascotas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Mascota> lista = mascotaDAO.obtenerMascotas();
        request.setAttribute("listaMascotas", lista);
        request.getRequestDispatcher("listarMascotas.jsp").forward(request, response);
    }

    private void mostrarFormularioEdicion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Mascota mascota = mascotaDAO.obtenerMascotaPorId(id);
        request.setAttribute("mascota", mascota);
        request.getRequestDispatcher("formularioMascota.jsp").forward(request, response);
    }

    private void insertarMascota(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Mascota m = construirMascotaDesdeFormulario(request);
            mascotaDAO.insertarMascota(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("MascotaServlet?action=listar");
    }

    private void actualizarMascota(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Mascota m = construirMascotaDesdeFormulario(request);
            m.setId(Integer.parseInt(request.getParameter("id")));
            mascotaDAO.actualizarMascota(m);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("MascotaServlet?action=listar");
    }

    private void eliminarMascota(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        mascotaDAO.eliminarMascota(id);
        response.sendRedirect("MascotaServlet?action=listar");
    }

    private Mascota construirMascotaDesdeFormulario(HttpServletRequest request) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Mascota m = new Mascota();
        m.setNombreMascota(request.getParameter("nombreMascota"));
        m.setIdMascota(request.getParameter("idMascota"));
        m.setIdPropietario(request.getParameter("idPropietario"));
        m.setEdad(Integer.parseInt(request.getParameter("edad")));
        m.setEspecie(request.getParameter("especie"));
        m.setRaza(request.getParameter("raza"));
        m.setSexo(request.getParameter("sexo"));
        m.setFecha(sdf.parse(request.getParameter("fecha")));

        m.setNombreProcedimiento(request.getParameter("nombreProcedimiento"));
        m.setFechaProcedimiento(sdf.parse(request.getParameter("fechaProcedimiento")));
        m.setResponsableProcedimiento(request.getParameter("responsableProcedimiento"));

        m.setNombreMedicamento(request.getParameter("nombreMedicamento"));
        m.setDosis(request.getParameter("dosis"));
        m.setFrecuencia(request.getParameter("frecuencia"));

        return m;
    }
}
