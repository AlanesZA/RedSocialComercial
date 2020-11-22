package Modelo;

public class DTOReporteComerciosporCantidad {
    public String comercio;
    public int cantComentarios;

   
    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public int getCantComentarios() {
        return cantComentarios;
    }

    public void setCant_Comentarios(int cantComentarios) {
        this.cantComentarios = cantComentarios;
    }

    public DTOReporteComerciosporCantidad(String comercio, int cantComentarios) {
        this.comercio = comercio;
        this.cantComentarios = cantComentarios;
    }
    
    
}

