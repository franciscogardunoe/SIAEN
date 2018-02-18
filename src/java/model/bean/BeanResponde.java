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
public class BeanResponde {

    private int idResponde;
    private String respuestaAbierta;
    private BeanAplica aplica;
    private BeanPregunta pregunta;
    private BeanOpcion opcion;

    public BeanResponde() {
    }

    public int getIdResponde() {
        return idResponde;
    }

    public void setIdResponde(int idResponde) {
        this.idResponde = idResponde;
    }

    public String getRespuestaAbierta() {
        return respuestaAbierta;
    }

    public void setRespuestaAbierta(String respuestaAbierta) {
        this.respuestaAbierta = respuestaAbierta;
    }

    public BeanAplica getAplica() {
        return aplica;
    }

    public void setAplica(BeanAplica aplica) {
        this.aplica = aplica;
    }

    public BeanPregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(BeanPregunta pregunta) {
        this.pregunta = pregunta;
    }

    public BeanOpcion getOpcion() {
        return opcion;
    }

    public void setOpcion(BeanOpcion opcion) {
        this.opcion = opcion;
    }

}
