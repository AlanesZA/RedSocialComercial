/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorBD;
import Modelo.Oferta;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListadoOferta", urlPatterns = {"/ListadoOferta"})
public class ListadoOferta extends HttpServlet {
    
    
     Oferta c = new Oferta();
    GestorBD gestor = new GestorBD();
    ArrayList<Oferta> lista = gestor.obtenerOferta();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorBD gestor = new GestorBD();         
        ArrayList<Oferta> listadoOfertas = gestor.obtenerOferta();
        request.setAttribute("listadoOfertas", listadoOfertas);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoOfertas.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         GestorBD g = new GestorBD();

        ArrayList<Oferta> lista = g.obtenerOferta();
        request.setAttribute("listadoComercios", lista);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoComercios.jsp");
        rd.forward(request, response);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Listar":
                ArrayList<Oferta> datos = gestor.obtenerOferta();
                request.setAttribute("datos", datos);
                request.getRequestDispatcher("listadoOfertas.jsp").forward(request, response);
                break;
        }
        
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
