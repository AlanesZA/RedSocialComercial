package Servlet;

import Controlador.GestorBD;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "loginCtrl", urlPatterns = {"/loginCtrl"})
 
public class loginCtrl extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        try{
            GestorBD con = new GestorBD();
            con.abrirConexion();
            String usu = request.getParameter("txtUsuario");
            String pass = request.getParameter("txtPassword");
           
            if(usu.length() != 0 && pass.length() != 0) {
                    if(usu.compareToIgnoreCase("sa") == 0 && pass.compareToIgnoreCase("2020") == 0 ) {
                        getServletContext().getRequestDispatcher("/home.jsp").forward(request, response);
                    } else {
                        
                        return;
                    }
            }
        }
            finally {            
            out.close();
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
    }// </editor-fold
}
