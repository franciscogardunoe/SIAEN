/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import static com.opensymphony.xwork2.Action.SUCCESS;
import model.bean.BeanEncuesta;
import model.bean.BeanUsuario;
import model.dao.DaoCreacion;

/**
 *
 * @author franc
 */
public class ControllerCreacion {

    private BeanEncuesta unaEncuesta;

    public ControllerCreacion() {
    }

    public BeanEncuesta getUnaEncuesta() {
        return unaEncuesta;
    }

    public void setUnaEncuesta(BeanEncuesta unaEncuesta) {
        this.unaEncuesta = unaEncuesta;
    }

    public String registrarEncuesta() {
        DaoCreacion daoC = new DaoCreacion();
        BeanEncuesta beanE = new BeanEncuesta();
        beanE.setNombre(getUnaEncuesta().getNombre());
        beanE.setDescripcion(getUnaEncuesta().getNombre());
        BeanUsuario beanU = new BeanUsuario();
        beanU.setIdUsuario(1);
        beanE.setUsuario(beanU);

        //Generar código de la encuesta
        String nombre = getUnaEncuesta().getNombre().trim();

        return SUCCESS;
    }

    public boolean verificarCodigo(String código) {
        return true;
    }
}
