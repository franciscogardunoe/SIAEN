/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.controller;

import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import model.bean.BeanUsuario;
import model.dao.DaoSesion;
import org.apache.struts2.interceptor.SessionAware;


/**
 *
 * @author franc
 */
public class ControllerSesion extends ActionSupport implements SessionAware {
    
    private BeanUsuario usuario;
    //Mensaje de bienvenida para los usuarios registrados
    private String mensaje = "";
    //Datos de acceso a la cuenta
    private String correo;
    private String password;
    //Mensaje de error
    private String message;
    //Mapa de la sesión
    private Map session;

    public String loginUsuario() {
        if (!session.containsKey("logged")) {
            try {
                //Datos del usuario
                setUsuario(new DaoSesion().buscarUsuario(getCorreo(), getPassword()));
                session = ActionContext.getContext().getSession();
                session.put("logged", "yes");
                session.put("id", getUsuario().getIdUsuario());
                session.put("name", getUsuario().getNombre());
                session.put("apellido1", getUsuario().getApellido1());
                session.put("apellido2", getUsuario().getApellido2());
                session.put("mail", getUsuario().getCorreo());
                session.put("password", getUsuario().getContrasena());
                return SUCCESS;
            } catch (NullPointerException e) {
                mensaje = "Correo y/o contraseña incorrectos.";                
                return ERROR;
            }
        } else {
            try {
                session = ActionContext.getContext().getSession();
                String mail = session.get("mail").toString();
                String pass = session.get("password").toString();
                int id = Integer.parseInt(session.get("id").toString());
                setUsuario(new DaoSesion().buscarUsuario(mail, pass));
                return SUCCESS;
            } catch (Exception e) {
                mensaje = "Correo y/o contraseña incorrectos.";                
                return ERROR;
            }
        }

    }
    
        public String cerrarSesion() {
        session = ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }
        
    
    /*
    GETTERS AND SETTERS
     */

    public BeanUsuario getUsuario() {
        return usuario;
    }

    public void setUsuario(BeanUsuario usuario) {
        this.usuario = usuario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
    
    
    
    
    
}
