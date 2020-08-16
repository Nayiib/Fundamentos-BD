package Controllers;

import java.util.ArrayList;
import Models.DatosConsulCita;

public class ControladorConsulCitas {
    private ArrayList<DatosConsulCita> arregloCitas2 = new ArrayList<DatosConsulCita>();
    
    public ControladorConsulCitas(){
        DatosConsulCita citaTemp = new DatosConsulCita("Odontologia","Lectura Examen","Yuliana", "2:30", "Calle 48", "kjhdfkl", 201);
        DatosConsulCita citaTemp1 = new DatosConsulCita("Medicina General","Control","Julian", "2:50", "Calle 48", "hsjkhskh", 221);
        arregloCitas2.add(citaTemp);
        arregloCitas2.add(citaTemp1);
    }
    
    public DatosConsulCita obtenerCita(int numCita){
        return arregloCitas2.get(numCita);
    }
    
    public int getTamañoArreglo(){
        return arregloCitas2.size();
    }
}
