package Servlet;

import Controlador.GComentarios;
import Controlador.GestorBD;
import Modelo.*;
import java.io.IOException;

import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AltaComentario", urlPatterns = {"/AltaComentario"})
public class AltaComentario extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorBD c = new GestorBD();
        ArrayList<Comercio> co = c.obtenerComercios();
        request.setAttribute("listaComercios", co);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AltaComentarios.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorBD c = new GestorBD();
        ArrayList<Comercio> co = c.obtenerComercios();
        request.setAttribute("listaComercios", co);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/AltaComentarios.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GComentarios c = new GComentarios();
        String titulo = request.getParameter("txtTitulo");
        String comentario = request.getParameter("txtComentario");
        int Valoracion = Integer.parseInt(request.getParameter("estrellas"));
        int idcomercio = Integer.parseInt(request.getParameter("cboComercio"));

        Comercio co = c.obtenerComercioUpdate(idcomercio);
        Comentario com = new Comentario(0, titulo, comentario, Valoracion, co);

        
        c.RegistrarComentario(com);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListaCometario.jsp");
        rd.forward(request, response);
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
