package Controllers;

import Persistence.DAO;
import View.IniciarSesion;

import java.sql.SQLException;


public class ControladorIniciarSesion {

    private DAO dao;

    public void iniciarApp(){
        IniciarSesion Ventana = new IniciarSesion(this);
        Ventana.setVisible(true);
        Ventana.setLocationRelativeTo(null);
    }

    public void cerrarSesion(){
        dao.cerrarConexion();
    }

    public boolean obtenerUsuario (String tabla, String tipo, long id){
        try {
            dao = DAO.getReference();
            dao.establecerConexion();
            return dao.getUser(tabla, tipo, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            dao.cerrarConexion();
        }
        return false;
    }
}


