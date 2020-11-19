
package Controlador;

import Modelo.Comentario;
import Modelo.Consulta;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class GComentarios {
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
    
    public boolean RegistrarComentario(Comentario co){
         boolean inserto = false;
         try{
             c.Conectar();
             Consulta = "exec procedure SPComentario_Registrar ?, ?, ?, ?";
             
             ps = con.prepareStatement(Consulta);
             ps.clearParameters();            
             ps.setString(0, co.getTitulo());
             ps.setString(1, co.getComentario());
             ps.setDouble(2, co.getValoracion());
             ps.setInt(3, co.getComercio().getId_Comercio());
             
             inserto = ps.execute();
         }
         catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Ocurrio un problema al intentar insertar la comentario.\nDescripcion: " + ex,
                     "Registrar comentario", JOptionPane.ERROR_MESSAGE);
             con = null;
         }
         finally{
             c.Desconectar();
             return inserto;
         }
     }
     
     public boolean DarBajaComentario(Comentario co){
         boolean Dar_Baja = false;
         try{
             c.Conectar();
             Consulta = "exec procedure SPComentario_Dar_Baja ?";
             
             ps = con.prepareStatement(Consulta);
             ps.clearParameters();            
             ps.setInt(0, co.getId_Comentario());
             
             Dar_Baja = ps.execute();
         }
         catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Ocurrio un problema al intentar eliminar la comentario.\nDescripcion: " + ex,
                     "Eliminar comentario", JOptionPane.ERROR_MESSAGE);
             con = null;
         }
         finally{
             c.Desconectar();
             return Dar_Baja;
         }
     }
    
}
