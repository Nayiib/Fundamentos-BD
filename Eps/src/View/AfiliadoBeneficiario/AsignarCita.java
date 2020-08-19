package Gui.AfiliadoBeneficiario;

import Models.DatosConsulCita;
import Models.DatosSolicCita;
import Persistence.AfiliadoDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class AsignarCita extends JFrame {

    public JPanel panel;
    private AfiliadoDAO DAO;
    private String TDA;
    private long iDAfiliado;
    private JButton botonVolver;
    private JComboBox<String> CEspc, CF;

    public AsignarCita(String TDA, long iDAfiliado) {
        this.TDA = TDA;
        this.iDAfiliado = iDAfiliado;
        initCompo();
        mostrar();
        SolicitarEspecialidades();
        SolicitarTipos();
    }

    public void initCompo() {
        setSize(800, 600);
        setTitle("Asignacion de citas");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(800, 600));
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        this.getContentPane().setBackground(Color.WHITE);
        panel.setBackground(Color.WHITE);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        DAO = AfiliadoDAO.getReference();
    }

    private void SolicitarEspecialidades() {
        try {
            CEspc.addItem("");
            ArrayList<String> nombresEspecialidades = new ArrayList<String>();
            nombresEspecialidades = DAO.getEspecialidades();
            nombresEspecialidades.forEach(nombreEsp -> {
                CEspc.addItem(nombreEsp);
            });
        } catch (SQLException ex) {
            System.out.println("Fallo SQL: " + ex.getMessage());
        }
    }

    private void SolicitarTipos() {
        try {
            CF.addItem("");
            ArrayList<String> nombresTipos = new ArrayList<String>();
            nombresTipos = DAO.getTiposCitas();
            nombresTipos.forEach(nombreEsp -> {
                CF.addItem(nombreEsp);
            });
        } catch (SQLException e) {
            System.out.println("Fallo SQL: " + e.getMessage());
        }
    }

    public void mostrar() {
        JLabel Titulo = new JLabel("ASIGNACION DE CITAS", SwingConstants.CENTER);
        Titulo.setBounds(200, 20, 400, 40);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22));
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);

        JLabel Espc = new JLabel("SELECCIONE LA ESPECIALIDAD");
        Espc.setBounds(90, 150, 180, 20);
        Espc.setFont(new Font("font", Font.BOLD, 12));
        panel.add(Espc);

        CEspc = new JComboBox<>();
        CEspc.setBounds(90, 200, 150, 30);
        CEspc.setFont(new Font("font", Font.ITALIC, 16));
        panel.add(CEspc);

        JLabel TpCita = new JLabel("SELECCIONE EL TIPO DE CITA");
        TpCita.setBounds(280, 150, 180, 20);
        TpCita.setFont(new Font("font", Font.BOLD, 12));
        panel.add(TpCita);

        CF = new JComboBox<>();
        CF.setBounds(280, 200, 150, 30);
        CF.setFont(new Font("font", Font.ITALIC, 16));
        panel.add(CF);

        JButton Buscar = new JButton("Verificar disponibilidad");
        Buscar.setBounds(300, 500, 200, 30);
        panel.add(Buscar);

        botonVolver = new JButton("Volver");
        botonVolver.setBounds(100, 500, 100, 30);
        panel.add(botonVolver);

        botonVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dispose();
            }

        });

        Buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<DatosSolicCita> arreglo = new ArrayList<DatosSolicCita>();
                ArrayList<String> arreglo1 = new ArrayList<String>();
                ArrayList<String> arreglo2 = new ArrayList<String>();
                try {
                    arreglo1 = DAO.verificarCondiciones(iDAfiliado, String.valueOf(CEspc.getSelectedItem()));
                    arreglo1 = DAO.verificarCondiciones2(iDAfiliado);

                    if (arreglo1.isEmpty() && arreglo.isEmpty()) {
                        arreglo = DAO.consultarCitasDisponibles(String.valueOf(CEspc.getSelectedItem()), String.valueOf(CF.getSelectedItem()));
                        if (arreglo.isEmpty()) {
                            JOptionPane.showMessageDialog(panel, "No se encontraron citas disponibles", "Estado consulta", JOptionPane.WARNING_MESSAGE);
                        } else {
                            SolicitarCitaParte2 Aconscita = new SolicitarCitaParte2(TDA, iDAfiliado, arreglo);
                            Aconscita.setVisible(true);
                            Aconscita.setLocationRelativeTo(null);
                            System.out.println(arreglo1);
                        }
                    } else {
                        JOptionPane.showMessageDialog(panel, "Ya tiene una cita asignada a esta especialidad o pendiente de pago", "Estado consulta", JOptionPane.WARNING_MESSAGE);
                    }
                } catch (SQLException ex) {
                    System.out.println("Fallo SQL: " + ex.getMessage());
                }

            }
        });
    }

}
