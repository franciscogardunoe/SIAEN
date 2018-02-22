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

    private String accion;
    private String mensaje;
    private String tipoMensaje;

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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    public String registrarEncuesta() {
        DaoCreacion daoC = new DaoCreacion();
        BeanEncuesta beanE = new BeanEncuesta();
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
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
            setAccion("Correcto");
            setMensaje("La Encuesta fue registrada exitosamente");
            setTipoMensaje("success");
            return SUCCESS;
        } else {
            setAccion("Error");
            setMensaje("La Encuesta no fue registrada");
            setTipoMensaje("error");
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
        setUnaEncuesta(daoC.consultarEncuesta(getCodigo()));
        setMisPreguntas(daoC.cosultarPreguntas(getCodigo()));
        return SUCCESS;
    }

    public String modificarEncuesta() {
        DaoCreacion daoC = new DaoCreacion();
        BeanEncuesta beanE = new BeanEncuesta();
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        beanE.setIdEncuesta(getUnaEncuesta().getIdEncuesta());
        beanE.setNombre(getUnaEncuesta().getNombre());
        beanE.setDescripcion(getUnaEncuesta().getDescripcion());
        if (daoC.modificarEncuesta(beanE)) {
            setAccion("Correcto");
            setMensaje("Los datos de la Encuesta fueron modificados exitosamente");
            setTipoMensaje("success");
            return SUCCESS;
        } else {
            setAccion("Error");
            setMensaje("Los datos de la Encuesta no fueron modificados");
            setTipoMensaje("error");
            return ERROR;
        }
    }
}
