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
import javax.swing.SwingConstants;


public class InterfazMedico extends JFrame{
    
    public JPanel panel;
    
    public InterfazMedico(){
        initCompo();
        mostrar();
    }
    
    public void initCompo(){
        setSize(600,270); 
        setTitle("Opciones del afiliado/beneficiario");
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
        
        JButton CreaAgen = new JButton("Crear una agenda");
        CreaAgen.setBounds(200, 70, 200, 30);
        panel.add(CreaAgen);
        
        JButton ConsAgen = new JButton("Consultar una agenda");
        ConsAgen.setBounds(200, 120, 200, 30);
        panel.add(ConsAgen);
        
        JButton CrearRegis = new JButton("Crear el registro de una cita");
        CrearRegis.setBounds(200, 170, 200, 30);
        panel.add(CrearRegis);
        
        CreaAgen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgendaM1 Agen1 = new AgendaM1();
                Agen1.setVisible(true);
                Agen1.setLocationRelativeTo(null);
            }	
        });
        
    }
    
}
