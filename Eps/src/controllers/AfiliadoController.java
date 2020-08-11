package controllers;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AfiliadoController extends Controller {

    private static AfiliadoController afiliado;

    private AfiliadoController() {
        super();
    }

    public static AfiliadoController getReference() {
        if (afiliado == null) {
            afiliado = new AfiliadoController();
        }
        return afiliado;
    }

    public void cancelarCita(long iDUsuario, long iDCita, Date fechaCita) {

        try {
            String consulta = "DELETE FROM cita WHERE k_cita = ? AND f_cita = ? AND k_numeroDocumento = ?;";
            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setLong(1, iDCita);
            st.setDate(2, fechaCita);
            st.setLong(3, iDUsuario);

            st.execute();

        } catch (SQLException ex) {
            System.out.println("Falló al intentar cancelar la cita: " + ex.getMessage());
        }

    }

}
