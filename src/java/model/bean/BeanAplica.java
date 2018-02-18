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
public class BeanAplica {
    private int idAplica;
    private String fechaAplicacion;
    private int estado;
    private BeanEncuesta encuesta;
    private BeanUsuario usuario;

    public BeanAplica() {
    }

    public int getIdAplica() {
        return idAplica;
    }

    public void setIdAplica(int idAplica) {
        this.idAplica = idAplica;
    }

    public String getFechaAplicacion() {
        return fechaAplicacion;
    }

    public void setFechaAplicacion(String fechaAplicacion) {
        this.fechaAplicacion = fechaAplicacion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public BeanEncuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(BeanEncuesta encuesta) {
        this.encuesta = encuesta;
    }

    public BeanUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(BeanUsuario usuario) {
        this.usuario = usuario;
    }
    
}
