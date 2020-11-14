package Modelo;


public class DTOOfertas {

    private int idOferta; 
    private String titulo;
    private double precio; 
    private String fechaInicioOferta;
    private int diasVigencia;
    private int estado;
    private String comercio;

    public DTOOfertas(int idOferta, String titulo, double precio, String fechaInicioOferta, int diasVigencia, int estado, String comercio) {
        this.idOferta = idOferta;
        this.titulo = titulo;
        this.precio = precio;
        this.fechaInicioOferta = fechaInicioOferta;
        this.diasVigencia = diasVigencia;
        this.estado = estado;
        this.comercio = comercio;
    }

    public int getIdOferta() {
        return idOferta;
    }

    public void setIdOferta(int idOferta) {
        this.idOferta = idOferta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public DTOOfertas() {
    }

    @Override
    public String toString() {
        return "DTOOfertas{" + "idOferta=" + idOferta + ", titulo=" + titulo + ", precio=" + precio + ", fechaInicioOferta=" + fechaInicioOferta + ", diasVigencia=" + diasVigencia + ", estado=" + estado + ", comercio=" + comercio + '}';
    }
    
    
    
    
    
    
}
