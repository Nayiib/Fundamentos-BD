package Gui.AfiliadoBeneficiario;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class SolicitarCita extends JFrame{
    
    public JPanel panel;
    
    public SolicitarCita(){
        initCompo();
        mostrar();
    }
    
    public void initCompo(){
        setSize(600,250); 
        setTitle("Solicitar una cita");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void mostrar(){
        JLabel Titulo = new JLabel("Solicitar una cita", SwingConstants.CENTER);
        Titulo.setBounds(0, 10, 600, 30);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22)); 
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);
        
        JLabel Espc = new JLabel("Especialidad *");
        Espc.setBounds(100, 90, 100, 30);
        Espc.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(Espc);
        
        JTextField CEspc = new JTextField();
        CEspc.setBounds(305, 95, 200, 20);
        panel.add(CEspc);
        
        JLabel TpCita = new JLabel("Tipo de cita *");
        TpCita.setBounds(100, 120, 300, 30);
        TpCita.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(TpCita);
        
        JTextField CF = new JTextField();
        CF.setBounds(305, 125, 200, 20);
        panel.add(CF);
        
        JButton Buscar = new JButton("Buscar citas disponibles");
        Buscar.setBounds(200, 165, 200, 30);
        panel.add(Buscar);
    }
    
}
