package Modelo;

public class DTOComentariosSinRespuestas {

    public String descripcion;
    public String comercio;
    public int estado;
    public int valoracion;

    public DTOComentariosSinRespuestas(String descripcion, String comercio, int estado, int valoracion) {
        this.descripcion = descripcion;
        this.comercio = comercio;
        this.estado = estado;
        this.valoracion = valoracion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getComercio() {
        return comercio;
    }

    public void setComercio(String Comercio) {
        this.comercio = Comercio;
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

    public DTOComentariosSinRespuestas() {
    }

    @Override
    public String toString() {
        return "DTOComentariosSinRespuestas{" + "descripcion=" + descripcion + ", comercio=" + comercio + ", estado=" + estado + ", valoracion=" + valoracion + '}';
    }
    
    

}
