package Persistence;

import Models.EspecialidadMedicoConsultorio;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdministradorDAO extends DAO {

    private static AdministradorDAO administrador;

    private AdministradorDAO() {
        super();
    }

    public static AdministradorDAO getReference() {
        if (administrador == null) {
            administrador = new AdministradorDAO();
        }
        return administrador;
    }
    
    public int getIDSede(String nombreSede) throws SQLException{
        
        int idSede = 0;
        String consulta = "SELECT k_sede FROM sede WHERE n_nombreSede = ? ";
        PreparedStatement ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombreSede);
        ResultSet result = ps.executeQuery();
        
        while(result.next()){
            idSede = result.getInt(1);
        }
        
        return idSede;
        
    }
    
    public int getIDEspecialidad(String nombreEspecialidad) throws SQLException{
        
        int idEspecialidad = 0;
        String consulta = "SELECT k_especialidad FROM especialidad WHERE especialidad.n_nombreespecialidad = ? ";
        PreparedStatement ps = conexion.prepareStatement(consulta);
        ps.setString(1, nombreEspecialidad);
        ResultSet result = ps.executeQuery();
        
        while(result.next()){
            idEspecialidad = result.getInt(1);
        }
        
        return idEspecialidad;
        
    }
    
    private void addEspecialidadMedicoConsultorio(EspecialidadMedicoConsultorio element) throws SQLException{
        
        String consulta = "INSERT INTO Especialidad_Medico_Consultorio VALUES(?,?,?,?,?,?)";
        PreparedStatement ps = conexion.prepareStatement(consulta);
        ps.setInt(1, element.getIdEspecialidad());
        ps.setString(2,element.getTipoDocumento());
        ps.setLong(3,element.getNumeroDocumento());
        ps.setLong(4,element.getNumeroConsultorio());
        ps.setInt(5,element.getIdSede());
        ps.setString(6, element.getHorario());
        
        ps.execute();
        
    }
    
    public void agregarEspecialidadesMedico(ArrayList<EspecialidadMedicoConsultorio> list) throws SQLException{
        
        for(int i = 0; i < list.size(); i++){
            addEspecialidadMedicoConsultorio(list.get(i));
        }
        
    }

}
