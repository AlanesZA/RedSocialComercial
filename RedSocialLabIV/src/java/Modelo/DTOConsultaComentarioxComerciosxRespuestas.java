
package Modelo;


public class DTOConsultaComentarioxComerciosxRespuestas {
    private int idComentario;
    private String nombreCliente;
    private String comercio;
    private String titulo;
    private String comentario;
    private int valoracion;

    public DTOConsultaComentarioxComerciosxRespuestas(int idComentario, String nombreCliente, String comercio, String titulo, String comentario, int valoracion) {
        this.idComentario = idComentario;
        this.nombreCliente = nombreCliente;
        this.comercio = comercio;
        this.titulo = titulo;
        this.comentario = comentario;
        this.valoracion = valoracion;
    }

    public DTOConsultaComentarioxComerciosxRespuestas() {
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "DTOConsultaComentarioxComerciosxRespuestas{" + "idComentario=" + idComentario + ", nombreCliente=" + nombreCliente + ", comercio=" + comercio + ", titulo=" + titulo + ", comentario=" + comentario + ", valoracion=" + valoracion + '}';
    }

    
    
}
