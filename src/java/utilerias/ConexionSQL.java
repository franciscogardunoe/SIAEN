/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author redes1
 */
public class ConexionSQL {

    private static String nombreBase;
    private static String usuario;
    private static String contrasexa;
    private static String puerto;
    private static ResourceBundle datosConexion;

    public static Connection obtenerConexion() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.err.println("Error de clase no encontrada: " + e.getMessage());
        }
        if (datosConexion == null) {
            datosConexion = ResourceBundle.getBundle("datos_conexion");
            nombreBase = datosConexion.getString("nombre_base");
            usuario = datosConexion.getString("usuario");
            contrasexa = datosConexion.getString("contrasexa");
            puerto = datosConexion.getString("puerto");
        }
        String urlConexion = "jdbc:sqlserver://localhost:" + puerto + ";"
                + "database=" + nombreBase + ";"
                + "user=" + usuario + ";"
                + "password=" + contrasexa + ";";
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(urlConexion);
        } catch (SQLException esql) {
            System.err.println("Error al conectarse: \n" + esql.getMessage());
        }
        return conexion;
    }
}
