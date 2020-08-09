/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipos;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author katht
 */
public class ResulConsulCita extends JFrame{
    public JPanel panel;
    
    public ResulConsulCita(){
        initCompo();
        mostrar();
    }
    
    public void initCompo(){
        setSize(600,320); 
        setTitle("Consulta de citas");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void mostrar(){
        JLabel Titulo = new JLabel("Datos de la cita", SwingConstants.CENTER);
        Titulo.setBounds(0, 10, 600, 30);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22)); 
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);
        
        JLabel Espe = new JLabel("Especialidad:");
        Espe.setBounds(100, 90, 200, 30);
        Espe.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(Espe);
        
        JLabel MEspe = new JLabel("Odontologia");
        MEspe.setBounds(350, 95, 200, 20);
        MEspe.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MEspe);
        
        JLabel MT = new JLabel("Médico tratante:");
        MT.setBounds(100, 120, 200, 30);
        MT.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(MT);
        
        JLabel MMT = new JLabel("Yuliana Chaves");
        MMT.setBounds(350, 125, 200, 20);
        MMT.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MMT);
        
        JLabel H = new JLabel("Hora:");
        H.setBounds(100, 150, 200, 30);
        H.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(H);
        
        JLabel MH = new JLabel("3:30 pm");
        MH.setBounds(350, 155, 200, 20);
        MH.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MH);
        
        JLabel Sede = new JLabel("Sede:");
        Sede.setBounds(100, 180, 200, 30);
        Sede.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(Sede);
        
        JLabel MSede = new JLabel("Calle 48");
        MSede.setBounds(350, 185, 200, 20);
        MSede.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MSede);
        
        JLabel Dirc = new JLabel("Dirección:");
        Dirc.setBounds(100, 210, 200, 30);
        Dirc.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(Dirc);
        
        JLabel MDirc = new JLabel("Cr 13 # 48 - 51");
        MDirc.setBounds(350, 215, 200, 20);
        MDirc.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MDirc);
        
        JLabel Consul = new JLabel("Consultorio:");
        Consul.setBounds(100, 240, 200, 30);
        Consul.setFont(new Font("Serif", Font.BOLD, 18)); 
        panel.add(Consul);
        
        JLabel MConsul = new JLabel("410");
        MConsul.setBounds(350, 245, 200, 20);
        MConsul.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(MConsul);
    }
}
