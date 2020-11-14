
package Modelo;


public class Rubro {
    
    private int id;
    private String rubro;
    private String descripcion;
    private int estado;

    public Rubro(int id, String rubro, String descripcion, int estado) {
        this.id = id;
        this.rubro = rubro;
        this.descripcion = descripcion;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Rubro() {
    }

    @Override
    public String toString() {
        return  rubro ;
    }
   
}
