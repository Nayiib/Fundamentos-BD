package controllers;

import java.sql.PreparedStatement;
import java.sql.SQLException;


public class AfiliadoController extends Controller {
    
    private AfiliadoController(){
       super(); 
       
    }
    
    private static AfiliadoController afiliado;
    
    public static AfiliadoController getReference(){
        if(afiliado == null){
            afiliado = new AfiliadoController();
        }
        return afiliado;
    }
    
    public void crear(long kEmpresa,String nombre,String direccion,long telefono){
        try {
            String consulta = "INSERT INTO empresa VALUES(?,?,?,?);";
            PreparedStatement st = conexion.prepareStatement(consulta);
            st.setLong(1, kEmpresa);
            st.setString(2, nombre);
            st.setString(3, direccion);
            st.setLong(4, telefono);
            
            st.execute();
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }
    
    
    
    
    
}
