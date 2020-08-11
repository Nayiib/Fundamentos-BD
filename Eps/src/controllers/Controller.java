package controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import ignore.Keys;
import java.sql.PreparedStatement;


public class Controller {

    protected Connection conexion;
    private static Controller controlador;

    protected Controller() {
        try {
            establecerConexion();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static Controller getReference() {
        if (controlador == null) {
            controlador = new Controller();
        }
        return controlador;
    }

    public void establecerConexion() throws SQLException {
        try {
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/eps", Keys.user, Keys.password);
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
    
    public long getUser(String tabla, String tipo, long id) {
        ResultSet user = null;
        long comparacion = 0;

        try {
            String consulta = "SELECT * FROM " + tabla + " WHERE k_tipodocumento = ? AND k_numerodocumento = ?;";
            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setString(1, tipo);
            st.setLong(2, id);

            user = st.executeQuery();
            while (user.next()) {
                comparacion = user.getLong(2);
                System.out.println(user.getStatement().toString());
                System.out.println(comparacion);
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return comparacion;
    }


}
