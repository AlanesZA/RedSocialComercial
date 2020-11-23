package Modelo;

public class Comentario {

    private int idComentario;
    private String descripcion;
    private Comercio comercio;
    private int estado;
    private int valoracion;
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Comentario(int idComentario, String descripcion, Comercio comercio, int estado, int valoracion, String nombre) {
        this.idComentario = idComentario;
        this.descripcion = descripcion;
        this.comercio = comercio;
        this.estado = estado;
        this.valoracion = valoracion;
        this.nombre = nombre;
    }

    public Comentario(String descripcion, Comercio comercio, int estado, int valoracion, String nombre) {
        this.descripcion = descripcion;
        this.comercio = comercio;
        this.estado = estado;
        this.valoracion = valoracion;
        this.nombre = nombre;
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

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
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

    public Comentario() {
    }

    @Override
    public String toString() {
        return "Comentario{" + "idComentario=" + idComentario + ", descripcion=" + descripcion + ", Comercio=" + comercio + ", estado=" + estado + ", valoracion=" + valoracion + ", nombre=" + nombre + '}';
    }

   
   
}
