/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.bean.BeanEncuesta;
import utilerias.ConexionSQL;

/**
 *
 * @author franc
 */
public class DaoCreacion {

    Connection conexion;
    PreparedStatement pstm;
    ResultSet rs;

    public boolean registrarEncuesta(BeanEncuesta unaEncuesta) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_registrarEncuesta ?,?,?,?");
            pstm.setString(1, unaEncuesta.getNombre());
            pstm.setString(2, unaEncuesta.getDescripcion());
            pstm.setString(3, unaEncuesta.getCodigo());
            pstm.setInt(4, unaEncuesta.getUsuario().getIdUsuario());
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
