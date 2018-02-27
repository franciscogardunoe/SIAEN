/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import java.util.List;
import java.util.Map;
import java.util.Random;
import model.bean.BeanAplica;
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
    private BeanAplica unaAplica;
    private List<BeanEncuesta> misEncuestas;
    private List<BeanPregunta> misPreguntas;
    private List<BeanOpcion> misOpciones;
    private List<BeanAplica> misEncuestasUsuario;
    private String codigo;
    private int numeroPreguntas;
    private int numeroEncuestas;
    private int numeroOpciones;
    private Map session;

    private String accion;
    private String mensaje;
    private String tipoMensaje;

    private int totalAplicadas;
    private int idAplica;

    String opcion1;
    float valor1;
    String opcion2;
    float valor2;
    String opcion3;
    float valor3;
    String opcion4;
    float valor4;
    String opcion5;
    float valor5;

    int opcion;

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

    public float getValor1() {
        return valor1;
    }

    public void setValor1(float valor1) {
        this.valor1 = valor1;
    }

    public float getValor2() {
        return valor2;
    }

    public void setValor2(float valor2) {
        this.valor2 = valor2;
    }

    public float getValor3() {
        return valor3;
    }

    public void setValor3(float valor3) {
        this.valor3 = valor3;
    }

    public float getValor4() {
        return valor4;
    }

    public void setValor4(float valor4) {
        this.valor4 = valor4;
    }

    public float getValor5() {
        return valor5;
    }

    public void setValor5(float valor5) {
        this.valor5 = valor5;
    }

    public int getTotalAplicadas() {
        return totalAplicadas;
    }

    public void setTotalAplicadas(int totalAplicadas) {
        this.totalAplicadas = totalAplicadas;
    }

    public List<BeanAplica> getMisEncuestasUsuario() {
        return misEncuestasUsuario;
    }

    public void setMisEncuestasUsuario(List<BeanAplica> misEncuestasUsuario) {
        this.misEncuestasUsuario = misEncuestasUsuario;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public BeanAplica getUnaAplica() {
        return unaAplica;
    }

    public void setUnaAplica(BeanAplica unaAplica) {
        this.unaAplica = unaAplica;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }

    public int getIdAplica() {
        return idAplica;
    }

    public void setIdAplica(int idAplica) {
        this.idAplica = idAplica;
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
        session = ActionContext.getContext().getSession();
        int idUsuario = Integer.parseInt(session.get("id").toString());
        beanU.setIdUsuario(idUsuario);
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
        session = ActionContext.getContext().getSession();
        int idUsuario = Integer.parseInt(session.get("id").toString());
        System.out.println("44444444444444444444444" + idUsuario);
        setMisEncuestas(daoC.cosultarEncuestas(idUsuario));
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
        setTotalAplicadas(daoC.cosultarNumeroAplicaciones(getCodigo()));
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

    public String generarGraficaPregunta() {
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        DaoCreacion daoC = new DaoCreacion();
        setMisOpciones(daoC.generarGraficaPregunta(getUnaPregunta().getIdPregunta()));
        setUnaPregunta(daoC.consultarPregunta(getUnaPregunta().getIdPregunta()));

        int tamanoLista = getMisOpciones().size();
        int acu = 0;
        for (int i = 0; i < getMisOpciones().size(); i++) {
            acu = acu + getMisOpciones().get(i).getTotal();
        }

        if (tamanoLista == 1) {
            setOpcion1(getMisOpciones().get(0).getOpcion());
            setValor1((getMisOpciones().get(0).getTotal() * 100) / acu);
        }
        if (tamanoLista == 2) {
            setOpcion1(getMisOpciones().get(0).getOpcion());
            setValor1((getMisOpciones().get(0).getTotal() * 100) / acu);
            setOpcion2(getMisOpciones().get(1).getOpcion());
            setValor2((getMisOpciones().get(1).getTotal() * 100) / acu);
        }
        if (tamanoLista == 3) {
            setOpcion1(getMisOpciones().get(0).getOpcion());
            setValor1((getMisOpciones().get(0).getTotal() * 100) / acu);
            setOpcion2(getMisOpciones().get(1).getOpcion());
            setValor2((getMisOpciones().get(1).getTotal() * 100) / acu);
            setOpcion3(getMisOpciones().get(2).getOpcion());
            setValor3((getMisOpciones().get(2).getTotal() * 100) / acu);
        }
        if (tamanoLista == 4) {
            setOpcion1(getMisOpciones().get(0).getOpcion());
            setValor1((getMisOpciones().get(0).getTotal() * 100) / acu);
            setOpcion2(getMisOpciones().get(1).getOpcion());
            setValor2((getMisOpciones().get(1).getTotal() * 100) / acu);
            setOpcion3(getMisOpciones().get(2).getOpcion());
            setValor3((getMisOpciones().get(2).getTotal() * 100) / acu);
            setOpcion4(getMisOpciones().get(3).getOpcion());
            setValor4((getMisOpciones().get(3).getTotal() * 100) / acu);
        }
        if (tamanoLista == 5) {
            setOpcion1(getMisOpciones().get(0).getOpcion());
            setValor1((getMisOpciones().get(0).getTotal() * 100) / acu);
            setOpcion2(getMisOpciones().get(1).getOpcion());
            setValor2((getMisOpciones().get(1).getTotal() * 100) / acu);
            setOpcion3(getMisOpciones().get(2).getOpcion());
            setValor3((getMisOpciones().get(2).getTotal() * 100) / acu);
            setOpcion4(getMisOpciones().get(3).getOpcion());
            setValor4((getMisOpciones().get(3).getTotal() * 100) / acu);
            setOpcion5(getMisOpciones().get(4).getOpcion());
            setValor5((getMisOpciones().get(4).getTotal() * 100) / acu);
        }

        return SUCCESS;
    }

    public String cargarPreguntasUsuario() {
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        DaoCreacion daoC = new DaoCreacion();
        session = ActionContext.getContext().getSession();
        int idUsuario = Integer.parseInt(session.get("id").toString());
        setMisEncuestasUsuario(daoC.cosultarEncuestasUsuario(idUsuario));
        System.out.println("" + getMisEncuestasUsuario());
        return SUCCESS;
    }

    public String dameUnaPregunta() {
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        DaoCreacion daoC = new DaoCreacion();
        session = ActionContext.getContext().getSession();
        int idUsuario = Integer.parseInt(session.get("id").toString());

        try {
            setUnaPregunta(daoC.dameUnaPregunta(getUnaEncuesta().getIdEncuesta(), getUnaAplica().getIdAplica()));
            if (getUnaPregunta() != null) {
                if (getUnaPregunta().getTipo().getIdTipo() == 3) {
                    setMisOpciones(daoC.cosultarOpciones(getUnaPregunta().getIdPregunta()));
                    setIdAplica(getUnaAplica().getIdAplica());
                    return SUCCESS;
                } else {
                    setIdAplica(getUnaAplica().getIdAplica());
                    setMisOpciones(daoC.cosultarOpciones(getUnaPregunta().getIdPregunta()));
                    return SUCCESS;
                }
            } else {
                return ERROR;
            }
        } catch (Exception e) {
            return ERROR;
        }
    }

    public String registrarRespuestaOpcion() {
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        DaoCreacion daoC = new DaoCreacion();
        if (daoC.registrarRespuestaOpcion(getUnaAplica().getIdAplica(), getUnaPregunta().getIdPregunta(), getOpcion())) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String registrarRespuestaAbierta() {
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        DaoCreacion daoC = new DaoCreacion();
        if (daoC.registrarRespuestaAbierta(getUnaPregunta().getPregunta(), getUnaAplica().getIdAplica(), getUnaPregunta().getIdPregunta())) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

    public String registrarAplica() {
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        DaoCreacion daoC = new DaoCreacion();
        session = ActionContext.getContext().getSession();
        int idUsuario = Integer.parseInt(session.get("id").toString());
        if (daoC.registrarAplica(getCodigo(), idUsuario)) {
            return SUCCESS;
        } else {
            return ERROR;
        }
    }

}
