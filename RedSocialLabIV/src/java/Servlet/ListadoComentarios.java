package Servlet;

import Controlador.GestorBD;
import Modelo.Comentario;
import Modelo.Comercio;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListadoComentarios", urlPatterns = {"/ListadoComentarios"})
public class ListadoComentarios extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        GestorBD gestor = new GestorBD();
        RequestDispatcher rd;       
        int estado = Integer.parseInt(request.getParameter("estado"));
        int idComentario = Integer.parseInt(request.getParameter("id"));
        
        switch (estado) {
            case 1:
            {
                gestor.bajaComentario(idComentario);
                rd = getServletContext().getRequestDispatcher("/AdmComentarios.jsp");
                rd.forward(request, response);
                break;
            }
            case 2:
            {    
                gestor.rehabilitarComentario(idComentario);
                rd = getServletContext().getRequestDispatcher("/AdmComentarios.jsp");
                rd.forward(request, response);
                break;
            }
            default:
            {
                ArrayList<Comentario> comentario = gestor.obtenerComentario();        
                request.setAttribute("lista", comentario);        
                rd = getServletContext().getRequestDispatcher("/AdmComentarios.jsp");
                rd.forward(request, response);
                break;
            }                
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
