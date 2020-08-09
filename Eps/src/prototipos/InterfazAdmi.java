/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prototipos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author katht
 */
public class InterfazAdmi extends JFrame{
    
    public JPanel panel;
    
    public InterfazAdmi(){
        initCompo();
        mostrar();
    }
    
    public void initCompo(){
        setSize(600,270); 
        setTitle("Opciones del administrador");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void mostrar(){
        JLabel Titulo = new JLabel("¿Que acción desea realizar?", SwingConstants.CENTER);
        Titulo.setBounds(0, 10, 600, 30);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22)); 
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);
        
        JButton RegisMedic = new JButton("Registrar un medico");
        RegisMedic.setBounds(200, 90, 200, 30);
        panel.add(RegisMedic);
        
        JButton RegisAB = new JButton("Registrar un afiliado/beneficiario");
        RegisAB.setBounds(150, 160, 300, 30);
        panel.add(RegisAB);
        
        RegisMedic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarMedico IRegisMedic = new RegistrarMedico();
                IRegisMedic.setVisible(true);
                IRegisMedic.setLocationRelativeTo(null);
            }	
        });
        RegisAB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RegistrarAB IRegisAB = new RegistrarAB();
                IRegisAB.setVisible(true);
                IRegisAB.setLocationRelativeTo(null);
            }	
        });
        
    }
    
}