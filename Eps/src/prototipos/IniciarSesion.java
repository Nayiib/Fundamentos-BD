package prototipos;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

import controllers.AdministradorController;


public class IniciarSesion extends JFrame{
    
    public JPanel panel;
    private AdministradorController administrador;
    
    public IniciarSesion(){
        initCompo();
        mostrar();
        administrador = AdministradorController.getReference();
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
        
        JLabel TipoD = new JLabel("Tipo");
        TipoD.setBounds(100, 90, 300, 30);
        TipoD.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(TipoD);
        
        JComboBox<String> MTipo = new JComboBox<>();
        MTipo.addItem("Medico");
        MTipo.addItem("Afiliado");
        MTipo.setBounds(305, 95, 200, 20);
        MTipo.setBackground(Color.white);
        panel.add(MTipo);
        
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
                String tipo = String.valueOf(MTipo.getSelectedItem());
                
                if(tipo.equals("Medico")){
                    if(administrador.getMedico(Id) != null){
                        InterfazAB AB = new InterfazAB();
                        AB.setVisible(true);
                        AB.setLocationRelativeTo(null);
                    }else{
                        JOptionPane.showMessageDialog(null, "Error Autenticacion", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
                if(tipo.equals("Afiliado")){
                    if(administrador.getAfiliado(Id) != null){
                        InterfazAB AB = new InterfazAB();
                        AB.setVisible(true);
                        AB.setLocationRelativeTo(null);
                    }else{
                        JOptionPane.showMessageDialog(null, "Error Autenticacion", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
            }	
        });
 
    }


}
