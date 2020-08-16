package Persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
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

    public ArrayList consultarCitas(long iDUsuario, Date fecha) throws SQLException {
        String comandoSQL = "SELECT k_cita,n_nombretipocita FROM cita,afiliado_beneficiario,tipo_cita "
                + "WHERE cita.k_numerodocumentoab=afiliado_beneficiario.k_numerodocumento "
                + "AND cita.k_tipocita=tipo_cita.k_tipocita "
                + "AND cita.f_cita=? "
                + "AND afiliado_beneficiario.k_numerodocumento=?;";
        PreparedStatement ps = conexion.prepareStatement(comandoSQL);
        ps.setDate(1, fecha);
        ps.setLong(2, iDUsuario);
        ResultSet rs = ps.executeQuery();
        ArrayList<ArrayList> arregloTocho = new ArrayList<ArrayList>();
        ArrayList<Integer> arregloIds = new ArrayList<Integer>();
        ArrayList<String> arregloTipos = new ArrayList<String>();
        while (rs.next()) {
            arregloIds.add(rs.getInt("k_cita"));
            arregloTipos.add(rs.getString("n_nombretipocita"));
        }
        arregloTocho.add(arregloIds);
        arregloTocho.add(arregloTipos);
        return arregloTocho;
    }

    public Time consultarHora(long iDUsuario, Date fecha, int iDCita) throws SQLException {
        Time retorno = null;
        String comandoSQL = "SELECT h_inicial FROM cita,afiliado_beneficiario "
                + "WHERE cita.k_numerodocumentoab=afiliado_beneficiario.k_numerodocumento "
                + "AND f_cita = ? "
                + "AND k_numerodocumento = ? "
                + "AND k_cita = ?";
        PreparedStatement ps = conexion.prepareStatement(comandoSQL);
        ps.setDate(1, fecha);
        ps.setLong(2, iDUsuario);
        ps.setInt(3, iDCita);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            retorno = rs.getTime("h_inicial");
        }
        return retorno;
    }

    public void eliminarCita(long iDUsuario, long iDCita) throws SQLException {
        String consulta = "DELETE FROM cita WHERE k_cita = ? AND k_numeroDocumentoab = ?;";
        PreparedStatement st = conexion.prepareStatement(consulta);
        st.setLong(1, iDCita);
        st.setLong(2, iDUsuario);
        st.executeUpdate();
    }

    public void eliminarPago(long iDCita) throws SQLException {
        String consulta = "DELETE FROM pago WHERE k_cita= ?;";
        PreparedStatement st = conexion.prepareStatement(consulta);
        st.setLong(1, iDCita);
        st.executeUpdate();
    }

    public void eliminarRegistro(long iDCita) throws SQLException {
        String consulta = "DELETE FROM registro WHERE k_cita= ?;";
        PreparedStatement st = conexion.prepareStatement(consulta);
        st.setLong(1, iDCita);
        st.executeUpdate();
    }


}
