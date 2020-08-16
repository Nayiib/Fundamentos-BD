package Gui;

import Gui.Medico.InterfazMedico;
import Gui.AfiliadoBeneficiario.InterfazAfiliadoBeneficiario;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;

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

import Persistence.DAO;

public class IniciarSesion extends JFrame {

    private JPanel panel;
    private DAO controlador;

    public IniciarSesion() {
        initCompo();
        mostrar();
        controlador = DAO.getReference();

    }

    public void initCompo() {
        setSize(600, 320);
        setTitle("Iniciar Sesión");
        setResizable(false);
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void mostrar() {
        JLabel Titulo = new JLabel("Iniciar Sesión", SwingConstants.CENTER);
        Titulo.setBounds(0, 10, 600, 30);
        Titulo.setFont(new Font("Serif", Font.BOLD, 22));
        Titulo.setForeground(new Color(21, 67, 96));
        panel.add(Titulo);

        JLabel TipoD = new JLabel("Tipo");
        TipoD.setBounds(100, 90, 300, 30);
        TipoD.setFont(new Font("Serif", Font.BOLD, 14));
        panel.add(TipoD);

        JLabel textTipoUsuario = new JLabel("¿Quien esta ingresando?");
        textTipoUsuario.setBounds(100, 120, 700, 30);
        textTipoUsuario.setFont(new Font("Serif", Font.BOLD, 14));
        panel.add(textTipoUsuario);

        JComboBox<String> TipoUsuario = new JComboBox<>();
        TipoUsuario.addItem("Medico");
        TipoUsuario.addItem("Afiliado/Beneficiario");
        TipoUsuario.setBounds(305, 125, 200, 20);
        panel.add(TipoUsuario);

        JComboBox<String> MTipo = new JComboBox<>();
        MTipo.addItem("Cedula de ciudadania");
        MTipo.addItem("Cedula de extrangeria");
        MTipo.addItem("Pasaporte");
        MTipo.addItem("Registro civil");
        MTipo.setBounds(305, 95, 200, 20);
        MTipo.setBackground(Color.white);
        panel.add(MTipo);

        JLabel ID = new JLabel("Número identificación *");
        ID.setBounds(100, 150, 300, 30);
        ID.setFont(new Font("Serif", Font.BOLD, 14));
        panel.add(ID);

        JTextField CID = new JTextField();
        CID.setBounds(305, 155, 200, 20);
        panel.add(CID);

        JButton ISesion = new JButton("Iniciar Sesión");
        ISesion.setSize(new Dimension(150, 30));
        ISesion.setLocation(220, 200);
        //ISesion.setBounds(200, 200, 150, 30);
        panel.add(ISesion);

        ISesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String Id = CID.getText();
                String tipoUsuario = String.valueOf(TipoUsuario.getSelectedItem());
                String tipoDocumento = String.valueOf(MTipo.getSelectedItem());

                if (tipoUsuario.equals("Medico")) {
                    if (controlador.getUser("medico", tipoDocumento, Long.parseLong(Id))) {
                        IniciarSesion.this.setVisible(false);
                        InterfazMedico medico = new InterfazMedico(Long.valueOf(CID.getText()));
                        medico.setVisible(true);
                        medico.setLocationRelativeTo(null);

                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor asegurese que sus datos esten bien escritos", "Error Autenticacion", JOptionPane.ERROR_MESSAGE);
                    }

                } else {
                    if (controlador.getUser("afiliado_beneficiario", tipoDocumento, Long.parseLong(Id))) {
                        IniciarSesion.this.setVisible(false);
                        InterfazAfiliadoBeneficiario AB = new InterfazAfiliadoBeneficiario(Long.valueOf(CID.getText()));
                        AB.setVisible(true);
                        AB.setLocationRelativeTo(null);
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor asegurese que sus datos esten bien escritos", "Error Autenticacion", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }
        });

    }

}
