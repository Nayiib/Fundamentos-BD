package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ignore.Keys;


public class Controller {
    protected Connection conexion;

    public Controller() {
        try {
            establecerConexion();
        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void establecerConexion() throws SQLException {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/algebra", Keys.user,Keys.password);
            System.out.println("Conexion a la base de datos exitosa " + conexion.getMetaData().getURL());
        } catch (SQLException exception) {
            System.out.println("Error en la base de datos ");
            System.out.println(exception.getMessage());
        } 
    }

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (SQLException ex) {
            System.out.println("Fallo: " + ex);
        }
    }
    
    
    
    
}
