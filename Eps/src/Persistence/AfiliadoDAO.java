package Persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AfiliadoDAO extends DAO {

    private static AfiliadoDAO afiliado;

    private AfiliadoDAO() {
        super();
    }

    public static AfiliadoDAO getReference() {
        if (afiliado == null) {
            afiliado = new AfiliadoDAO();
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
