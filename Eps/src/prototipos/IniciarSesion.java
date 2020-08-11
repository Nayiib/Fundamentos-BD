package prototipos;

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

/**
Agregar_Ingresar_EPS
 * @author katht
 */
public class IniciarSesion extends JFrame{
    
    public JPanel panel;
    
    public IniciarSesion(){
        initCompo();
        mostrar();
    }
    
    public void initCompo(){
        setSize(600,320); 
        setTitle("Iniciar Sesión");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void mostrar(){
        JLabel Titulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        Titulo.setBounds(0, 10, 600, 30);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22)); 
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);
        
        JLabel TipoD = new JLabel("Tipo identificación *");
        TipoD.setBounds(100, 90, 300, 30);
        TipoD.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(TipoD);
        
        JComboBox MTipo = new JComboBox();
        MTipo.addItem("Cédula");
        MTipo.addItem("Cédula de extrangeria");
        MTipo.addItem("Pasaporte");
        MTipo.setBounds(305, 95, 200, 20);
        MTipo.setBackground(Color.white);
        panel.add(MTipo);
        
        /*JComboBox tipoUsuario = new JComboBox();
        MTipo.addItem("Afiliado/Beneficiario");
        MTipo.addItem("Medico");
        MTipo.setBounds(305, 95, 200, 20);
        MTipo.setBackground(Color.white);
        panel.add(tipoUsuario);*/
        
        JLabel ID = new JLabel("Número identificación *");
        ID.setBounds(100, 120, 300, 30);
        ID.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(ID);
        
        JTextField CID = new JTextField();
        CID.setBounds(305, 125, 200, 20);
        panel.add(CID);
        
        JButton ISesion = new JButton("Iniciar Sesión");
        ISesion.setBounds(200, 175, 150, 30);
        panel.add(ISesion);
        
        ISesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Id = CID.getText();
                if(Id.equals("123")){
                    InterfazAB AB = new InterfazAB();
                    AB.setVisible(true);
                    AB.setLocationRelativeTo(null);
                }
                if(Id.equals("456")){
                    InterfazAdmi Admi = new InterfazAdmi();
                    Admi.setVisible(true);
                    Admi.setLocationRelativeTo(null);
                }
                if(Id.equals("789")){
                    InterfazMedico medico = new InterfazMedico();
                    medico.setVisible(true);
                    medico.setLocationRelativeTo(null);
                }
            }	
        });
 
    }
    
}
