package Persistence;

import Models.DatosConsulCita;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import Controllers.ControladorConsulCitas;

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
    
    public ArrayList consultarCitas2(long iDUsuario, Date fecha) throws SQLException {
        String comandoSQL = "SELECT especialidad.n_nombreespecialidad, tipo_cita.n_nombretipocita, usuario.n_nombre, " +
"		h_inicial, sede.n_nombresede, sede.n_direccion, " +
"		especialidad_medico_consultorio.k_numeroconsultorio " +
"FROM cita, afiliado_beneficiario, tipo_cita, especialidad, medico, " +
"		especialidad_medico_consultorio, usuario, sede " +
"WHERE cita.k_numerodocumentoab = afiliado_beneficiario.k_numerodocumento " +
"AND cita.k_tipocita=tipo_cita.k_tipocita " +
"AND especialidad_medico_consultorio.k_especialidad = especialidad.k_especialidad " +
"AND especialidad_medico_consultorio.k_sede = sede.k_sede " +
"AND especialidad_medico_consultorio.k_numerodocumento = medico.k_numerodocumento " +
"AND usuario.k_numerodocumento = medico.k_numerodocumento " +
"AND cita.k_especialidad = especialidad.k_especialidad " +
"AND cita.k_numerodocumentomedico = medico.k_numerodocumento " +
"AND cita.f_cita=? " +
"AND afiliado_beneficiario.k_numerodocumento=?; ";
        PreparedStatement ps = conexion.prepareStatement(comandoSQL);
        ps.setDate(1, fecha);
        ps.setLong(2, iDUsuario);
        ResultSet rs = ps.executeQuery();
        
        ArrayList<DatosConsulCita> arregloCitas2 = new ArrayList<DatosConsulCita>();
        
        while (rs.next()) {
            DatosConsulCita citaTemp = new DatosConsulCita(rs.getString(1),rs.getString(2),rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getInt(7));
            arregloCitas2.add(citaTemp);
        }
        
        return arregloCitas2;
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
