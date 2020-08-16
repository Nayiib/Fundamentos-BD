package Persistence;

import Models.Afiliado;
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

    public boolean getUser(String tabla, String tipo, long id) {
        ResultSet user = null;

        try {
            System.out.println(tabla + "    " + tipo + "    " + id);
            String consulta = "SELECT * FROM " + tabla + " WHERE k_tipodocumento = ? AND k_numerodocumento = ?;";
            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setString(1, tipo);
            st.setLong(2, id);

            user = st.executeQuery();
            while (user.next()) {

                if (tabla.equals("afiliado_beneficiario")) {
                    System.out.println("ENTRO 2");

                    if (user.getLong(2) == id && user.getString(1).equals(tipo) && user.getString(4).equals("Activo")) {
                        return true;
                    }
                } else {
                    System.out.println("ENTRO 3");

                    if (user.getLong(2) == id && user.getString(1).equals(tipo)) {
                        return true;
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    public void registrarUsuario() throws SQLException {
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
