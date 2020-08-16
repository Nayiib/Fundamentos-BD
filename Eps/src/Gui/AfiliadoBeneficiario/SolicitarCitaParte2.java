package Gui.AfiliadoBeneficiario;


import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controllers.ControladorCitas;

public class SolicitarCitaParte2 extends JFrame implements ActionListener {
    public JPanel panel;
    ControladorCitas controlador;
    JLabel MT = new JLabel("Médico tratante:");
    JLabel MMT = new JLabel();
    JLabel Fecha = new JLabel("Fecha:");
    JLabel MFecha = new JLabel();
    JLabel H = new JLabel("Hora:");
    JLabel MH = new JLabel();
    JLabel Sede = new JLabel("Sede:");
    JLabel MSede = new JLabel();
    JLabel Dirc = new JLabel("Dirección:");
    JLabel MDirc = new JLabel();
    JLabel Consul = new JLabel("Consultorio:");
    JLabel MConsul = new JLabel();
    JButton Sigui = new JButton("Siguiente");
    JButton Ante = new JButton("Anterior");
    JButton Confi = new JButton("Confirmar");
    int i = 0;
    
    public SolicitarCitaParte2() {
        initComponentes();
        mostrar();
        cambiarDatos(0);
    }

    
    public void initComponentes(){
        setSize(400,400); 
        setTitle("Solicitar una cita");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        controlador = new ControladorCitas();
    }
    
    public void cambiarDatos(int i){
        MMT.setText(controlador.obtenerCita(i).getMedicoTratante());
        MFecha.setText(controlador.obtenerCita(i).getFecha());
        MH.setText(controlador.obtenerCita(i).getHora());
        MSede.setText(controlador.obtenerCita(i).getSede());
        MDirc.setText(controlador.obtenerCita(i).getDireccion());
        MConsul.setText(""+controlador.obtenerCita(i).getConsultorio());
    }
    
    public void mostrar(){
        
        MT.setBounds(5, 5, 150, 30);
        MT.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(MT);
        
        MMT.setBounds(205, 10, 150, 20);
        MMT.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MMT);
        
        Fecha.setBounds(5, 35, 150, 30);
        Fecha.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(Fecha);
        
        MFecha.setBounds(205, 40, 150, 20);
        MFecha.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MFecha);
        
        H.setBounds(5, 65, 150, 30);
        H.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(H);
        
        MH.setBounds(205, 70, 150, 20);
        MH.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MH); 
        
        Sede.setBounds(5, 95, 150, 30);
        Sede.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(Sede);
        
        MSede.setBounds(205, 100, 150, 20);
        MSede.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MSede);
        
        Dirc.setBounds(5, 125, 150, 30);
        Dirc.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(Dirc);
        
        MDirc.setBounds(205, 130, 150, 20);
        MDirc.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MDirc);
        
        Consul.setBounds(5, 155, 150, 30);
        Consul.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(Consul);
        
        MConsul.setBounds(205, 160, 150, 20);
        MConsul.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MConsul);
        
        Ante.setBounds(50, 220, 100, 30);
        Ante.addActionListener(this);
        panel.add(Ante);
        
        Sigui.setBounds(225, 220, 100, 30);
        Sigui.addActionListener(this);
        panel.add(Sigui);
        
        Confi.setBounds(138, 300, 100, 30);
        Confi.addActionListener(this);
        panel.add(Confi);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource().equals(Ante)&& i>0){
            i--;
        }
        if (ae.getSource().equals(Sigui)){
            if (i!=controlador.getTamañoArreglo() - 1){
                i++;
            }
        }
        cambiarDatos(i);
    }
}
