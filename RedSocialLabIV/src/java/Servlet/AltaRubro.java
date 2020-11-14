/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorBD;
import Modelo.Rubro;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "AltaRubro", urlPatterns = {"/AltaRubro"})
public class AltaRubro extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        GestorBD gestor = new GestorBD();
        ArrayList<Rubro> listadoRubro = gestor.obtenerRubro();

        request.setAttribute("listadoRubro", listadoRubro);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/registroRubro.jsp");
        rd.forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        String rubro = request.getParameter("txtRubro");
        String descripcion = request.getParameter("txtDescripcion");
        int estado = 1;
       
        Rubro r = new Rubro(0, rubro, descripcion,estado);

        GestorBD gestor = new GestorBD();
        gestor.insertarNuevoRubro(r);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/registroRubro.jsp");
        rd.forward(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
