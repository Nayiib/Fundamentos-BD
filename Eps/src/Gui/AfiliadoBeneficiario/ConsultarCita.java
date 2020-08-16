package Gui.AfiliadoBeneficiario;

import Controllers.ControladorConsulCitas;
import Models.DatosConsulCita;
import Persistence.AfiliadoDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class ConsultarCita extends JFrame{
    public JPanel panel;
    private AfiliadoDAO control;
    private long iDAfiliadoRef;
    private java.util.Date fechaUtil;
    private java.sql.Date fechaSQL;
    SimpleDateFormat formatterDateSQL = new SimpleDateFormat("yyyy-MM-dd");
    
    public ConsultarCita(long iDAfiliado){
        iDAfiliadoRef = iDAfiliado;
        initCompo();
        mostrar();
    }
    
    public void initCompo(){
        setSize(600,250); 
        setTitle("Consulta de citas");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        control = AfiliadoDAO.getReference();
    }
    
    public void mostrar(){
        JLabel Titulo = new JLabel("Consulta de citas", SwingConstants.CENTER);
        Titulo.setBounds(0, 10, 600, 30);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22)); 
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);
        
        JLabel F = new JLabel("Fecha (AAAA-MM-DD)");
        F.setBounds(100, 70, 300, 30);
        F.setFont(new Font("Serif", Font.BOLD, 14)); 
        panel.add(F);
        
        JTextField CF = new JTextField();
        CF.setBounds(305, 75, 200, 20);
        panel.add(CF);
        
        JButton Buscar = new JButton("Buscar");
        Buscar.setBounds(250, 165, 100, 30);
        panel.add(Buscar);
        
        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<DatosConsulCita> arreglo = new ArrayList<DatosConsulCita>();
                try {
                    fechaUtil = formatterDateSQL.parse(CF.getText());
                    fechaSQL = new java.sql.Date(fechaUtil.getTime());
                } catch (ParseException ex) {
                    System.out.println("Falló el método Parse: " + ex.getMessage());
                }
                try {
                    arreglo = control.consultarCitas2(iDAfiliadoRef, fechaSQL);
                    if (arreglo.isEmpty()) {
                        JOptionPane.showMessageDialog(panel, "No se encontraron citas para la fecha ingresada", "Estado consulta", JOptionPane.WARNING_MESSAGE);
                    } else {
                            ResulConsulCita Aconscita = new ResulConsulCita(arreglo);
                            Aconscita.setVisible(true);
                            Aconscita.setLocationRelativeTo(null);
                        }
                    }
                catch (SQLException ex) {
                    System.out.println("Fallo SQL: " + ex.getMessage());
                }
                
            }
        });
        
    }
    
}
