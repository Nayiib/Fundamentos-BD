package Models;

import java.sql.Date;


public class Medico extends Usuario {
    
    private String registroMedico;

    public Medico(String tipoDocumento, long numeroDocumento, String nombreUsuario, String sexo, Date fechaNacimiento, long telefonoContacto,long telefonoCelular,int epsKey,String registroMedico) {
        super(tipoDocumento, numeroDocumento, nombreUsuario, sexo, fechaNacimiento, telefonoContacto, epsKey);
        this.registroMedico = registroMedico;
    }
    
    public String getRegistroMedico(){
        return registroMedico;
    }
    
    
    
    
    
}
