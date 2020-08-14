package Persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicoDAO extends DAO {
    
    private static MedicoDAO medicoController;
    
    private MedicoDAO(){
        super();
    }
    
    public void agregarCita(){
    }
    
    public static MedicoDAO getReference(){
        if(medicoController == null){
            medicoController = new MedicoDAO();
        }
        return medicoController;
    }
    
    public void registrarDiagnostico(long idRegistro,String diagnostico,String preinscripcion,long idCita) {
        try {

            String query = "INSERT INTO registro VALUES (?,?,?,?);";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setLong(1, idCita);
            ps.setString(2, diagnostico);
            ps.setString(3, preinscripcion);
            ps.setLong(4, idCita);
            ps.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    
    
}
