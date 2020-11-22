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
        
            String modo = request.getParameter("modo");
            if (modo.equals("alta")) {
                request.setAttribute("titulo", "Alta de Comentario");
                RequestDispatcher rd = request.getRequestDispatcher("/homeUsuario1.jsp");
                rd.forward(request, response);
            } else if (modo.equals("editar")) {
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                GestorBD gestor = new GestorBD();
                Curso cursoEdit = gestor.getCurso(idCurso);

                //Setear atributos y enviar petición
                request.setAttribute("titulo", "Editar Curso");
                request.setAttribute("curso", cursoEdit);
                RequestDispatcher rd = request.getRequestDispatcher("/datosCurso.jsp");
                rd.forward(request, response);
            } else if (modo.equals("cambiarEstado")) {
                //Tomar parámetro idCurso, buscar en BD y cambiar estado
                int idCurso = Integer.parseInt(request.getParameter("idCurso"));
                // No llegué...
            }
     
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
            String nombre = request.getParameter("txtNombre");
            String descripcion = request.getParameter("texareaComentario");
            int valoracion = Integer.parseInt(request.getParameter("idValoracion"));            
            
            Comercio co = new Comercio();
            co.setNombre(co);
            Comentario comentario = new Comentario(0, descripcion, co, 1, valoracion, nombre);
            GestorBD gestor = new GestorBD();

            //Chequear si viene desde la opción Alta o Editar
            if (id
                    
                    == 0) {
                gestor.agregarCurso(curso);
            } else {                
                gestor.modificarCurso(curso);
            }

            //Redirigir al Listado por GET
            response.sendRedirect(getServletContext().getContextPath() + "/ListadoCursos");
        
           
        
    }

    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
