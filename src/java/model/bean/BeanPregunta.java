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
public class BeanPregunta {

    private int idPregunta;
    private String pregunta;
    private int obligatoria;
    private int estado;
    private BeanTipo tipo;
    private BeanEncuesta encuesta;

    public BeanPregunta() {
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getObligatoria() {
        return obligatoria;
    }

    public void setObligatoria(int obligatoria) {
        this.obligatoria = obligatoria;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public BeanTipo getTipo() {
        return tipo;
    }

    public void setTipo(BeanTipo tipo) {
        this.tipo = tipo;
    }

    public BeanEncuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(BeanEncuesta encuesta) {
        this.encuesta = encuesta;
    }

}
