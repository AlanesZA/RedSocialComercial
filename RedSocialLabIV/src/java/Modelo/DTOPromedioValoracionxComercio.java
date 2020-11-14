package Modelo;

public class DTOPromedioValoracionxComercio {
    public String Comercio;
    public float Promedio;

    public String getComercio() {
        return Comercio;
    }

    public void setComercio(String Comercio) {
        this.Comercio = Comercio;
    }

    public float getPromedio() {
        return Promedio;
    }

    public void setPromedio(float Promedio) {
        this.Promedio = Promedio;
    }

    public DTOPromedioValoracionxComercio(String Comercio, float Promedio) {
        this.Comercio = Comercio;
        this.Promedio = Promedio;
    }
    
    
}
