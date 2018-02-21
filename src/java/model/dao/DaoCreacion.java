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
import java.util.ArrayList;
import java.util.List;
import model.bean.BeanEncuesta;
import model.bean.BeanUsuario;
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

    public List<BeanEncuesta> cosultarEncuestas(int idUsuario) {
        List<BeanEncuesta> lista = new ArrayList<>();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_consultarEncuestas ?");
            pstm.setInt(1, idUsuario);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanEncuesta unaEncuesta = new BeanEncuesta();
                unaEncuesta.setIdEncuesta(rs.getInt("idEncuesta"));
                unaEncuesta.setNombre(rs.getString("nombre"));
                unaEncuesta.setDescripcion(rs.getString("descripcion"));
                unaEncuesta.setCodigo(rs.getString("codigo"));
                unaEncuesta.setFechaCreacion(rs.getString("fechaCreacion"));
                BeanUsuario unUsuario = new BeanUsuario();
                unUsuario.setIdUsuario(rs.getInt("idUsuario"));
                unaEncuesta.setUsuario(unUsuario);
                lista.add(unaEncuesta);
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
}
