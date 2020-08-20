package Controllers;

import Persistence.DAO;
import View.IniciarSesion;

import java.sql.SQLException;


public class ControladorIniciarSesion {

    private DAO dao;

    public ControladorIniciarSesion(){
        dao = DAO.getReference();
    }

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
            return dao.getUser(tabla, tipo, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }
}


