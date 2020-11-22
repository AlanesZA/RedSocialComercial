package Modelo;

public class DTOPromedioValoracionxComercio {
    public String comercio;
    public float promedio;

    public String getComercio() {
        return comercio;
    }

    public void setComercio(String comercio) {
        this.comercio = comercio;
    }

    public float getPromedio() {
        return promedio;
    }

    public void setPromedio(float promedio) {
        this.promedio = promedio;
    }

    public DTOPromedioValoracionxComercio(String comercio, float promedio) {
        this.comercio = comercio;
        this.promedio = promedio;
    }
    
    
}
