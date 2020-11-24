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

@WebServlet(name = "Respuestas", urlPatterns = {"/Respuestas"})
public class Respuestas extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idComercio = Integer.parseInt(request.getParameter("idComercio"));
        int idComentario = Integer.parseInt(request.getParameter("idComentario"));

        request.setAttribute("idComercio", idComercio);
        request.setAttribute("idComentario", idComentario);
        RequestDispatcher rd = getServletContext().getRequestDispatcher("/registroRespuesta.jsp");
        rd.forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
// 
//        String modo = request.getParameter("modo");

//        if (modo.equals("alta")) {
            GestorBD gestor = new GestorBD();
            int idComercio = Integer.parseInt(request.getParameter("idComercio"));
            int idComentario = Integer.parseInt(request.getParameter("idComentario"));
            String respuesta = request.getParameter("respuesta");            

            Respuesta resp = new Respuesta(0, idComercio, idComentario, respuesta);

            gestor.insertarNuevaRespuesta(resp);
            
            response.sendRedirect(getServletContext().getContextPath() + "/UsuarioNav?id=" + idComercio);
//            RequestDispatcher rd = request.getRequestDispatcher("/homeUsuario1.jsp");
//            
//            rd.forward(request, response);
//        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
