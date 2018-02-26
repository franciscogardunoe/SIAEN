/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import model.bean.BeanUsuario;
import model.dao.DaoUsuario;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
/**
 *
 * @author Antonio Calderon
 */
public class ControllerUsuario {

    private BeanUsuario unUsuario;
    private String accion;
    private String mensaje;
    private String tipoMensaje;

    public String registrarUsuario() {

        DaoUsuario daoU = new DaoUsuario();
        BeanUsuario beanU = new BeanUsuario();
        setAccion("");
        setMensaje("");
        setTipoMensaje("");
        
        beanU.setNombre(getUnUsuario().getNombre());
        beanU.setApellido1(getUnUsuario().getApellido1());
        beanU.setApellido2(getUnUsuario().getApellido2());
        beanU.setCorreo(getUnUsuario().getCorreo());
        beanU.setContrasena(getUnUsuario().getContrasena());
        
        System.out.println(getUnUsuario().getApellido2());
        
        if (daoU.registrarUsuario(beanU)) {
            setAccion("Correcto");
            setMensaje("Tu usuario fue registrado exitosamente, ahora puedes iniciar sesión");
            setTipoMensaje("success");
            return SUCCESS;
        } else {
            setAccion("Error");
            setMensaje("Tu usuario no puedo ser registrado, intentalo de nnuevo");
            setTipoMensaje("error");
            return ERROR;
        }
    }

    /*Getter y setter */
    public BeanUsuario getUnUsuario() {
        return unUsuario;
    }

    public void setUnUsuario(BeanUsuario unUsuario) {
        this.unUsuario = unUsuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getTipoMensaje() {
        return tipoMensaje;
    }

    public void setTipoMensaje(String tipoMensaje) {
        this.tipoMensaje = tipoMensaje;
    }

    
}
