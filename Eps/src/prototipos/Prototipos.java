package prototipos;

/**
 *
 * @author katht
 */
import controllers.*;
public class Prototipos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*IniciarSesion Ventana = new IniciarSesion();
        Ventana.setVisible(true);
        Ventana.setLocationRelativeTo(null);*/
        
        AfiliadoController test = new AfiliadoController();
        
        test.crear(133, "Empresa1", "Donde sea otra vez", 1234);
        test.cerrarConexion();
    }
    
}
