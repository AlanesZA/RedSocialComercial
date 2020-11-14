/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorBD;
import Modelo.Comercio;
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
@WebServlet(name = "AltaComercio", urlPatterns = {"/AltaComercio"})
public class AltaComercio extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         GestorBD gestor = new GestorBD();
         

        String fechaInicio = request.getParameter("fechaInicio");
        int id = Integer.parseInt(request.getParameter("cboRubro"));
        String nombre = request.getParameter("txtNombre");
        int estado = 1;
        
        Rubro r =  gestor.obtenerRubroUpdate(id);
        Comercio c = new Comercio(0,fechaInicio,r, estado, nombre);
       
        gestor.insertarNuevoComercio(c);
     
        RequestDispatcher rd = request.getRequestDispatcher("/registroComercio.jsp");
        rd.forward(request, response);
    }

 
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
