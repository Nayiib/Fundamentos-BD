package Gui.Admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import Models.Medico;
import Persistence.MedicoDAO;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AgregarEspecialidad extends JFrame implements ActionListener {

    private JPanel panel;
    private Medico medico;
    private ArrayList especialidades;
    private JLabel Titulo,Espe,Sede,Consul;
    private JTextField CEspe,CSede,CConsul;
    private JButton Registrar,AOtra;
    private MedicoDAO controller = MedicoDAO.getReference();

    public AgregarEspecialidad(Medico medico) {
        initCompo();
        mostrar();
        this.medico = medico;
    }

    public void initCompo() {
        setSize(600, 270);
        setTitle("Agregar especialidad(es) al medico");
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void mostrar() {
        Titulo = new JLabel("Agregar especialidad(es) al medico", SwingConstants.CENTER);
        Titulo.setBounds(0, 10, 600, 30);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22));
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);

        Espe = new JLabel("Especialidad");
        Espe.setBounds(100, 90, 100, 30);
        Espe.setFont(new Font("Serif", Font.BOLD, 14));
        panel.add(Espe);

        CEspe = new JTextField();
        CEspe.setBounds(305, 95, 200, 20);
        panel.add(CEspe);

        Sede = new JLabel("Sede");
        Sede.setBounds(100, 120, 300, 30);
        Sede.setFont(new Font("Serif", Font.BOLD, 14));
        panel.add(Sede);

        CSede = new JTextField();
        CSede.setBounds(305, 125, 200, 20);
        panel.add(CSede);

        Consul = new JLabel("Consultotio");
        Consul.setBounds(100, 150, 300, 30);
        Consul.setFont(new Font("Serif", Font.BOLD, 14));
        panel.add(Consul);

        CConsul = new JTextField();
        CConsul.setBounds(305, 150, 200, 20);
        panel.add(CConsul);

        Registrar = new JButton("Terminar registro");
        Registrar.setBounds(130, 190, 150, 30);
        Registrar.addActionListener(this);
        panel.add(Registrar);

        AOtra = new JButton("Añadir una otra");
        AOtra.setBounds(300, 190, 150, 30);
        AOtra.addActionListener(this);
        panel.add(AOtra);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == Registrar){
            try{
                controller.registrarUsuario(medico);
                controller.registrarMedico(medico);
                JOptionPane.showMessageDialog(null, "Medico " + medico.getNombreUsuario()+
                        "Creado exitosamente ","OK",JOptionPane.OK_OPTION);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Ha habido un problema","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else if(ae.getSource() == AOtra){
            
        }
    }

}
