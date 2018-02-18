/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.bean;

/**
 *
 * @author franc
 */
public class BeanOpcion {
    private int idOpcion;
    private String opcion;
    private int esAbierta;
    private int estado;
    private BeanPregunta pregunta;

    public BeanOpcion() {
    }

    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public int getEsAbierta() {
        return esAbierta;
    }

    public void setEsAbierta(int esAbierta) {
        this.esAbierta = esAbierta;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public BeanPregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(BeanPregunta pregunta) {
        this.pregunta = pregunta;
    }
    
}
