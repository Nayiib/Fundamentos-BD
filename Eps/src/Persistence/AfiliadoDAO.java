package Persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public void consultarCitas(long iDUsuario, Date fecha) throws SQLException{
        String comandoSQL = "SELECT k_cita,f_cita FROM cita,afiliado_beneficiario " +
                "WHERE cita.k_numerodocumentoab=afiliado_beneficiario.k_numerodocumento " +
                "AND cita.f_cita='2020-10-21' " +
                "AND afiliado_beneficiario.k_numerodocumento=123456789;";
        PreparedStatement ps = conexion.prepareStatement(comandoSQL);
        ResultSet rs = ps.executeQuery();
        ArrayList<String> nombresCines = new ArrayList<String>();
        while (rs.next()) {
            nombresCines.add(rs.getString("nombre"));
        }
//        return nombresCines;
        
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
