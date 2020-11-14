
package Modelo;

public class DTOComerciosNoActivos {
    
    private int idComercio;
    private String fecha_inicio;
    private int estado;
    private String rubro;
    private String nombre;

    public DTOComerciosNoActivos(int idComercio, String fecha_inicio, int estado, String rubro, String nombre) {
        this.idComercio = idComercio;
        this.fecha_inicio = fecha_inicio;
        this.estado = estado;
        this.rubro = rubro;
        this.nombre = nombre;
    }

    public int getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(int idComercio) {
        this.idComercio = idComercio;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public DTOComerciosNoActivos() {
    }

    
    
    @Override
    public String toString() {
        return "DTOComerciosNoActivos{" + "idComercio=" + idComercio + ", fecha_inicio=" + fecha_inicio + ", estado=" + estado + ", rubro=" + rubro + ", nombre=" + nombre + '}';
    }

    
    
    
}
