package Modelo;

public class DTOComentariosSinRespuestas {

    public String descripcion;
    public String Comercio;
    public int estado;
    public int valoracion;

    public DTOComentariosSinRespuestas(String descripcion, String Comercio, int estado, int valoracion) {
        this.descripcion = descripcion;
        this.Comercio = Comercio;
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

    public DTOComentariosSinRespuestas() {
    }

}
