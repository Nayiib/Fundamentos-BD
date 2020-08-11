package Gui;

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


public class RegistrarMedico extends JFrame{
    public JPanel panel;
    
    public RegistrarMedico(){
        initCompo();
        mostrar();
    }
    
    public void initCompo(){
        setSize(600,660); 
        setTitle("Registrar un nuevo medico");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void mostrar(){
        JLabel Titulo = new JLabel("Registrar un nuevo medico", SwingConstants.CENTER);
        Titulo.setBounds(0, 10, 600, 30);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22)); 
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);
        
        JLabel DM = new JLabel("Datos del médico");
        DM.setBounds(5, 50, 600, 30);
        DM.setFont(new Font("Serif", Font.BOLD, 18)); 
        DM.setForeground(new Color(21, 67, 96));
        panel.add(DM);
        
        JLabel Tipo = new JLabel("Tipo identificación *");
        Tipo.setBounds(5, 80, 300, 30);
        Tipo.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(Tipo);
        
        JComboBox MTipo = new JComboBox();
        MTipo.addItem("Registro civil");
        MTipo.addItem("Tarjeta de identidad");
        MTipo.addItem("Cedula de ciudadania");
        MTipo.addItem("Cedula  de extrangeria");
        MTipo.setBounds(5, 115, 200, 20);
        MTipo.setBackground(Color.white);
        panel.add(MTipo);
        
        JLabel ID = new JLabel("Número identificación *");
        ID.setBounds(305, 80, 300, 30);
        ID.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(ID);
        
        JTextField CID = new JTextField();
        CID.setBounds(305, 115, 200, 20);
        panel.add(CID);
        
        JLabel Nom = new JLabel("Nombre(s) *");
        Nom.setBounds(5, 140, 300, 30);
        Nom.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(Nom);
        
        JTextField CNom = new JTextField();
        CNom.setBounds(5, 175, 200, 20);
        panel.add(CNom);
        
        JLabel Apell = new JLabel("Apellido(s) *");
        Apell.setBounds(305, 140, 300, 30);
        Apell.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(Apell);
        
        JTextField CApell = new JTextField();
        CApell.setBounds(305, 175, 200, 20);
        panel.add(CApell);
        
        JLabel Sexo = new JLabel("Sexo *");
        Sexo.setBounds(5, 200, 300, 30);
        Sexo.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(Sexo);
        
        JComboBox MSexo = new JComboBox();
        MSexo.addItem("F");
        MSexo.addItem("M");
        MSexo.setBounds(5, 235, 200, 20);
        MSexo.setBackground(Color.white);
        panel.add(MSexo);
        
        JLabel FN = new JLabel("Fecha de nacimiento (DD/MM/AAAA) *");
        FN.setBounds(305, 200, 300, 30);
        FN.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(FN);
        
        JTextField CFN = new JTextField();
        CFN.setBounds(305, 235, 200, 20);
        panel.add(CFN);
        
        JLabel Cont = new JLabel("Contacto");
        Cont.setBounds(5, 260, 600, 30);
        Cont.setFont(new Font("Serif", Font.BOLD, 18)); 
        Cont.setForeground(new Color(21, 67, 96));
        panel.add(Cont);
        
        JLabel TC = new JLabel("Teléfono casa");
        TC.setBounds(5, 290, 300, 30);
        TC.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(TC);
        
        JTextField CTC = new JTextField();
        CTC.setBounds(5, 325, 200, 20);
        panel.add(CTC);
        
        JLabel NC = new JLabel("Teléfono celular *");
        NC.setBounds(305, 290, 300, 30);
        NC.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(NC);
        
        JTextField CNC = new JTextField();
        CNC.setBounds(305, 325, 200, 20);
        panel.add(CNC);
        
        JLabel Correo = new JLabel("Correo electrónico *");
        Correo.setBounds(5, 350, 300, 30);
        Correo.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(Correo);
        
        JTextField CCorreo = new JTextField();
        CCorreo.setBounds(5, 385, 200, 20);
        panel.add(CCorreo);
        
        JLabel FA = new JLabel("Formación académica");
        FA.setBounds(5, 410, 300, 30);
        FA.setFont(new Font("Serif", Font.BOLD, 18)); 
        FA.setForeground(new Color(21, 67, 96));
        panel.add(FA);
        
        JLabel RM = new JLabel("Registro médico *");
        RM.setBounds(5, 440, 300, 30);
        RM.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(RM);
        
        JTextField CRM = new JTextField();
        CRM.setBounds(5, 475, 200, 20);
        panel.add(CRM);
        
        JButton AñadiEspe = new JButton("Agregar especialidad(es)");
        AñadiEspe.setBounds(200, 580, 200, 30);
        panel.add(AñadiEspe);
        
        AñadiEspe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AgregarEspMedico IAgregarEspMedico = new AgregarEspMedico();
                IAgregarEspMedico.setVisible(true);
                IAgregarEspMedico.setLocationRelativeTo(null);
            }	
        });
    }
}
