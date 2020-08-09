/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipos;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
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
public class AgregarEspMedico extends JFrame{
    
   public JPanel panel;
    
    public AgregarEspMedico(){
        initCompo();
        mostrar();
    }
    
    public void initCompo(){
        setSize(600,270); 
        setTitle("Agregar especialidad(es) al medico");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void mostrar(){
        JLabel Titulo = new JLabel("Agregar especialidad(es) al medico", SwingConstants.CENTER);
        Titulo.setBounds(0, 10, 600, 30);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22)); 
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);
        
        JLabel Espe = new JLabel("Especialidad");
        Espe.setBounds(100, 90, 100, 30);
        Espe.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(Espe);
        
        JTextField CEspe = new JTextField();
        CEspe.setBounds(305, 95, 200, 20);
        panel.add(CEspe);
        
        JLabel Sede = new JLabel("Sede");
        Sede.setBounds(100, 120, 300, 30);
        Sede.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(Sede);
        
        JTextField CSede = new JTextField();
        CSede.setBounds(305, 125, 200, 20);
        panel.add(CSede);
        
        JLabel Consul = new JLabel("Consultotio");
        Consul.setBounds(100, 150, 300, 30);
        Consul.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(Consul);
        
        JTextField CConsul = new JTextField();
        CConsul.setBounds(305, 150, 200, 20);
        panel.add(CConsul);
        
        JButton Registrar = new JButton("Terminar registro");
        Registrar.setBounds(130, 190, 150, 30);
        panel.add(Registrar);
        
        JButton AOtra = new JButton("Añadir una otra");
        AOtra.setBounds(300, 190, 150, 30);
        panel.add(AOtra);
    }
    
}
