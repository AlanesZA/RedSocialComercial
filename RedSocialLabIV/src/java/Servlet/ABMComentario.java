package Servlet;

import Controlador.GestorBD;
import Modelo.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ABMComentario", urlPatterns = {"/ABMComentario"})
public class ABMComentario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        GestorBD gestor = new GestorBD();
        String modo = request.getParameter("modo");
        int id = Integer.parseInt(request.getParameter("id"));

        if (modo.equals("alta")) {

            Comercio comercio = gestor.obtenerComercioUpdate(id);
            request.getSession().setAttribute("Comercio", comercio);
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/homeUsuario1.jsp");
            rd.forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
// 
        String modo = request.getParameter("modo");

        if (modo.equals("alta")) {
            GestorBD gestor = new GestorBD();
            int idComercio = Integer.parseInt(request.getParameter("idComercio"));
            String nombreCliente = request.getParameter("txtNombre");
            String com = request.getParameter("txtComentario");
            int valoracion = Integer.parseInt(request.getParameter("cboValoracion"));

            Comercio co = gestor.obtenerComercioUpdate(idComercio);
            Comentario comentario = new Comentario(com, co, 1, valoracion, nombreCliente);

            gestor.insertarNuevoComentario(comentario);
            RequestDispatcher rd = request.getRequestDispatcher("/homeUsuario1.jsp");
            rd.forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
