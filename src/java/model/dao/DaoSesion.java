/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.bean.BeanUsuario;
import utilerias.ConexionSQL;

/**
 *
 * @author franc
 */
public class DaoSesion {
    Connection conexion;
    PreparedStatement pstm;
    CallableStatement call;
    ResultSet rs;
    
    public List<BeanUsuario> cosultarUsuarios() {
        List<BeanUsuario> lista = new ArrayList<>();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("pa_consultarUsuarios");
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanUsuario unUsuario=new BeanUsuario();
                unUsuario.setIdUsuario(rs.getInt("idUsuario"));
                unUsuario.setNombre(rs.getString("nombre"));
                unUsuario.setApellido1(rs.getString("apellido1"));
                unUsuario.setApellido2(rs.getString("apellido2"));
                unUsuario.setCorreo(rs.getString("correo"));
                unUsuario.setContrasena(rs.getString("contrasena"));
                unUsuario.setEstado(rs.getInt("estado"));
                unUsuario.setEsAdmin(rs.getInt("esAdmin"));
                lista.add(unUsuario);
            }
        } catch (SQLException esql) {
            System.out.println("Excepción SQL: " + esql.getMessage());
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception ex) {
                System.out.println("Excepción: " + ex.getMessage());
            }
        }
        return lista;
    } 
    
      public BeanUsuario buscarUsuario(String correo, String pass) {
        BeanUsuario usuario = new BeanUsuario();
          try {
            conexion = ConexionSQL.obtenerConexion();
            call = conexion.prepareCall("{call pa_iniciarSession(?,?)}");
            call.setString(1, correo);
            call.setString(2, pass);
            rs = call.executeQuery();
            while (rs.next()) {
                usuario.setIdUsuario(rs.getInt("idUsuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setApellido1(rs.getString("apellido1"));
                usuario.setApellido2(rs.getString("apellido2"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContrasena(rs.getString("contrasena"));
                usuario.setEstado(rs.getInt("estado"));
                usuario.setEsAdmin(rs.getInt("esAdmin"));
            }
        } catch (SQLException esql) {
            System.out.println("Excepción SQL: " + esql.getMessage());
        } catch (Exception e) {
            System.out.println("Excepción: " + e.getMessage());
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (call != null) {
                    call.close();
                }
            } catch (Exception ex) {
                System.out.println("Excepción: " + ex.getMessage());
            }
        }
        return usuario;
    }
    
}
