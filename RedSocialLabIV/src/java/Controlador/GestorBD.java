package Controlador;

import Modelo.Comercio;
import Modelo.DTOComerciosActivos;
import Modelo.DTOComerciosNoActivos;
import Modelo.Oferta;
import Modelo.Rubro;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class GestorBD {

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

    //1. Método para insertar Rubro
    public void insertarNuevoRubro(Rubro r) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT  INTO Rubros VALUES (?,?,?)");
            ps.clearParameters();
            ps.setString(1, r.getRubro());
            ps.setString(2, r.getDescripcion());
            ps.setInt(3, r.getEstado());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<Rubro> obtenerRubro() {
        ArrayList<Rubro> lista = new ArrayList<Rubro>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Rubros");
            while (rs.next()) {
                int id = rs.getInt("idRubro");
                String rubro = rs.getString("rubro");
                String descripcion = rs.getString("descripcion");
                int estado = rs.getInt("estado");

                Rubro r = new Rubro(id, rubro, descripcion, estado);

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

    //Editar 1 Rubro
    public void actualizarRubro(Rubro r) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Rubros SET rubro = ?, descripcion = ?, estado = ? where idRubro=? ");
            ps.clearParameters();
            ps.setString(1, r.getRubro());
            ps.setString(2, r.getDescripcion());
            ps.setInt(3, r.getEstado());
            ps.setInt(4, r.getId());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Obtener rubro-Lista-update por id
    public Rubro obtenerRubroUpdate(int idRubro) {
        Rubro resultado = null;
        try {
            abrirConexion();
            String sql = "SELECT * FROM Rubros WHERE idRubro = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idRubro);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String rubro = rs.getString(2);
                String descripcion = rs.getString(3);
                int estado = rs.getInt(4);

                resultado = new Rubro(idRubro, rubro, descripcion, estado);
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return resultado;
    }

    public void bajaRubro(int idRubro) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Rubros SET estado = 0 where idRubro = ?");
            ps.clearParameters();
            ps.setInt(1, idRubro);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }
//********************* comercio  **********************************************

    public void insertarNuevoComercio(Comercio c) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT  INTO Comercios VALUES (?,?,?,?)");
            ps.clearParameters();
            ps.setString(1, c.getFechainicio());
            ps.setInt(2, c.getRubro().getId());//tipoRUbro
            ps.setInt(3, c.getEstado());
            ps.setString(4, c.getNombre());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    public ArrayList<Comercio> obtenerComercios() {
        ArrayList<Comercio> lista = new ArrayList<>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select c.idComercio,c.fecha_inicio,r.idRubro, c.nombre, c.estado\n"
                    + " from Comercios c, Rubros r\n"
                    + " where c.idRubro = r.idRubro");
            while (rs.next()) {
                int id = rs.getInt("idComercio");
                String fi = rs.getString("fecha_inicio");
                int idRubro = rs.getInt("idRubro");
                int estado = rs.getInt("estado");
                String nombre = rs.getString("nombre");

                Rubro tipo = new Rubro();
                tipo.setId(idRubro);
                Comercio c = new Comercio(id, fi, tipo, estado, nombre);

                lista.add(c);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    public void habilitarComercio(int idComercio) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Comercios SET estado = 1 where idComercio = ?");
            ps.clearParameters();
            ps.setInt(1, idComercio);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Editar 1 Comercio
    public void actualizarComercio(Comercio c) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Comercios SET fecha_inicio = ?, idRubro = ?, estado = 1, nombre = ? where idComercio=? ");
            ps.clearParameters();
            
            ps.setString(1, c.getFechainicio());
            ps.setInt(2, c.getRubro().getId());
            ps.setString(3, c.getNombre());
             ps.setInt(4, c.getId());

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }
    //Obtener rubro-Lista-update por id

    public Comercio obtenerComercioUpdate(int idComercio) {
        Comercio c = null;
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Comercios WHERE idComercio = ?");
            ps.setInt(1, idComercio);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idComercio");
                String fecha_inicio = rs.getString("fecha_inicio");
                int idRubro = rs.getInt("idRubro");
                int estado = rs.getInt("estado");
                String nombre = rs.getString("nombre");

                Rubro r = obtenerRubroUpdate(idRubro);
                c = new Comercio(id, fecha_inicio, r, estado, nombre);
                c.setId(id);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return c;
    }

    public void bajaComercio(int idComercio) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Comercios SET estado = 0 where idComercio = ?");
            ps.clearParameters();
            ps.setInt(1, idComercio);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

//*********************Oferta*************************************************
    public void insertarNuevaOferta(Oferta o) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("INSERT  INTO Ofertas VALUES (?,?,?,?,?,?,?)");
            ps.clearParameters();
            ps.setInt(1, o.getCantidad());
            ps.setDouble(2, o.getPrecio());
            ps.setString(3, o.getFechaInicioOferta());
            ps.setInt(4, o.getDiasVigencia());
            ps.setString(5, o.getTitulo());
            ps.setInt(6, o.getEstado());
            ps.setInt(7, o.getComercio().getId());

            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }
   
    public ArrayList<Oferta> obtenerOferta() {
        ArrayList<Oferta> lista = new ArrayList<>();
        try {
            abrirConexion();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select o.idOferta,o.cantidad,o.precio_oferta, o.fecha_inicio_oferta, o.dias_vigencia,o.titulo, o.estado, c.idComercio\n" +
"                    from Ofertas o, Comercios c\n" +
"                     where o.idComercio = c.idComercio");
            while (rs.next()) {
                int id = rs.getInt("idOferta");
                int cantidad = rs.getInt("cantidad");
                Double po = rs.getDouble("precio_oferta");
                String fio = rs.getString("fecha_inicio_oferta");
                int dias_vigencia = rs.getInt("dias_vigencia");
                String titulo = rs.getString("titulo");
                int estado = rs.getInt("estado");
                int idComercio = rs.getInt("idComercio");
                
                Comercio co = new Comercio();
                co.setId(idComercio);
                Oferta o = new Oferta(id, cantidad, po, fio, dias_vigencia, titulo, estado, co);

                lista.add(o);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }

        return lista;
    }

    //Editar 1 Rubro
    public void actualizarOferta(Oferta o) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Ofertas SET cantidad =?,precio_oferta=?, fecha_inicio_oferta=?,dias_vigencia=?,titulo=?,estado=?, idComercio=? where idOferta=? ");
            ps.clearParameters();
            ps.setInt(1, o.getCantidad());
            ps.setDouble(2, o.getPrecio());
            ps.setString(3, o.getFechaInicioOferta());
            ps.setInt(4, o.getDiasVigencia());
            ps.setString(5, o.getTitulo());
            ps.setInt(6, o.getEstado());
            ps.setInt(7, o.getComercio().getId());//ver

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

    //Obtener rubro-Lista-update por id
    public Oferta obtenerOfertaUpdate(int idOferta) {
        Oferta o = null;
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Ofertas WHERE idOferta = ?");
            ps.setInt(1, idOferta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idOferta");
                int cantidad = rs.getInt("cantidad");
                double po = rs.getDouble("precio_oferta");
                String fio = rs.getString("fecha_inicio_oferta");
                int dv = rs.getInt("dias_vigencia");
                String titulo = rs.getString("titulo");
                int estado = rs.getInt("estado");
                int idComercio = rs.getInt("idComercio");
                
                Comercio com = obtenerComercioUpdate(idComercio);
                o = new Oferta(id, cantidad, po, fio, dv, titulo, estado, com);
                o.setId(id);
            }
            rs.close();
        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            cerrarConexion();
        }
        return o;
    }
    
    
    public void bajaOferta(int idOferta) {
        try {
            abrirConexion();
            PreparedStatement ps = con.prepareStatement("UPDATE Ofertas SET estado = 0 where idOferta = ?");
            ps.clearParameters();
            ps.setInt(1, idOferta);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            cerrarConexion();
        }
    }

}
