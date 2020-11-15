/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorBD;
import Modelo.Comercio;
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
            int estado=1;
            int id = Integer.parseInt(request.getParameter("cboComercio"));
            Comercio c = gestor.obtenerComercioUpdate(id);
            Oferta o = new Oferta(0,cantidad, precio, fechaInicioOferta, diasVigencia, titulo,estado ,c);
            
            gestor.insertarNuevaOferta(o);
            
            RequestDispatcher rd = request.getRequestDispatcher("/ListadoOferta");
            rd.forward(request, response);
            
            
            
            
            
//            
//            String fechaInicio = request.getParameter("fechaInicio");
//        int id = Integer.parseInt(request.getParameter("cboRubro"));
//        String nombre = request.getParameter("txtNombre");
//        int estado = 1;
//        
//        Rubro r =  gestor.obtenerRubroUpdate(id);
//        Comercio c = new Comercio(0,fechaInicio,r, estado, nombre);
//       
//        gestor.insertarNuevoComercio(c);
//     
//        RequestDispatcher rd = request.getRequestDispatcher("/listadoComercios.jsp");
//        rd.forward(request, response);
//            
            
            
            
            
            
            
            
            
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
