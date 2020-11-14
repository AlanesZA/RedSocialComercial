package Modelo;

public class Consulta {
    private int Id_Consulta;
    private String Titulo;
    private String Consulta;
    private Comercio Comercio;
    private boolean Disponible;

    public int getId_Consulta() {
        return Id_Consulta;
    }

    public void setId_Consulta(int Id_Consulta) {
        this.Id_Consulta = Id_Consulta;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getConsulta() {
        return Consulta;
    }

    public void setConsulta(String Consulta) {
        this.Consulta = Consulta;
    }

    public Comercio getComercio() {
        return Comercio;
    }

    public void setComercio(Comercio Comercio) {
        this.Comercio = Comercio;
    }

    public boolean isDisponible() {
        return Disponible;
    }

    public void setDisponible(boolean Disponible) {
        this.Disponible = Disponible;
    }

    public Consulta(int Id_Consulta, boolean Disponible) {
        this.Id_Consulta = Id_Consulta;
        this.Disponible = Disponible;
    }

    public Consulta(String Titulo, String Consulta, Comercio Comercio) {
        this.Titulo = Titulo;
        this.Consulta = Consulta;
        this.Comercio = Comercio;
    }

    public Consulta(int Id_Consulta, String Titulo, String Consulta, Comercio Comercio) {
        this.Id_Consulta = Id_Consulta;
        this.Titulo = Titulo;
        this.Consulta = Consulta;
        this.Comercio = Comercio;
    }
    
}
