
package Modelo;


public class DtoComercio {
   
    private String fechainicio;
    private String rubro;
    private int estado;
    private String nombre;

    public DtoComercio(String fechainicio, String rubro, int estado, String nombre) {
        this.fechainicio = fechainicio;
        this.rubro = rubro;
        this.estado = estado;
        this.nombre = nombre;
    }

    public DtoComercio() {
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "DtoComercio{" + "fechainicio=" + fechainicio + ", rubro=" + rubro + ", estado=" + estado + ", nombre=" + nombre + '}';
    }

       
    
}
