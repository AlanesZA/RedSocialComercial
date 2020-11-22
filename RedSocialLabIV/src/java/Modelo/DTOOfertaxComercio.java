
package Modelo;


public class DTOOfertaxComercio {
    private int cantidad;
    private String fecha_inicio;
    private String precio_oferta;
    private String fecha_inicio_oferta;
    private int dias_vigencia;
    private String titulo;
    private String comercio;
    private String rubro;

    public DTOOfertaxComercio(int cantidad, String fecha_inicio, String precio_oferta, String fecha_inicio_oferta, int dias_vigencia, String titulo, String comercio, String rubro) {
        this.cantidad = cantidad;
        this.fecha_inicio = fecha_inicio;
        this.precio_oferta = precio_oferta;
        this.fecha_inicio_oferta = fecha_inicio_oferta;
        this.dias_vigencia = dias_vigencia;
        this.titulo = titulo;
        this.comercio = comercio;
        this.rubro = rubro;
    }

    
    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public String getRubro() {
        return rubro;
    }

    public void setRubro(String rubro) {
        this.rubro = rubro;
    }
    
    public DTOOfertaxComercio() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getPrecio_oferta() {
        return precio_oferta;
    }

    public void setPrecio_oferta(String precio_oferta) {
        this.precio_oferta = precio_oferta;
    }

    public String getFecha_inicio_oferta() {
        return fecha_inicio_oferta;
    }

    public void setFecha_inicio_oferta(String fecha_inicio_oferta) {
        this.fecha_inicio_oferta = fecha_inicio_oferta;
    }

    public int getDias_vigencia() {
        return dias_vigencia;
    }

    public void setDias_vigencia(int dias_vigencia) {
        this.dias_vigencia = dias_vigencia;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "DTOOfertaxComercio{" + "cantidad=" + cantidad + ", fecha_inicio=" + fecha_inicio + ", precio_oferta=" + precio_oferta + ", fecha_inicio_oferta=" + fecha_inicio_oferta + ", dias_vigencia=" + dias_vigencia + ", titulo=" + titulo + ", comercio=" + comercio + ", rubro=" + rubro + '}';
    }

    
    
}
