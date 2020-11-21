package Servlet;

import Controlador.GestorBD;
import Modelo.Comercio;
import Modelo.Oferta;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "EditarOferta", urlPatterns = {"/EditarOferta"})
public class EditarOferta extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idestado = (String) request.getParameter("estado");
        int estado = Integer.parseInt(idestado);

        int idOferta = Integer.parseInt(request.getParameter("id"));
        Oferta c = null;

        GestorBD gestor = new GestorBD();
        RequestDispatcher rd;

        if (estado == 3)//modificar
        {
            c = gestor.obtenerOfertaUpdate(idOferta);
            request.getSession().setAttribute("oferta", c);
            rd = getServletContext().getRequestDispatcher("/modificarOferta.jsp");
            rd.forward(request, response);
        } else if (estado == 4)//actualizar
        {
 
            int cantidad = Integer.parseInt(request.getParameter("txtCantidad"));
            double precio = Double.parseDouble(request.getParameter("txtPrecio"));
            String fechaInicioOferta = request.getParameter("txtFechaInicioOferta");
            int diasVigencia = Integer.parseInt(request.getParameter("txtDiasVigencia"));
            String titulo = request.getParameter("txtTitulo");
            int idComercio = Integer.parseInt(request.getParameter("cboComercio"));
           

            Oferta o = gestor.obtenerOfertaUpdate(idOferta);     
            Comercio co = gestor.obtenerComercioUpdate(idComercio);
            o.setComercio(co);
            o.setCantidad(cantidad);
            o.setDiasVigencia(diasVigencia);
            o.setPrecio(precio);
            o.setFechaInicioOferta(fechaInicioOferta);
            o.setTitulo(titulo);

            gestor.actualizarOferta(o);
            rd = getServletContext().getRequestDispatcher("/listadoOfertas.jsp");
            rd.forward(request, response);

        } else if (estado == 5)//baja
        {
            gestor.bajaOferta(idOferta);
            rd = getServletContext().getRequestDispatcher("/listadoOfertas.jsp");
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
