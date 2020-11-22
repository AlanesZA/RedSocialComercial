package Controlador;

import Modelo.*;
import java.sql.*;
import java.util.ArrayList;

public class GestorReportes {

    private Connection con;
    private final String CON_STR = "jdbc:sqlserver://LYNN\\SQLEXPRESS:1433;databaseName=RedSocial";
    private final String USER = "sa";
    private final String PASS = "2020";

    public void abrirConexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();

            con = DriverManager.getConnection(CON_STR, USER, PASS);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void cerrarConexion() {
        try {

            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //Reportes
    public ArrayList<DTOComentariosSinRespuestas> CargarComentariosSinRespuestas() {
        ArrayList<DTOComentariosSinRespuestas> lista = new ArrayList<>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(" select c.descripcion, c.valoracion, c.estado, cc.nombre \n"
                    + " from Comentarios c\n"
                    + "Join Comercios cc on cc.idComercio = c.idComercio\n"
                    + "where not exists (select rc.idComentario from Respuestas rc\n"
                    + "where rc.idComentario = c.idComentario)\n"
                    + "and c.estado=1");
            while (rs.next()) {
                String descripcion = rs.getString("descripcion");
                int valoracion = rs.getInt("valoracion");
                int estado = rs.getInt("estado");
                String comercio = rs.getString("nombre");

                DTOComentariosSinRespuestas r = new DTOComentariosSinRespuestas(descripcion, comercio, valoracion, estado);
                lista.add(r);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;

    }

    public ArrayList<DTOReporteComerciosporCantidad> CargarComerciosPorCantidadComentarios() {
        ArrayList<DTOReporteComerciosporCantidad> lista = new ArrayList<>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select c.nombre, COUNT(co.idComentario)'Cantidad' from Comercios c\n"
                    + "join Comentarios co on co.idComercio = c.idComercio\n"
                    + "where c.estado = 1\n"
                    + " group by c.idComercio, c.nombre, c.estado\n"
                    + "    order by 'Cantidad' desc");

            while (rs.next()) {
                String comercio = rs.getString("nombre");
                int cantComentarios = rs.getInt("Cantidad");

                DTOReporteComerciosporCantidad r = new DTOReporteComerciosporCantidad(comercio, cantComentarios);
                lista.add(r);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }

    public ArrayList<DTOPromedioValoracionxComercio> CargarPromedioValoracionPorComercio() {
        ArrayList<DTOPromedioValoracionxComercio> lista = new ArrayList<>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("Select c.nombre, avg(co.valoracion)'Promedio valoracion'\n"
                    + "  	from Comercios c\n"
                    + "  join Comentarios co on co.idComercio = c.idComercio \n"
                    + "  Group by c.idComercio, c.nombre");

            while (rs.next()) {
                String comercio = rs.getString("nombre");
                float promedio = rs.getInt("Promedio valoracion");

                DTOPromedioValoracionxComercio r = new DTOPromedioValoracionxComercio(comercio, promedio);
                lista.add(r);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }

    public Double CargarPromedioValoracionGeneral() {
        double Promedio = 0;
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select avg(c.Valoracion)'Promedio' from Comentarios c");

            while (rs.next()) {
                Promedio = rs.getInt("Promedio");
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return Promedio;
    }

    public ArrayList<DTOComentarios> CargarComentarios() {
        ArrayList<DTOComentarios> lista = new ArrayList<>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select c.idComentario, c.descripcion, c.valoracion, co.nombre\n"
                    + "from Comentarios c \n"
                    + "Join Comercios co on co.idComercio = c.idComercio\n"
                    + " where c.estado = 1");

            while (rs.next()) {
                int idComentario = rs.getInt("idComentario");
                String descripcion = rs.getString("descripcion");
                int estado = rs.getInt("estado");
                int Valoracion = rs.getInt("valoracion");
                String Comercio = rs.getString("nombre");

                DTOComentarios c = new DTOComentarios(idComentario, descripcion, Comercio, estado, Valoracion);
                lista.add(c);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }

    //Listado ofertas
    public ArrayList<DTOOfertas> CargarOfertasFiltradas(String palabraA, String palabraB) {
        ArrayList<DTOOfertas> lista = new ArrayList<>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select o.idOferta, o.titulo, o.cantidad, o.dias_vigencia, o.precio_oferta, o.fecha_inicio_oferta,\n"
                    + " co.nombre, o.estado\n"
                    + " from  Ofertas o\n"
                    + " Join Comercios co on co.idComercio = o.idComercio\n"
                    + "where o.titulo like'% ? %' or o.titulo like'% ? %'");

            while (rs.next()) {
                int Id_Oferta = rs.getInt("idOferta");
                String titulo = rs.getString("titulo");
                float Precio = rs.getFloat("Precio");
                String fechaInicioOferta = rs.getString("fechaInicioOferta");
                int diasVigencia = rs.getInt("diasVigencia");
                int estado = rs.getInt("estado");
                String comercio = rs.getString("nombre");

                DTOOfertas c = new DTOOfertas(Id_Oferta, titulo, Precio, fechaInicioOferta, diasVigencia, estado, comercio);
                lista.add(c);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }

    public ArrayList<DTOOfertas> CargarOfertas() {
        ArrayList<DTOOfertas> lista = new ArrayList<>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(" select o.idOferta, o.titulo, o.cantidad, o.dias_vigencia, o.precio_oferta, o.fecha_inicio_oferta,\n"
                    + " co.nombre, o.estado\n"
                    + " from  Ofertas o\n"
                    + " Join Comercios co on co.idComercio = o.idComercio");

            while (rs.next()) {
                int Id_Oferta = rs.getInt("idOferta");
                String titulo = rs.getString("titulo");
                float Precio = rs.getFloat("Precio");
                String fechaInicioOferta = rs.getString("fechaInicioOferta");
                int diasVigencia = rs.getInt("diasVigencia");
                int estado = rs.getInt("estado");
                String Comercio = rs.getString("nombre");

                DTOOfertas c = new DTOOfertas(Id_Oferta, titulo, Precio, fechaInicioOferta, diasVigencia, estado, Comercio);
                lista.add(c);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }


    //Comercios
    public ArrayList<DtoComercio> ObtenerComercios() {
        ArrayList<DtoComercio> lista = new ArrayList<>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SSELECT c.nombre, c.fecha_inicio, r.rubro, c.estado\n"
                    + "FROM Comercios c\n"
                    + "Join Rubros r on r.idRubro = c.idRubro\n"
                    + "WHERE c.estado = 1");
            while (rs.next()) {

                String fechainicio = rs.getString("fecha_inicio");
                String rubro = rs.getString("rubro");
                int estado = rs.getInt("estado");
                String comercio = rs.getString("nombre");

                DtoComercio c = new DtoComercio(fechainicio, rubro, estado, comercio);
                lista.add(c);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return lista;
    }

    public DtoComercio ObtenerComercio(int id) {
        DtoComercio c = new DtoComercio();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("  SELECT c.idComercio, c.nombre, c.fecha_inicio, r.rubro\n"
                    + "   FROM Comercios c\n"
                    + "   Join Rubros r on r.idRubro = c.idRubro\n"
                    + "      WHERE c.estado = 1 and c.idComercio = ?");
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String fechainicio = rs.getString("fecha_inicio");
                String rubro = rs.getString("rubro");
                int estado = rs.getInt("estado");

                c = new DtoComercio(fechainicio, rubro,estado, nombre);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return c;
    }

    //Comentarios
    public void RegistrarComentario(Comentario c) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT INTO Comentarios( descripcion,idComercio, estado, valoracion)\n"
                    + "     VALUES (?, ?, ?, ?, ?)");

            ps.clearParameters();
            ps.setString(1, c.getDescripcion());
            ps.setDouble(2, c.getComercio().getId());
            ps.setInt(3, c.getEstado());
            ps.setInt(4, c.getValoracion());
            ps.execute();

            ps.executeQuery();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

}
