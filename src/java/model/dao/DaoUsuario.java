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
import model.bean.BeanUsuario;
import utilerias.ConexionSQL;

/**
 *
 * @author Antonio Calderon
 */
public class DaoUsuario {

    Connection conexion;
    PreparedStatement pstm;
    ResultSet rs;
    CallableStatement cs;

    public boolean registrarUsuario(BeanUsuario unUsuario) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_registrarUsuario ?,?,?,?,?");
            pstm.setString(1, unUsuario.getNombre());
            pstm.setString(2, unUsuario.getApellido1());
            pstm.setString(3, unUsuario.getApellido2());
            pstm.setString(4, unUsuario.getCorreo());
            pstm.setString(5, unUsuario.getContrasena());

            resultado = pstm.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.println("Excepción SQL: " + ex.getMessage());
            return true;
        } catch (Exception e) {
            System.err.println("Excepción: " + e.getMessage());
        } finally {
            try {
                if (conexion != null) {
                    conexion.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
            } catch (Exception exc) {
                System.err.println("Excepción: " + exc.getMessage());
            }
        }
        return resultado;
    }

}
