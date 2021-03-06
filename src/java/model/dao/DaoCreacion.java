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
import model.bean.BeanAplica;
import model.bean.BeanEncuesta;
import model.bean.BeanPregunta;
import model.bean.BeanTipo;
import model.bean.BeanUsuario;
import model.bean.BeanOpcion;
import utilerias.ConexionSQL;

/**
 *
 * @author franc
 */
public class DaoCreacion {

    Connection conexion;
    PreparedStatement pstm;
    ResultSet rs;
    CallableStatement cs;

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

    public BeanEncuesta consultarEncuesta(String codigo) {
        BeanEncuesta unaEncuesta = new BeanEncuesta();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("pa_consultarEncuesta ?");
            pstm.setString(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                unaEncuesta.setIdEncuesta(rs.getInt("idEncuesta"));
                unaEncuesta.setNombre(rs.getString("nombre"));
                unaEncuesta.setDescripcion(rs.getString("descripcion"));
                unaEncuesta.setCodigo(rs.getString("codigo"));
                unaEncuesta.setFechaCreacion(rs.getString("fechaCreacion"));
                unaEncuesta.setEstado(rs.getInt("estado"));
                BeanUsuario unUsuario = new BeanUsuario();
                unUsuario.setIdUsuario(rs.getInt("idUsuarioCreo"));
                unaEncuesta.setUsuario(unUsuario);
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
        return unaEncuesta;
    }

    public List<BeanPregunta> cosultarPreguntas(String codigo) {
        List<BeanPregunta> lista = new ArrayList<>();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_consultarPreguntas ?");
            pstm.setString(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanPregunta unaPregunta = new BeanPregunta();
                unaPregunta.setIdPregunta(rs.getInt("idPregunta"));
                unaPregunta.setPregunta(rs.getString("pregunta"));
                unaPregunta.setObligatoria(rs.getInt("obligatoria"));
                unaPregunta.setEstado(rs.getInt("estado"));
                BeanTipo unTipo = new BeanTipo();
                unTipo.setIdTipo(rs.getInt("idTipo"));
                unTipo.setTipo(rs.getString("tipo"));
                unaPregunta.setTipo(unTipo);
                lista.add(unaPregunta);
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

    public boolean modificarEncuesta(BeanEncuesta unaEncuesta) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_modificarEncuesta ?,?,?");
            pstm.setInt(1, unaEncuesta.getIdEncuesta());
            pstm.setString(2, unaEncuesta.getNombre());
            pstm.setString(3, unaEncuesta.getDescripcion());
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

    public boolean registrarPreguntaAbierta(BeanPregunta unaPregunta) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_registrarPreguntaAbierta ?,?,?,?");
            pstm.setString(1, unaPregunta.getPregunta());
            pstm.setInt(2, unaPregunta.getObligatoria());
            pstm.setInt(3, unaPregunta.getTipo().getIdTipo());
            pstm.setInt(4, unaPregunta.getEncuesta().getIdEncuesta());
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

    public boolean eliminarEncuesta(int idEncuesta) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_eliminarEncuesta ?");
            pstm.setInt(1, idEncuesta);
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

    public int registrarPreguntaOpcion(BeanPregunta unaPregunta) {
        boolean resultado = false;
        int idPregunta = 0;
        try {
            conexion = ConexionSQL.obtenerConexion();
            cs = conexion.prepareCall("{ CALL pa_registrarPreguntaOpcion (?,?,?,?,?) }");
            cs.setString(1, unaPregunta.getPregunta());
            cs.setInt(2, unaPregunta.getObligatoria());
            cs.setInt(3, unaPregunta.getTipo().getIdTipo());
            cs.setInt(4, unaPregunta.getEncuesta().getIdEncuesta());
            cs.registerOutParameter(5, java.sql.Types.INTEGER);
            resultado = cs.execute();
            idPregunta = cs.getInt("idPregunta");

        } catch (SQLException ex) {
            System.err.println("Excepción SQL: " + ex.getMessage());
            return idPregunta;
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
        return idPregunta;
    }

    public boolean registrarOpcion(BeanOpcion opcion) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_registrarOpcion ?,?,?");
            pstm.setString(1, opcion.getOpcion());
            pstm.setInt(2, opcion.getEsAbierta());
            pstm.setInt(3, opcion.getPregunta().getIdPregunta());
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

    public boolean eliminarPregunta(int idPregunta) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_eliminarPregunta ?");
            pstm.setInt(1, idPregunta);
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

    public List<BeanOpcion> cosultarOpciones(int idPregunta) {
        List<BeanOpcion> lista = new ArrayList<>();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_consultarOpcionesPregunta ?");
            pstm.setInt(1, idPregunta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanOpcion unaOpcion = new BeanOpcion();
                unaOpcion.setIdOpcion(rs.getInt("idOpcion"));
                unaOpcion.setOpcion(rs.getString("opcion"));
                BeanPregunta unaPregunta = new BeanPregunta();
                unaPregunta.setIdPregunta(rs.getInt("idPregunta"));
                unaPregunta.setPregunta(rs.getString("pregunta"));
                unaPregunta.setObligatoria(rs.getInt("obligatoria"));
                BeanTipo unTipo = new BeanTipo();
                unTipo.setIdTipo(rs.getInt("idTipo"));
                unTipo.setTipo(rs.getString("tipo"));
                unaPregunta.setTipo(unTipo);
                unaOpcion.setPregunta(unaPregunta);
                lista.add(unaOpcion);
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

    public BeanPregunta consultarPregunta(int idPregunta) {
        BeanPregunta unaPregunta = new BeanPregunta();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("pa_consultarPregunta ?");
            pstm.setInt(1, idPregunta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                unaPregunta.setIdPregunta(rs.getInt("idPregunta"));
                unaPregunta.setPregunta(rs.getString("pregunta"));
                unaPregunta.setObligatoria(rs.getInt("obligatoria"));
                BeanTipo unTipo = new BeanTipo();
                unTipo.setTipo(rs.getString("tipo"));
                unaPregunta.setTipo(unTipo);
                BeanEncuesta unaEncuesta = new BeanEncuesta();
                unaEncuesta.setNombre(rs.getString("nombre"));
                unaEncuesta.setDescripcion(rs.getString("descripcion"));
                unaPregunta.setEncuesta(unaEncuesta);
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
        return unaPregunta;
    }

    public List<BeanOpcion> generarGraficaPregunta(int idPregunta) {
        List<BeanOpcion> lista = new ArrayList<>();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_generarGrafica ?");
            pstm.setInt(1, idPregunta);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanOpcion unaOpcion = new BeanOpcion();
                unaOpcion.setIdOpcion(rs.getInt("idOpcion"));
                unaOpcion.setOpcion(rs.getString("opcion"));
                unaOpcion.setTotal(rs.getInt("total"));
                BeanPregunta unaPregunta = new BeanPregunta();
                unaPregunta.setIdPregunta(rs.getInt("idPregunta"));
                unaPregunta.setPregunta(rs.getString("pregunta"));
                unaOpcion.setPregunta(unaPregunta);
                lista.add(unaOpcion);
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

    public int cosultarNumeroAplicaciones(String codigo) {
        int res = 0;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_numeroAplicaciones ?");
            pstm.setString(1, codigo);
            rs = pstm.executeQuery();
            while (rs.next()) {
                res = rs.getInt("numeroAplicaciones");
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
        return res;
    }

    public List<BeanAplica> cosultarEncuestasUsuario(int idUsuario) {
        List<BeanAplica> lista = new ArrayList<>();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_consultarEncuestasAplicadas ?");
            pstm.setInt(1, idUsuario);
            rs = pstm.executeQuery();
            while (rs.next()) {
                BeanAplica unaAplica = new BeanAplica();
                unaAplica.setIdAplica(rs.getInt("idAplica"));
                unaAplica.setFechaAplicacion(rs.getString("fechaAplicacion"));
                BeanEncuesta unaEncuesta = new BeanEncuesta();
                unaEncuesta.setIdEncuesta(rs.getInt("idEncuesta"));
                unaEncuesta.setNombre(rs.getString("nombre"));
                unaEncuesta.setCodigo(rs.getString("codigo"));
                BeanUsuario unUsuario = new BeanUsuario();
                unUsuario.setIdUsuario(rs.getInt("idUsuario"));
                unaEncuesta.setUsuario(unUsuario);
                unaAplica.setUsuario(unUsuario);
                unaAplica.setEncuesta(unaEncuesta);
                lista.add(unaAplica);
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

    public BeanPregunta dameUnaPregunta(int idEncuesta, int idAplica) {
        BeanPregunta unaPregunta = new BeanPregunta();
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("pa_dameUnaPregunta ?,?");
            pstm.setInt(1, idEncuesta);
            pstm.setInt(2, idAplica);
            rs = pstm.executeQuery();
            while (rs.next()) {
                unaPregunta.setIdPregunta(rs.getInt("idPregunta"));
                unaPregunta.setPregunta(rs.getString("pregunta"));
                unaPregunta.setObligatoria(rs.getInt("obligatoria"));
                BeanTipo unTipo = new BeanTipo();
                unTipo.setIdTipo(rs.getInt("idTipo"));
                unaPregunta.setTipo(unTipo);
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
        return unaPregunta;
    }

    public boolean registrarRespuestaOpcion(int idAplica, int idPregunta, int idOpcion) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_registrarRespuestaOpcion ?,?,?");
            pstm.setInt(1, idAplica);
            pstm.setInt(2, idPregunta);
            pstm.setInt(3, idOpcion);
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

    public boolean registrarRespuestaAbierta(String respuestaAbierta, int idAplica, int idPregunta) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_registrarRespuestaAbierta ?,?,?");
            pstm.setString(1, respuestaAbierta);
            pstm.setInt(2, idAplica);
            pstm.setInt(3, idPregunta);
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

    public boolean registrarAplica(String codigo, int idUsuario) {
        boolean resultado = false;
        try {
            conexion = ConexionSQL.obtenerConexion();
            pstm = conexion.prepareStatement("EXECUTE pa_registrarAplica ?,?");
            pstm.setString(1, codigo);
            pstm.setInt(2, idUsuario);
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
