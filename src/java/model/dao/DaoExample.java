/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author franc
 */
public class DaoExample {

    Connection conexion;
    PreparedStatement pstm;
    ResultSet rs;
    /*
    public beanCliente consultaCliente(int idUsuario) {
        beanCliente unCliente = new beanCliente();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("pa_mostrarCliente ?");
            pstm.setInt(1, idUsuario);
            rs = pstm.executeQuery();
            while (rs.next()) {
                unCliente.setIdCliente(rs.getInt("idCliente"));
                unCliente.setNombre(rs.getString("nombre"));
                unCliente.setApellidos(rs.getString("apellidos"));
                unCliente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                unCliente.setDireccion(rs.getString("direccion"));
                unCliente.setTelefono(rs.getString("telefono"));
                beanUsuario unUsuario = new beanUsuario();
                unUsuario.setCorreoElectronico(rs.getString("correoElectronico"));
                unCliente.setUsuario(unUsuario);
                unCliente.setNumeroCuentas(rs.getInt("numeroCuentas"));
                unCliente.setSaldoTotal(rs.getDouble("totalDinero"));
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
        return unCliente;
    }

    public boolean registrarCliente(beanCliente unCliente) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_registrarCliente ?,?,?,?,?,?,?,?,?");
            pstm.setString(1, unCliente.getUsuario().getCorreoElectronico());
            pstm.setString(2, unCliente.getUsuario().getContrasena());
            pstm.setString(3, unCliente.getNombre());
            pstm.setString(4, unCliente.getApellidos());
            pstm.setString(5, unCliente.getFechaNacimiento());
            pstm.setString(6, unCliente.getDireccion());
            pstm.setString(7, unCliente.getTelefono());
            pstm.setDouble(8, unCliente.getCuenta().getSaldo());
            pstm.setInt(9, unCliente.getTipo().getIdTipoCuenta());
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

    public List<beanCliente> buscarCliente(String criterio) {
        List<beanCliente> lista = new ArrayList<>();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("pa_buscarCliente ?");
            pstm.setString(1,criterio);
            rs = pstm.executeQuery();
            while (rs.next()) {
                beanCliente unCliente=new beanCliente();
                unCliente.setIdCliente(rs.getInt("idCliente"));
                unCliente.setNombre(rs.getString("nombre"));
                unCliente.setApellidos(rs.getString("apellidos"));
                unCliente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                beanUsuario unUsuario = new beanUsuario();
                unUsuario.setCorreoElectronico(rs.getString("correoElectronico"));
                unCliente.setUsuario(unUsuario);
                lista.add(unCliente);
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
    
    public beanCliente consultarClienteModificar(int idCliente) {
        beanCliente unCliente = new beanCliente();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("pa_mostrarClienteModificar ?");
            pstm.setInt(1, idCliente);
            rs = pstm.executeQuery();
            while (rs.next()) {
                unCliente.setIdCliente(rs.getInt("idCliente"));
                unCliente.setNombre(rs.getString("nombre"));
                unCliente.setApellidos(rs.getString("apellidos"));
                unCliente.setFechaNacimiento(rs.getString("fechaNacimiento"));
                unCliente.setDireccion(rs.getString("direccion"));
                unCliente.setTelefono(rs.getString("telefono"));
                beanUsuario unUsuario = new beanUsuario();
                unUsuario.setCorreoElectronico(rs.getString("correoElectronico"));
                unCliente.setUsuario(unUsuario);          
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
        return unCliente;
    }
    
     public boolean modificarCliente(beanCliente unCliente) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_modificarCliente ?,?,?,?,?,?,?");
            pstm.setString(1, unCliente.getUsuario().getCorreoElectronico());
            pstm.setString(2, unCliente.getNombre());
            pstm.setString(3, unCliente.getApellidos());
            pstm.setString(4, unCliente.getFechaNacimiento());
            pstm.setString(5, unCliente.getDireccion());
            pstm.setString(6, unCliente.getTelefono());
            pstm.setDouble(7, unCliente.getIdCliente());  
            resultado = pstm.executeUpdate() == 1;
        } catch (SQLException ex) {
            System.err.println("Excepción SQL: " + ex.getMessage());
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
     */
}
