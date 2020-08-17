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
import Persistence.AdministradorDAO;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

//Modelos
import Models.Medico;
import Models.EspecialidadMedicoConsultorio;

public class AgregarEspecialidad extends JFrame implements ActionListener {

    private JPanel panel;
    private Medico medico;
    private ArrayList<EspecialidadMedicoConsultorio> especialidades;
    private JLabel Titulo,Espe,Sede,Consul,tHorario;
    private JTextField CEspe,CSede,CConsul;
    private JButton Registrar,AOtra;
    private JComboBox<String> horario;
    private AdministradorDAO controller = AdministradorDAO.getReference();

    public AgregarEspecialidad(Medico medico) {
        initCompo();
        mostrar();
        this.medico = medico;
        especialidades = new ArrayList<>();
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
        
        tHorario = new JLabel("Horario");
        tHorario.setBounds(100, 60, 100, 30);
        panel.add(tHorario);
        
        horario = new JComboBox<>();
        horario.addItem("Mañana");
        horario.addItem("Tarde");
        horario.setBackground(Color.WHITE);
        horario.setBounds(305, 60, 200, 20);
        panel.add(horario);

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

        Consul = new JLabel("Consultorio");
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

        AOtra = new JButton("Añadir");
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
                controller.agregarEspecialidadesMedico(especialidades);
                JOptionPane.showMessageDialog(null, "Medico " + medico.getNombreUsuario()+
                        " Creado exitosamente ","OK",JOptionPane.DEFAULT_OPTION);
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Ha habido un problema","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else if(ae.getSource() == AOtra){
            try{
                EspecialidadMedicoConsultorio object;
                object = new EspecialidadMedicoConsultorio(controller.getIDEspecialidad(CEspe.getText()),
                        medico.getTipoDocumento(), medico.getNumeroDocumento(),Long.valueOf(CConsul.getText()),
                        controller.getIDSede(CSede.getText()), String.valueOf(horario.getSelectedItem()));
                
                System.out.println(object.toString());
                especialidades.add(object);
                
                CEspe.setText("");
                CSede.setText("");
                CConsul.setText("");

            }catch(SQLException e){
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(null, "Asegurese que sus datos son correctos","Error",JOptionPane.ERROR_MESSAGE);
            }
            
        }
    }

}
