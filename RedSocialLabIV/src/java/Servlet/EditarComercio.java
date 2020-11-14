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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EditarComercio", urlPatterns = {"/EditarComercio"})
public class EditarComercio extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idestado = (String) request.getParameter("estado");
        int estado = Integer.parseInt(idestado);

        int idComercio = Integer.parseInt(request.getParameter("id"));
        Comercio c = null;
        GestorBD gestor = new GestorBD();
        RequestDispatcher rd;

        if (estado == 3)//modificar
        {
            c = gestor.obtenerComercioUpdate(idComercio);
            request.getSession().setAttribute("comercio", c);
            rd = getServletContext().getRequestDispatcher("/modificarComercio.jsp");
            rd.forward(request, response);
        } else if (estado == 4)//actualizar
        {
            String fechaInicio = request.getParameter("txtFechaInicio");
            int id = Integer.parseInt(request.getParameter("cboRubro"));
            String nombre = request.getParameter("txtNombre");
            c.setFechainicio(fechaInicio);
            
            Rubro r = gestor.obtenerRubroUpdate(id); 
            c.setRubro(r);
            c.setNombre(nombre);
            c.setId(idComercio);

            gestor.actualizarComercio(c);
            rd = getServletContext().getRequestDispatcher("/listadoComercios.jsp");
            rd.forward(request, response);

        }

//        
//        if (estado == 0) {
//            gestor.obtenerComercios();
//            rd = getServletContext().getRequestDispatcher("/listadoComercios.jsp");
//            rd.forward(request, response);
//            
//        }else if (estado == 2)//baja
//        {
//            gestor.bajaComercio(idComercio);
//            rd = getServletContext().getRequestDispatcher("/listadoComercios.jsp");
//            rd.forward(request, response);
//        } else if (estado == 1)//alta
//        {
//            gestor.insertarNuevoComercio(c);
//            rd = getServletContext().getRequestDispatcher("/listadoComercios.jsp");
//            rd.forward(request, response);
//        } else if (estado == 3)//modificar
//        {
//            c = gestor.obtenerComercioUpdate(idComercio);
//            request.getSession().setAttribute("comercio", c);
//            rd = getServletContext().getRequestDispatcher("/modificarComercio.jsp");
//            rd.forward(request, response);
//        } else if (estado == 4)//actualizar
//        {
//            gestor.actualizarComercio(c);
//            rd = getServletContext().getRequestDispatcher("/listadoComercios.jsp");
//            rd.forward(request, response);
//        }
//
//        
//        
////        String idestado = (String) request.getParameter("estado");
////        int estado = Integer.parseInt(idestado);
////        String iddocumento = (String) request.getParameter("id");
////        int documento = Integer.parseInt(iddocumento);
////        RequestDispatcher rd;
////        Socio a = ((Socio) request.getSession().getAttribute("socio"));
////        GestorSocios gestor = new GestorSocios();
////        if (estado == 0)
////        {
////            gestor.getAgregarSocio(a);
////            rd = getServletContext().getRequestDispatcher("/listadoSocios.jsp");
////            rd.forward(request, response);
////        } else if (estado == 2)//baja
////        {
////            gestor.getBajaSocio(documento);
////            rd = getServletContext().getRequestDispatcher("/listadoSocios.jsp");
////            rd.forward(request, response);
////        } else if (estado == 1)//alta
////        {
////            gestor.getAltaSocio(documento);
////            rd = getServletContext().getRequestDispatcher("/listadoSocios.jsp");
////            rd.forward(request, response);
////        } else if (estado == 3)
////        {
////            Socio b = gestor.getSocio(documento);
////            request.getSession().setAttribute("socio", b);
////            rd = getServletContext().getRequestDispatcher("/editarSocio.jsp");
////            rd.forward(request, response);
////        } else if (estado == 4)
////        {
////            gestor.getActualizarSocio(a);
////            rd = getServletContext().getRequestDispatcher("/listadoSocios.jsp");
////            rd.forward(request, response);
////        }
//
//        
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

//       GestorBD gestor = new GestorBD();        
//        
//        int idComercio = Integer.parseInt(request.getParameter("id"));        
//        
//        Comercio comercio = gestor.obtenerComercioUpdate(idComercio);        
//        request.setAttribute("modeloRubro", comercio);
//        ArrayList<Rubro> listaRubro = gestor.obtenerRubro();
//        request.setAttribute("listEditRubro", listaRubro);
//        
//        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarComercio.jsp");
//        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

//       GestorBD gestor = new GestorBD();
//        int id = Integer.parseInt(request.getParameter("idComercio"));
//        
//        String fi = request.getParameter("txtFechaInicio");        
//        int idRubro = Integer.parseInt(request.getParameter("cboRubro")); 
//        String nombre = request.getParameter("txtNombre"); 
//      
//                
//        Comercio comercio = new Comercio(id, fi,idRubro, nombre);   
//        comercio.setId(id);        
//        gestor.actualizarComercio(comercio);               
//       RequestDispatcher rd = getServletContext().getRequestDispatcher("/ListadoComerciosActivos");
//        rd.forward(request, response);   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
