package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class AgendaM2 extends JFrame{
    public JPanel panel;
    
    public AgendaM2(){
        initCompo();
        mostrar();
    }
    
    public void initCompo(){
        setSize(600,350); 
        setTitle("Crear una agenda");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void mostrar(){
        JLabel Titulo = new JLabel("Agregar una cita", SwingConstants.CENTER);
        Titulo.setBounds(0, 10, 600, 30);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22)); 
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);
        
        JLabel MAgen = new JLabel("Digite el dia");
        MAgen.setBounds(100, 90, 100, 30);
        MAgen.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MAgen);
        
        JTextField CMAgen = new JTextField();
        CMAgen.setBounds(325, 95, 180, 20);
        panel.add(CMAgen);
        
        JLabel AAgen = new JLabel("Seleccione la especialidad");
        AAgen.setBounds(100, 120, 300, 30);
        AAgen.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(AAgen);
        
        JTextField CAAgen = new JTextField();
        CAAgen.setBounds(325, 125, 180, 20);
        panel.add(CAAgen);
        
        JLabel TiCita = new JLabel("Seleccione el tipo de cita");
        TiCita.setBounds(100, 150, 300, 30);
        TiCita.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(TiCita);
        
        JTextField CTiCita = new JTextField();
        CTiCita.setBounds(325, 155, 180, 20);
        panel.add(CTiCita);
        
        JLabel HICita = new JLabel("Seleccione la hora inicial de la cita");
        HICita.setBounds(100, 180, 400, 30);
        HICita.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(HICita);
        
        JTextField CHICita = new JTextField();
        CHICita.setBounds(325, 185, 180, 20);
        panel.add(CHICita);
        
        JButton Continuar = new JButton("Continuar");
        Continuar.setBounds(250, 245, 100, 30);
        panel.add(Continuar);
        
    }
}
