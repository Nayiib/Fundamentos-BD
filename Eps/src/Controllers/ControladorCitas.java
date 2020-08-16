package Controllers;

import java.util.ArrayList;
import Models.DatosSolicCita;

public class ControladorCitas {
    
    ArrayList<DatosSolicCita> arregloCitas = new ArrayList<DatosSolicCita>();
    
    public ControladorCitas(){
        DatosSolicCita citaTemp = new DatosSolicCita("Yuliana", "hoyxd", "2:30", "Calle 48", "kjhdfkl", 201);
        DatosSolicCita citaTemp1 = new DatosSolicCita("Julian", "otrodia", "2:50", "Calle 48", "hsjkhskh", 221);
        arregloCitas.add(citaTemp);
        arregloCitas.add(citaTemp1);
        
    }
    
    public DatosSolicCita obtenerCita(int numCita){
        return arregloCitas.get(numCita);
    }
    
    public int getTamañoArreglo(){
        return arregloCitas.size();
    }
}
