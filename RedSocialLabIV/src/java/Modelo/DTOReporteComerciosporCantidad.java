package Modelo;

public class DTOReporteComerciosporCantidad {
    public String Comercio;
    public int Cant_Comentarios;

   
    public String getComercio() {
        return Comercio;
    }

    public void setComercio(String Comercio) {
        this.Comercio = Comercio;
    }

    public int getCant_Comentarios() {
        return Cant_Comentarios;
    }

    public void setCant_Comentarios(int Cant_Comentarios) {
        this.Cant_Comentarios = Cant_Comentarios;
    }

    public DTOReporteComerciosporCantidad(String Comercio, int Cant_Comentarios) {
        this.Comercio = Comercio;
        this.Cant_Comentarios = Cant_Comentarios;
    }
    
    
}

