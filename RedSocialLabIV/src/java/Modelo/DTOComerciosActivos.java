
package Modelo;

public class DTOComerciosActivos {
    
    private int idComercio;
    private String fecha_inicio;
    private String rubro;
    private String nombre;

    public DTOComerciosActivos(int idComercio, String fecha_inicio, String rubro, String nombre) {
        this.idComercio = idComercio;
        this.fecha_inicio = fecha_inicio;
        this.rubro = rubro;
        this.nombre = nombre;
    }

    public DTOComerciosActivos() {
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

    @Override
    public String toString() {
        return "" + rubro + ", " + nombre + "";
    }
    
    
    
}
