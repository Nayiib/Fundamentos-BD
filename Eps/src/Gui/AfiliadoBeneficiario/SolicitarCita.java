package Gui.AfiliadoBeneficiario;

import Models.DatosConsulCita;
import Models.DatosSolicCita;
import Persistence.AfiliadoDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class SolicitarCita extends JFrame{
    
    public JPanel panel;
    private AfiliadoDAO control;
    private String TDA;
    private long iDAfiliado;
    
    public SolicitarCita(String TDA, long iDAfiliado){
        this.TDA = TDA;
        this.iDAfiliado = iDAfiliado;
        initCompo();
        mostrar();
    }
    
    public void initCompo(){
        setSize(600,250); 
        setTitle("Solicitar una cita");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        control = AfiliadoDAO.getReference();
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
        
        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<DatosSolicCita> arreglo = new ArrayList<DatosSolicCita>();
                ArrayList<String> arreglo1 = new ArrayList<String>();
                ArrayList<String> arreglo2 = new ArrayList<String>();
                try {
                    arreglo1 = control.verificarCondiciones(iDAfiliado, CEspc.getText());
                    arreglo1 = control.verificarCondiciones2(iDAfiliado);
                    if (arreglo1.isEmpty() && arreglo.isEmpty()) {
                        arreglo = control.consultarCitasDisponibles(CEspc.getText(), CF.getText());
                        if (arreglo.isEmpty()) {
                            JOptionPane.showMessageDialog(panel, "No se encontraron citas disponibles", "Estado consulta", JOptionPane.WARNING_MESSAGE);
                        } else {
                                SolicitarCitaParte2 Aconscita = new SolicitarCitaParte2(TDA, iDAfiliado, arreglo);
                                Aconscita.setVisible(true);
                                Aconscita.setLocationRelativeTo(null);
                            }
                    } else {
                            JOptionPane.showMessageDialog(panel, "Ya tiene una cita asignada a esta especialidad o pendiente de pago", "Estado consulta", JOptionPane.WARNING_MESSAGE);
                        }
                    }    
                catch (SQLException ex) {
                    System.out.println("Fallo SQL: " + ex.getMessage());
                }
                
            }
        });
    }
    
}
