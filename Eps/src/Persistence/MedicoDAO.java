package Persistence;


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
    
    
    
}
