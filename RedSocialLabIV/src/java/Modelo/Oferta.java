
package Modelo;

public class Oferta {
    private int id; 
    private int cantidad;
    private double precio; 
    private String fechaInicioOferta;
    private int diasVigencia;
    private String titulo;
    private int estado;
    private Comercio comercio;

    public Oferta(int id, int cantidad, double precio, String fechaInicioOferta, int diasVigencia, String titulo, int estado, Comercio comercio) {
        this.id = id;
        this.cantidad = cantidad;
        this.precio = precio;
        this.fechaInicioOferta = fechaInicioOferta;
        this.diasVigencia = diasVigencia;
        this.titulo = titulo;
        this.estado = estado;
        this.comercio = comercio;
    }

    public Oferta() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getFechaInicioOferta() {
        return fechaInicioOferta;
    }

    public void setFechaInicioOferta(String fechaInicioOferta) {
        this.fechaInicioOferta = fechaInicioOferta;
    }

    public int getDiasVigencia() {
        return diasVigencia;
    }

    public void setDiasVigencia(int diasVigencia) {
        this.diasVigencia = diasVigencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    @Override
    public String toString() {
        return "Oferta{" + "id=" + id + ", cantidad=" + cantidad + ", precio=" + precio + ", fechaInicioOferta=" + fechaInicioOferta + ", diasVigencia=" + diasVigencia + ", titulo=" + titulo + ", estado=" + estado + ", comercio=" + comercio + '}';
    }

    
}
