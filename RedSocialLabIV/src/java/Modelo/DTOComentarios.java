package Modelo;

public class DTOComentarios {
    public int idComentario;
    public String descripcion;
    public String Comercio;
    public int estado;
    public int valoracion;

    public DTOComentarios(int idComentario, String descripcion, String Comercio, int estado, int valoracion) {
        this.idComentario = idComentario;
        this.descripcion = descripcion;
        this.Comercio = Comercio;
        this.estado = estado;
        this.valoracion = valoracion;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComercio() {
        return Comercio;
    }

    public void setComercio(String Comercio) {
        this.Comercio = Comercio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public DTOComentarios() {
    }
   

    
    
}
