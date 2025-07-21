package com.mycompany.primerservlet.servlets;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logica.Controladora;
import persistencia.exceptions.NonexistentEntityException;

@WebServlet(name = "SvEliminar", urlPatterns = {"/SvEliminar"})
public class SvEliminar extends HttpServlet {
    Controladora control = new Controladora ();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id_eliminar = Integer.parseInt(request.getParameter("id_usuario"));
        try {
            control.borraUsuario(id_eliminar);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(SvEliminar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        response.sendRedirect("index.jsp");
    }
}