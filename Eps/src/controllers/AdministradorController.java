package controllers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AdministradorController extends Controller {
    
    private static AdministradorController administrador;
    
    private AdministradorController(){
        super();
    }
    
    public static AdministradorController getReference(){
        if(administrador == null){
            administrador = new AdministradorController();
        }
        
        return administrador;
    }
    
    public ResultSet getAfiliado(String id){
          ResultSet user = null;
        
        try {
            String query = "SELECT * FROM Afiliado_Beneficiario WHERE IdCliente = ?;";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, id);
            user = ps.executeQuery();
            
            System.out.println(user);
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return user;
    }
    
    public ResultSet getMedico(String id){
          ResultSet user = null;
        
        try {
            String query = "SELECT * FROM Medico WHERE IdCliente = ?;";
            PreparedStatement ps = conexion.prepareStatement(query);
            ps.setString(1, id);
            user = ps.executeQuery();
            
            System.out.println(user);
            
            
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return user;
    }
    
    
    
}
