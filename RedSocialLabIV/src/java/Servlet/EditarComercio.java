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
           
            
            Rubro r = gestor.obtenerRubroUpdate(id); 
            c = new Comercio();
            c.setRubro(r);
            c.setFechainicio(fechaInicio);
            c.setNombre(nombre);
            c.setId(idComercio);

            gestor.actualizarComercio(c);
            rd = getServletContext().getRequestDispatcher("/listadoComercios.jsp");
            rd.forward(request, response);

        }else if (estado == 5)//baja
        {
            gestor.bajaComercio(idComercio);
            rd = getServletContext().getRequestDispatcher("/listadoComercios.jsp");
            rd.forward(request, response);
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
    }

}
