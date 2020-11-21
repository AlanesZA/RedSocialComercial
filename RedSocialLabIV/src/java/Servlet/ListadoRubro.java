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


@WebServlet(name = "ListadoRubro", urlPatterns = {"/ListadoRubro"})
public class ListadoRubro extends HttpServlet {

 
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorBD gestor = new GestorBD();         
        ArrayList<Rubro> listadoRubros = gestor.obtenerRubro();
        request.setAttribute("listadoRubros", listadoRubros);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoRubros.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);
        
        /*GestorBD gestor = new GestorBD();   

        ArrayList<Rubro> r= gestor.obtenerRubro();
//        Metodo pa devolver estado-- REVEER
//        String estado = "";
//        for (Rubro rubro : r) {
//            estado = (rubro.getEstado() == 1)?"Habilitado":"Deshabilitado";
//        }
              
        request.setAttribute("listadoRubros", gestor.obtenerRubro());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoRubros.jsp");
        rd.forward(request, response);*/
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
