/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author Usuario
 */
@WebServlet(name = "Subida", urlPatterns = {"/Subida"})
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5,
        maxRequestSize = 1024 * 1024 * 6,
        location = "C:\\Users\\Usuario\\Desktop\\2020-programacion\\4TO_Cuatrimestre_2020_TUP\\4-LABORATORIO IV\\TPLABO_ALANES_MODEL\\TODO PARA PROYECTO CLUB SOCIAL\\RedSocialLabIV")

public class Subida extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
  
    }

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String  nombre = request.getParameter("txtNombre");
        String apellido = request.getParameter("txtApellido");
        
        for(Part part: request.getParts()){
            
            String filename = getFilename(part);
            if (!filename.isEmpty()) {
                part.write(apellido + filename);
            }
        }
        
        //Forward o redirect
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String getFilename(Part part) {
         for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf("=") + 2, content.length() - 1);
            }
        }
        return "";
    }
}
