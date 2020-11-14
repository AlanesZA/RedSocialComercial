/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Controlador.GestorBD;
import Modelo.Rubro;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "ModificarRubro", urlPatterns = {"/ModificarRubro"})
public class ModificarRubro extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //carga todos los campos en el formulario
        GestorBD gestor = new GestorBD();

        int id = Integer.parseInt(request.getParameter("id"));

        Rubro r = gestor.obtenerRubroUpdate(id);

        request.setAttribute("rubroupdate", r);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/modificarRubro.jsp");
        rd.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        GestorBD gestor = new GestorBD();
        int id = Integer.parseInt(request.getParameter("txtIdRubro"));

        String rubro = request.getParameter("txtRubro");
        String descripcion = request.getParameter("txtDescripcion");
        
        
        Rubro r = new Rubro(id, rubro, descripcion, 1);
        
        gestor.actualizarRubro(r);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoRubros.jsp");
        rd.forward(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
