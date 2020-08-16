package Gui.AfiliadoBeneficiario;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class ConsultarCita extends JFrame{
    public JPanel panel;
    
    public ConsultarCita(){
        initCompo();
        mostrar();
    }
    
    public void initCompo(){
        setSize(600,250); 
        setTitle("Consulta de citas");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void mostrar(){
        JLabel Titulo = new JLabel("Consulta de citas", SwingConstants.CENTER);
        Titulo.setBounds(0, 10, 600, 30);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22)); 
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);
        
        JLabel User = new JLabel("Usuario");
        User.setBounds(100, 90, 100, 30);
        User.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(User);
        
        JTextField CUser = new JTextField();
        CUser.setBounds(305, 95, 200, 20);
        panel.add(CUser);
        
        JLabel F = new JLabel("Fecha (DD/MM/AAAA)");
        F.setBounds(100, 120, 300, 30);
        F.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(F);
        
        JTextField CF = new JTextField();
        CF.setBounds(305, 125, 200, 20);
        panel.add(CF);
        
        JButton Buscar = new JButton("Buscar");
        Buscar.setBounds(250, 165, 100, 30);
        panel.add(Buscar);
        
        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ResulConsulCita Aconscita = new ResulConsulCita();
                Aconscita.setVisible(true);
                Aconscita.setLocationRelativeTo(null);
            }	
        });
        
    }
    
}
