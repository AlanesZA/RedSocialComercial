/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorBD;
import Modelo.Oferta;
import java.io.IOException;
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
@WebServlet(name = "AltaOferta", urlPatterns = {"/AltaOferta"})
public class AltaOferta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
         GestorBD gestor = new GestorBD();
        int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
            double precio = Double.parseDouble(request.getParameter("txtPrecio"));
            String fechaInicioOferta = request.getParameter("fechaInicio");
            int diasVigencia = Integer.parseInt(request.getParameter("txtDiasVigencia"));
            String titulo = request.getParameter("txtTitulo");
            int comercio = Integer.parseInt(request.getParameter("idComercio"));
            request.setAttribute("Comercio", comercio );
            int estado =1;

            gestor.insertarNuevaOferta(new Oferta(0,cantidad, precio, fechaInicioOferta, diasVigencia, titulo,estado ,comercio));
            
            RequestDispatcher rd = request.getRequestDispatcher("/ListadoOferta");
            rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
       
       
         
        
        
        
//        GestorBD gestor = new GestorBD();
//        ArrayList<DTOComerciosActivos> listadoComercio = gestor.obtenerComerciosActivos();
//
//        request.setAttribute("listadoComercio", listadoComercio);
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/registroOferta.jsp");
//        rd.forward(request, response);



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        
//        GestorBD gestor = new GestorBD();
//        int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
//            double precio = Double.parseDouble(request.getParameter("txtPrecio"));
//            String fechaInicioOferta = request.getParameter("fechaInicio");
//            int diasVigencia = Integer.parseInt(request.getParameter("txtDiasVigencia"));
//            String titulo = request.getParameter("txtTitulo");
//            String comercio = request.getParameter("txtComercio");
//            int estado=1;
//
//            gestor.insertarNuevaOferta(new Oferta(0,cantidad, precio, fechaInicioOferta, diasVigencia, titulo,estado ,comercio));
//            
//            RequestDispatcher rd = request.getRequestDispatcher("/ListadoOferta");
//            rd.forward(request, response);
        

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
