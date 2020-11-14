
package Modelo;


public class Comercio {
    
    private int id;
    private String fechainicio;
    private Rubro rubro;
    private int estado;
    private String nombre;

    public Comercio(int id, String fechainicio, Rubro rubro, int estado, String nombre) {
        this.id = id;
        this.fechainicio = fechainicio;
        this.rubro = rubro;
        this.estado = estado;
        this.nombre = nombre;
    }

    public Comercio() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(String fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Rubro getRubro() {
        return rubro;
    }

    public void setRubro(Rubro rubro) {
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
        return "Comercio{" + ", rubro=" + rubro + ", nombre=" + nombre;
    }
    
    
            
    
    
}
