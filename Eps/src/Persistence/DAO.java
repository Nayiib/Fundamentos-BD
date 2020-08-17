package Persistence;

import Models.Afiliado;
import Models.Medico;
import Models.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import ignore.Keys;
import java.sql.PreparedStatement;

public class DAO {

    protected Connection conexion;
    private static DAO controlador;

    protected DAO() {
        try {
            establecerConexion();
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    public static DAO getReference() {
        if (controlador == null) {
            controlador = new DAO();
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

    public boolean getUser(String tabla, String tipo, long id) throws SQLException {
        String consulta = "SELECT * FROM " + tabla + " WHERE k_tipodocumento = ? AND k_numerodocumento = ?;";
        PreparedStatement st = conexion.prepareStatement(consulta);
        st.setString(1, tipo);
        st.setLong(2, id);
        ResultSet user = st.executeQuery();
        while (user.next()) {

            if (tabla.equals("afiliado_beneficiario")) {
                if (user.getLong(2) == id && user.getString(1).equals(tipo) && user.getString(4).equals("Activo")) {
                    return true;
                }
            } else {
                if (user.getLong(2) == id && user.getString(1).equals(tipo)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void registrarUsuario(Usuario usuario) throws SQLException {
        String query = "INSERT INTO usuario VALUES(?,?,?,?,?,?,?,?,?);";
        PreparedStatement st = conexion.prepareStatement(query);
        st.setString(1, usuario.getTipoDocumento());
        st.setLong(2, usuario.getNumeroDocumento());
        st.setString(3, usuario.getNombreUsuario());
        st.setString(4, usuario.getSexo());
        st.setDate(5, usuario.getFechaNacimiento());
        st.setLong(6, usuario.getTelefonoContacto());
        st.setLong(7, usuario.getTelefonoCelular());
        st.setString(8, usuario.getCorreo());
        st.setInt(9, usuario.getEpsKey());
        st.execute();
    }
    
    public void registrarMedico(Medico medico) throws SQLException {
        String query = "INSERT INTO medico VALUES(?,?,?);";
        PreparedStatement st = conexion.prepareStatement(query);
        st.setString(1, medico.getTipoDocumento());
        st.setLong(2, medico.getNumeroDocumento());
        st.setString(3, medico.getRegistroMedico());
        st.execute();
    }

    public void registrarAB(Afiliado ABReferencia) throws SQLException {
        String comandoSQL = ("INSERT INTO afiliado_beneficiario  VALUES (?, ?, ?, ?, ?, ?, ?)");
        PreparedStatement ps = conexion.prepareStatement(comandoSQL);
        ps.setString(1, ABReferencia.getTipoDocumento());
        ps.setLong(2, ABReferencia.getNumeroDocumento());
        ps.setString(3, ABReferencia.getTipoAfiliacion());
        ps.setString(4, ABReferencia.getEstado());
        if (ABReferencia.getCategoria() == "A") {
            ps.setInt(5, 1);
        } else if (ABReferencia.getCategoria() == "B") {
            ps.setInt(5, 2);
        } else if (ABReferencia.getCategoria() == "C") {
            ps.setInt(5, 3);
        }
        ps.setString(6, ABReferencia.getTipoDocumentoAfiliado());
        if (ABReferencia.getNumeroDocumentoAfiliado() == 0) {
            ps.setNull(7, java.sql.Types.INTEGER);
        } else {
            ps.setLong(7, ABReferencia.getNumeroDocumentoAfiliado());
        }
        ps.execute();
    }
}
