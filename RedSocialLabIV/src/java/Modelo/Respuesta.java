/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class Respuesta {
    private int idRespuesta;
    private int idComercio;
    private int idComentario;
    private String respuesta;

    public Respuesta() {
    }

    public Respuesta(int idRespuesta, int idComercio, int idComentario, String respuesta) {
        this.idRespuesta = idRespuesta;
        this.idComercio = idComercio;
        this.idComentario = idComentario;
        this.respuesta = respuesta;
    }

    

    public int getIdRespuesta() {
        return idRespuesta;
    }

    public void setIdRespuesta(int idRespuesta) {
        this.idRespuesta = idRespuesta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public int getIdComentario() {
        return idComentario;
    }

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public int getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(int idComercio) {
        this.idComercio = idComercio;
    }
    
    
}
