package Gui;

//Elementos Graficos
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
//Elementos decorativos
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
//Eventos
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//Clase Dao
import Persistence.MedicoDAO;

public class RegistrarDiagnostico extends JFrame implements ActionListener {
    
    private JButton btnGuardar;
    private JTextArea txtSintomas,txtDiagnostico,txtPreinscrpcion;
    private JLabel lNombre,lTitle,lMedico,lFecha,lHora;
    private JPanel panel;
    private final int ANCHO = 600,ALTO = 685;
    private final String font = "Dosis";
    private MedicoDAO medicoController = MedicoDAO.getReference();
    private long idCita;
    private static long idRegistro = 1; 
            
    private void setElements(String nombrePaciente,String medico){
        //Configuracion panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setSize(new Dimension(ANCHO,ALTO));
        panel.setLocation(0,0);
        
        //Titulo del Frame
        lTitle = new JLabel("Registro de diagnóstico médico: ");
        lTitle.setFont(new Font(font,Font.BOLD,30));
        lTitle.setSize(new Dimension(550,43));
        lTitle.setLocation(15, 20);
        
        //Labels
        lNombre = new JLabel("Nombre: " + nombrePaciente);
        lNombre.setSize(new Dimension(300,25));
        lNombre.setLocation(10,100);
        lNombre.setFont(new Font(font,Font.BOLD,15));
        //--------------------------------------------
        lMedico = new JLabel("Medico a cargo: " + medico);
        lMedico.setSize(new Dimension(300,25));
        lMedico.setLocation(10,130);
        lMedico.setFont(new Font(font,Font.BOLD,15));
        //--------------------------------------------
        lFecha = new JLabel("Fecha de la cita: ");
        lFecha.setSize(new Dimension(200,25));
        lFecha.setLocation(10,160);
        lFecha.setFont(new Font(font,Font.BOLD,15));
        //--------------------------------------------
        lHora = new JLabel("Hora de finalización: ");
        lHora.setSize(new Dimension(200,25));
        lHora.setLocation(10,190);
        lHora.setFont(new Font(font,Font.BOLD,15));
        //--------------------------------------------
        //Text Area
        txtSintomas = new JTextArea("Sintomas");
        txtSintomas.setFont(new Font(font,Font.PLAIN,15));
        txtSintomas.setLineWrap(true);
        txtSintomas.setWrapStyleWord(true);
        JScrollPane scrollUno = new JScrollPane(txtSintomas);
        scrollUno.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollUno.setHorizontalScrollBar(null);
        scrollUno.setSize(new Dimension(575,100));
        scrollUno.setLocation(10, 260);
        //------------------------------------------------------------------------------
        txtDiagnostico = new JTextArea("Diagnóstico");
        txtDiagnostico.setFont(new Font(font,Font.PLAIN,15));
        txtDiagnostico.setLineWrap(true);
        txtDiagnostico.setWrapStyleWord(true);
        JScrollPane scrollDos = new JScrollPane(txtDiagnostico);
        scrollDos.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollDos.setHorizontalScrollBar(null);
        scrollDos.setSize(new Dimension(575,100));
        scrollDos.setLocation(10, 380);
        //------------------------------------------------------------------------------
        txtPreinscrpcion = new JTextArea("Preinscripción");
        txtPreinscrpcion.setFont(new Font(font,Font.PLAIN,15));
        txtPreinscrpcion.setLineWrap(true);
        txtPreinscrpcion.setWrapStyleWord(true);
        JScrollPane scrollTres = new JScrollPane(txtPreinscrpcion);
        scrollTres.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollTres.setHorizontalScrollBar(null);
        scrollTres.setSize(new Dimension(575,100));
        scrollTres.setLocation(10, 490);
        
        //Configuracion del boton
        btnGuardar = new JButton("Guardar");
        btnGuardar.setFont(new Font(font,Font.BOLD,12));
        btnGuardar.setSize(new Dimension(85,35));
        btnGuardar.setFocusable(false);
        btnGuardar.setLocation((panel.getWidth() - btnGuardar.getWidth())/2,600);
        btnGuardar.addActionListener(this);
        
        //Agrego los elementos al panel y el panel a la ventana
        panel.add(lTitle);
        panel.add(lNombre);
        panel.add(lMedico);
        panel.add(lFecha);
        panel.add(lHora);
        panel.add(scrollUno);
        panel.add(scrollDos);
        panel.add(scrollTres);
        panel.add(btnGuardar);
        add(panel);
    }
    
    public RegistrarDiagnostico(String nombrePaciente,String medico,long idCita){
        
        this.idCita = idCita;
        
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(ANCHO,ALTO));
        setMinimumSize(new Dimension(ANCHO,ALTO));
        setMaximumSize(new Dimension(ANCHO,ALTO));
        setResizable(false);
        setElements(nombrePaciente,medico);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        medicoController.registrarDiagnostico(idRegistro,txtDiagnostico.getText(),(txtSintomas.getText() +", "+txtPreinscrpcion.getText()), this.idCita);
        idRegistro++;
        JOptionPane.showMessageDialog(null, "Datos guardados de forma exitosa", "Registro guardado", JOptionPane.DEFAULT_OPTION);
        txtDiagnostico.setText("");
        txtSintomas.setText("");
        txtPreinscrpcion.setText("");
    
    }
    
}
