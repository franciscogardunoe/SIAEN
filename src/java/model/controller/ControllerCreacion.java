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
import model.bean.BeanTipo;
import model.bean.BeanUsuario;
import model.dao.DaoCreacion;
import model.bean.BeanOpcion;

/**
 *
 * @author franc
 */
public class ControllerCreacion {

    private BeanEncuesta unaEncuesta;
    private BeanPregunta unaPregunta;
    private List<BeanEncuesta> misEncuestas;
    private List<BeanPregunta> misPreguntas;
    private List<BeanOpcion> misOpciones;
    private String codigo;
    private int numeroPreguntas;
    private int numeroEncuestas;
    private int numeroOpciones;

    private String accion;
    private String mensaje;
    private String tipoMensaje;

    String opcion1;
    String opcion2;
    String opcion3;
    String opcion4;
    String opcion5;

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

    public BeanPregunta getUnaPregunta() {
        return unaPregunta;
    }

    public void setUnaPregunta(BeanPregunta unaPregunta) {
        this.unaPregunta = unaPregunta;
    }

    public int getNumeroEncuestas() {
        return numeroEncuestas;
    }

    public void setNumeroEncuestas(int numeroEncuestas) {
        this.numeroEncuestas = numeroEncuestas;
    }

    public String getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(String opcion1) {
        this.opcion1 = opcion1;
    }

    public String getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(String opcion2) {
        this.opcion2 = opcion2;
    }

    public String getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(String opcion3) {
        this.opcion3 = opcion3;
    }

    public String getOpcion4() {
        return opcion4;
    }

    public void setOpcion4(String opcion4) {
        this.opcion4 = opcion4;
    }

    public String getOpcion5() {
        return opcion5;
    }

    public void setOpcion5(String opcion5) {
        this.opcion5 = opcion5;
    }

    public List<BeanOpcion> getMisOpciones() {
        return misOpciones;
    }

    public void setMisOpciones(List<BeanOpcion> misOpciones) {
        this.misOpciones = misOpciones;
    }

    public int getNumeroOpciones() {
        return numeroOpciones;
    }

    public void setNumeroOpciones(int numeroOpciones) {
        this.numeroOpciones = numeroOpciones;
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
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        DaoCreacion daoC = new DaoCreacion();
        setMisEncuestas(daoC.cosultarEncuestas(2));
        return SUCCESS;
    }
    
    public String consultarEncuesta() {
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        DaoCreacion daoC = new DaoCreacion();
        setUnaEncuesta(daoC.consultarEncuesta(getCodigo()));
        setMisPreguntas(daoC.cosultarPreguntas(getCodigo()));
        setNumeroPreguntas(getMisPreguntas().size());
        System.out.println("Código: " + codigo);
        System.out.println(getMisPreguntas());
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

    public String registrarPreguntaAbierta() {
        DaoCreacion daoC = new DaoCreacion();
        BeanPregunta unaP = new BeanPregunta();
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        unaP.setPregunta(getUnaPregunta().getPregunta());
        unaP.setObligatoria(getUnaPregunta().getObligatoria());
        BeanTipo unT = new BeanTipo();
        unT.setIdTipo(3);
        unaP.setTipo(unT);
        BeanEncuesta unaE = new BeanEncuesta();
        unaE.setIdEncuesta(getUnaEncuesta().getIdEncuesta());
        unaP.setEncuesta(unaE);
        if (daoC.registrarPreguntaAbierta(unaP)) {
            setAccion("Correcto");
            setMensaje("La Pregunta fue registrada exitosamente");
            setTipoMensaje("success");
            return SUCCESS;
        } else {
            setAccion("Error");
            setMensaje("La Pregunta no fue registrada");
            setTipoMensaje("error");
            return ERROR;
        }
    }

    public String registrarPreguntaMultiple() {
        DaoCreacion daoC = new DaoCreacion();
        BeanPregunta unaP = new BeanPregunta();
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        unaP.setPregunta(getUnaPregunta().getPregunta());
        unaP.setObligatoria(getUnaPregunta().getObligatoria());
        BeanTipo unT = new BeanTipo();
        unT.setIdTipo(2);
        unaP.setTipo(unT);
        BeanEncuesta unaE = new BeanEncuesta();
        unaE.setIdEncuesta(getUnaEncuesta().getIdEncuesta());
        unaP.setEncuesta(unaE);
        int idPregunta = daoC.registrarPreguntaOpcion(unaP);
        if (idPregunta != 0) {
            setAccion("Correcto");
            setMensaje("La Pregunta fue registrada exitosamente");
            setTipoMensaje("success");
            if (getOpcion1() != "") {
                BeanOpcion beanO = new BeanOpcion();
                BeanPregunta beanP = new BeanPregunta();
                beanO.setOpcion(getOpcion1());
                beanO.setEsAbierta(0);
                beanP.setIdPregunta(idPregunta);
                beanO.setPregunta(beanP);
                daoC.registrarOpcion(beanO);
            }
            if (getOpcion2() != "") {
                BeanOpcion beanO = new BeanOpcion();
                BeanPregunta beanP = new BeanPregunta();
                beanO.setOpcion(getOpcion2());
                beanO.setEsAbierta(0);
                beanP.setIdPregunta(idPregunta);
                beanO.setPregunta(beanP);
                daoC.registrarOpcion(beanO);
            }
            if (getOpcion3() != "") {
                BeanOpcion beanO = new BeanOpcion();
                BeanPregunta beanP = new BeanPregunta();
                beanO.setOpcion(getOpcion3());
                beanO.setEsAbierta(0);
                beanP.setIdPregunta(idPregunta);
                beanO.setPregunta(beanP);
                daoC.registrarOpcion(beanO);
            }
            if (getOpcion4() != "") {
                BeanOpcion beanO = new BeanOpcion();
                BeanPregunta beanP = new BeanPregunta();
                beanO.setOpcion(getOpcion4());
                beanO.setEsAbierta(0);
                beanP.setIdPregunta(idPregunta);
                beanO.setPregunta(beanP);
                daoC.registrarOpcion(beanO);
            }
            if (getOpcion5() != "") {
                BeanOpcion beanO = new BeanOpcion();
                BeanPregunta beanP = new BeanPregunta();
                beanO.setOpcion(getOpcion5());
                beanO.setEsAbierta(0);
                beanP.setIdPregunta(idPregunta);
                beanO.setPregunta(beanP);
                daoC.registrarOpcion(beanO);
            }
            return SUCCESS;
        } else {
            setAccion("Error");
            setMensaje("La Pregunta no fue registrada");
            setTipoMensaje("error");
            return ERROR;
        }
    }

    public String registrarPreguntaOpcion() {
        DaoCreacion daoC = new DaoCreacion();
        BeanPregunta unaP = new BeanPregunta();
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        unaP.setPregunta(getUnaPregunta().getPregunta());
        unaP.setObligatoria(getUnaPregunta().getObligatoria());
        BeanTipo unT = new BeanTipo();
        unT.setIdTipo(1);
        unaP.setTipo(unT);
        BeanEncuesta unaE = new BeanEncuesta();
        unaE.setIdEncuesta(getUnaEncuesta().getIdEncuesta());
        unaP.setEncuesta(unaE);
        int idPregunta = daoC.registrarPreguntaOpcion(unaP);
        if (idPregunta != 0) {
            setAccion("Correcto");
            setMensaje("La Pregunta fue registrada exitosamente");
            setTipoMensaje("success");
            if (getOpcion1() != "") {
                BeanOpcion beanO = new BeanOpcion();
                BeanPregunta beanP = new BeanPregunta();
                beanO.setOpcion(getOpcion1());
                beanO.setEsAbierta(0);
                beanP.setIdPregunta(idPregunta);
                beanO.setPregunta(beanP);
                daoC.registrarOpcion(beanO);
            }
            if (getOpcion2() != "") {
                BeanOpcion beanO = new BeanOpcion();
                BeanPregunta beanP = new BeanPregunta();
                beanO.setOpcion(getOpcion2());
                beanO.setEsAbierta(0);
                beanP.setIdPregunta(idPregunta);
                beanO.setPregunta(beanP);
                daoC.registrarOpcion(beanO);
            }
            if (getOpcion3() != "") {
                BeanOpcion beanO = new BeanOpcion();
                BeanPregunta beanP = new BeanPregunta();
                beanO.setOpcion(getOpcion3());
                beanO.setEsAbierta(0);
                beanP.setIdPregunta(idPregunta);
                beanO.setPregunta(beanP);
                daoC.registrarOpcion(beanO);
            }
            if (getOpcion4() != "") {
                BeanOpcion beanO = new BeanOpcion();
                BeanPregunta beanP = new BeanPregunta();
                beanO.setOpcion(getOpcion4());
                beanO.setEsAbierta(0);
                beanP.setIdPregunta(idPregunta);
                beanO.setPregunta(beanP);
                daoC.registrarOpcion(beanO);
            }
            if (getOpcion5() != "") {
                BeanOpcion beanO = new BeanOpcion();
                BeanPregunta beanP = new BeanPregunta();
                beanO.setOpcion(getOpcion5());
                beanO.setEsAbierta(0);
                beanP.setIdPregunta(idPregunta);
                beanO.setPregunta(beanP);
                daoC.registrarOpcion(beanO);
            }
            return SUCCESS;
        } else {
            setAccion("Error");
            setMensaje("La Pregunta no fue registrada");
            setTipoMensaje("error");
            return ERROR;
        }
    }

    public String eliminarEncuesta() {
        DaoCreacion daoC = new DaoCreacion();
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        if (daoC.eliminarEncuesta(getUnaEncuesta().getIdEncuesta())) {
            setAccion("Correcto");
            setMensaje("La Encuesta fue eliminada exitosamente");
            setTipoMensaje("success");
            return SUCCESS;
        } else {
            setAccion("Error");
            setMensaje("La Encuesta no fue eliminada");
            setTipoMensaje("error");
            return ERROR;
        }
    }

    public String eliminarPregunta() {
        DaoCreacion daoC = new DaoCreacion();
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        if (daoC.eliminarPregunta(getUnaPregunta().getIdPregunta())) {
            setAccion("Correcto");
            setMensaje("La Pregunta fue eliminada exitosamente");
            setTipoMensaje("success");
            return SUCCESS;
        } else {
            setAccion("Error");
            setMensaje("La Pregunta no fue eliminada");
            setTipoMensaje("error");
            return ERROR;
        }
    }

    public String consultarPregunta() {
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        DaoCreacion daoC = new DaoCreacion();
        setMisOpciones(daoC.cosultarOpciones(getUnaPregunta().getIdPregunta()));
        setUnaPregunta(daoC.consultarPregunta(getUnaPregunta().getIdPregunta()));
        setNumeroOpciones(getMisOpciones().size());
        return SUCCESS;
    }

    public String registrarOpcion() {
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        DaoCreacion daoC = new DaoCreacion();
        BeanOpcion beanO = new BeanOpcion();
        BeanPregunta beanP = new BeanPregunta();
        beanO.setOpcion(getOpcion1());
        beanO.setEsAbierta(0);
        beanP.setIdPregunta(getUnaPregunta().getIdPregunta());
        beanO.setPregunta(beanP);
        if (daoC.registrarOpcion(beanO)) {
            setAccion("Correcto");
            setMensaje("La Opción fue registrada exitosamente");
            setTipoMensaje("success");
            return SUCCESS;
        } else {
            setAccion("Error");
            setMensaje("La Opción no fue registrada");
            setTipoMensaje("error");
            return ERROR;
        }
    }

}
