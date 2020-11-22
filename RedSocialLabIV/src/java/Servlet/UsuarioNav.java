package Servlet;

import Controlador.GestorBD;
import Modelo.DTOOfertaxComercio;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UsuarioNav", urlPatterns = {"/UsuarioNav"})
public class UsuarioNav extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        GestorBD gestor = new GestorBD();
        int idComercio = Integer.parseInt(request.getParameter("id"));
        ArrayList<DTOOfertaxComercio> oferta = gestor.obtenerOfertaxComercio(idComercio);
        request.setAttribute("lista", oferta);
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/homeUsuarioComentarios.jsp");
        rd.forward(request, response);
        
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
