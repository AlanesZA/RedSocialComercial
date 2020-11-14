/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorReportes;
import Modelo.DTOComentariosSinRespuestas;
import Modelo.DTOPromedioValoracionxComercio;
import Modelo.DTOReporteComerciosporCantidad;
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
@WebServlet(name = "Reportes", urlPatterns = {"/Reportes"})
public class Reportes extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
            GestorReportes gestor = new GestorReportes();
        
        ArrayList<DTOComentariosSinRespuestas> ComentariosSinRespuesta = gestor.CargarComentariosSinRespuestas();
        request.setAttribute("ComentariosSinRespuesta", ComentariosSinRespuesta);   
        
        ArrayList<DTOPromedioValoracionxComercio> ValoracionxComercio = gestor.CargarPromedioValoracionPorComercio();
        request.setAttribute("ValoracionxComercio", ValoracionxComercio);   
        
        ArrayList<DTOReporteComerciosporCantidad> ComerciosxCantComentarios = gestor.CargarComerciosPorCantidadComentarios();
        request.setAttribute("ComerciosxCantComentarios", ComerciosxCantComentarios); 
        
        request.setAttribute("ValoracionGeneral", gestor.CargarPromedioValoracionGeneral());
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Reportes.jsp");
        rd.forward(request, response);
        
        
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorReportes gestor = new GestorReportes();
        
        ArrayList<DTOComentariosSinRespuestas> ComentariosSinRespuesta = gestor.CargarComentariosSinRespuestas();
        request.setAttribute("ComentariosSinRespuesta", ComentariosSinRespuesta);   
        
        ArrayList<DTOPromedioValoracionxComercio> ValoracionxComercio = gestor.CargarPromedioValoracionPorComercio();
        request.setAttribute("ValoracionxComercio", ValoracionxComercio);   
        
        ArrayList<DTOReporteComerciosporCantidad> ComerciosxCantComentarios = gestor.CargarComerciosPorCantidadComentarios();
        request.setAttribute("ComerciosxCantComentarios", ComerciosxCantComentarios); 
        
        request.setAttribute("ValoracionGeneral", gestor.CargarPromedioValoracionGeneral());
        
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/Reportes.jsp");
        rd.forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
