/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import java.util.List;
import java.util.Random;
import model.bean.BeanEncuesta;
import model.bean.BeanPregunta;
import model.bean.BeanUsuario;
import model.dao.DaoCreacion;

/**
 *
 * @author franc
 */
public class ControllerCreacion {

    private BeanEncuesta unaEncuesta;
    private List<BeanEncuesta> misEncuestas;
    private List<BeanPregunta> misPreguntas;
    private String codigo;
    private int numeroPreguntas;

    public ControllerCreacion() {
    }

    public BeanEncuesta getUnaEncuesta() {
        return unaEncuesta;
    }

    public void setUnaEncuesta(BeanEncuesta unaEncuesta) {
        this.unaEncuesta = unaEncuesta;
    }

    public List<BeanEncuesta> getMisEncuestas() {
        return misEncuestas;
    }

    public void setMisEncuestas(List<BeanEncuesta> misEncuestas) {
        this.misEncuestas = misEncuestas;
    }

    public List<BeanPregunta> getMisPreguntas() {
        return misPreguntas;
    }

    public void setMisPreguntas(List<BeanPregunta> misPreguntas) {
        this.misPreguntas = misPreguntas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getNumeroPreguntas() {
        return numeroPreguntas;
    }

    public void setNumeroPreguntas(int numeroPreguntas) {
        this.numeroPreguntas = numeroPreguntas;
    }

    public String registrarEncuesta() {
        DaoCreacion daoC = new DaoCreacion();
        BeanEncuesta beanE = new BeanEncuesta();
        beanE.setNombre(getUnaEncuesta().getNombre());
        beanE.setDescripcion(getUnaEncuesta().getDescripcion());
        BeanUsuario beanU = new BeanUsuario();
        beanU.setIdUsuario(2);
        beanE.setUsuario(beanU);
        setCodigo(generarCodigo(getUnaEncuesta().getNombre().trim()));
        beanE.setCodigo(getCodigo());
        if (daoC.registrarEncuesta(beanE)) {
            setUnaEncuesta(daoC.consultarEncuesta(getCodigo()));
            setMisPreguntas(daoC.cosultarPreguntas(getCodigo()));
            setNumeroPreguntas(getMisPreguntas().size());
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public static String generarCodigo(String nombre) {
        Random r = new Random();
        int primero = r.nextInt(8) + 1;
        int segundo = r.nextInt(8) + 1;
        int tercero = r.nextInt(8) + 1;
        String caracter1 = "" + nombre.charAt(1);
        String codigo = "" + primero + "" + caracter1.toLowerCase() + "" + segundo + caracter1.toUpperCase() + "" + tercero + "" + nombre.charAt(2);
        return codigo;
    }

    public String consultarEncuestas() {
        DaoCreacion daoC = new DaoCreacion();
        setMisEncuestas(daoC.cosultarEncuestas(2));
        return SUCCESS;
    }

    public String consultarEncuesta() {
        DaoCreacion daoC = new DaoCreacion();
        setUnaEncuesta(daoC.consultarEncuesta(getUnaEncuesta().getCodigo()));
        setMisPreguntas(daoC.cosultarPreguntas(getCodigo()));
        return SUCCESS;
    }
}
