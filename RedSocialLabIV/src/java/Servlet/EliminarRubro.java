package Servlet;

import Controlador.GestorBD;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EliminarRubro", urlPatterns = {"/EliminarRubro"})
public class EliminarRubro extends HttpServlet {

  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       GestorBD gestor = new GestorBD();
        int idRubro = Integer.parseInt(request.getParameter("id"));
        gestor.bajaRubro(idRubro);
        request.setAttribute("listadoRubros", gestor.obtenerRubro());
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/listadoRubros.jsp");
        rd.forward(request, response);
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
