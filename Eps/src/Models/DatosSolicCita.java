package Models;


public class DatosSolicCita {
    
    private String medicoTratante, fecha, hora, sede, direccion;
    private int consultorio;

    public String getMedicoTratante() {
        return medicoTratante;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getSede() {
        return sede;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getConsultorio() {
        return consultorio;
    }
    
    public DatosSolicCita(String medicoTratante, String fecha, String hora, String sede, String direccion, int consultorio){
        this.medicoTratante = medicoTratante;
        this.fecha = fecha;
        this.hora = hora;
        this.sede = sede;
        this.direccion = direccion;
        this.consultorio = consultorio;
    }
}
