package Gui.AfiliadoBeneficiario;

import Persistence.AfiliadoDAO;
import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class CancelarCita extends JFrame {

    private Panel panel;
    private AfiliadoDAO control;

    public CancelarCita() {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setTitle("Eliminar Cita");
        setSize(new Dimension(660, 475));
        GenerarPanel();
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
        control = AfiliadoDAO.getReference();
    }

    public void GenerarPanel() {
        panel = new Panel();
        setContentPane(panel);
        panel.setLayout(null);
        panel.GenerarInterfaz();
    }

    public class Panel extends JPanel implements ActionListener {

        private JLabel titulo;
        private JLabel fechaCita;
        private JLabel elijaCita;
        private JLabel idCita;
        private JFormattedTextField textFieldDate;
        private JTextField textFieldIdCita;
        private JButton botonConsultar;
        private JButton botonVolver;
        private JButton botonConfirmar;
        private MaskFormatter formatterDate = null;
        SimpleDateFormat formatterDateSQL = new SimpleDateFormat("yyyy-mm-dd");
        private JComboBox citas;
        private java.util.Date fechaUtil;
        private java.sql.Date fechaSQL;

        public Panel() {
            setBorder(BorderFactory.createStrokeBorder(new BasicStroke(7.0f)));
            setPreferredSize(new Dimension(660, 475));
        }

        public void GenerarInterfaz() {
            titulo = new JLabel("ELIMINAR UNA CITA");
            fechaCita = new JLabel("Fecha de la cita:");
            elijaCita = new JLabel("Elija su cita:");
            idCita = new JLabel("ID de su cita:");
            try {
                formatterDate = new MaskFormatter("####-##-##");
                textFieldDate = new JFormattedTextField(formatterDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            textFieldIdCita = new JTextField();

            botonConsultar = new JButton("Consultar citas");
            botonVolver = new JButton("Volver");
            botonConfirmar = new JButton("Confirmar");

            citas = new JComboBox();

            /**
             * ***************************************************************************************************
             */
            titulo.setSize(600, 100);
            titulo.setLocation(35, 0);
            titulo.setFont(new Font("font", Font.BOLD, 25));
            titulo.setHorizontalAlignment(SwingConstants.CENTER);

            fechaCita.setSize(330, 70);
            fechaCita.setLocation(10, 110);
            fechaCita.setFont(new Font("font", Font.BOLD, 25));
            fechaCita.setHorizontalAlignment(SwingConstants.CENTER);

            elijaCita.setSize(330, 70);
            elijaCita.setLocation(10, 230);
            elijaCita.setFont(new Font("font", Font.BOLD, 25));
            elijaCita.setHorizontalAlignment(SwingConstants.CENTER);

            idCita.setSize(330, 70);
            idCita.setLocation(10, 310);
            idCita.setFont(new Font("font", Font.BOLD, 25));
            idCita.setHorizontalAlignment(SwingConstants.CENTER);

            textFieldDate.setSize(250, 40);
            textFieldDate.setLocation(360, 127);
            textFieldDate.setFont(new Font("font", Font.BOLD, 25));
            textFieldDate.setHorizontalAlignment(SwingConstants.CENTER);

            textFieldIdCita.setSize(250, 40);
            textFieldIdCita.setLocation(360, 327);
            textFieldIdCita.setFont(new Font("font", Font.BOLD, 25));
            textFieldIdCita.setHorizontalAlignment(SwingConstants.CENTER);
            textFieldIdCita.setFocusable(false);

            botonConsultar.setSize(170, 35);
            botonConsultar.setLocation(400, 180);
            botonConsultar.setFont(new Font("font", Font.BOLD, 18));

            botonVolver.setSize(170, 35);
            botonVolver.setLocation(110, 410);
            botonVolver.setFont(new Font("font", Font.BOLD, 25));

            botonConfirmar.setSize(170, 35);
            botonConfirmar.setLocation(380, 410);
            botonConfirmar.setFont(new Font("font", Font.BOLD, 25));

            citas.setSize(170, 35);
            citas.setLocation(400, 247);
            citas.setFont(new Font("font", Font.BOLD, 25));

            /**
             * ***************************************************************************************************
             */
            botonConsultar.addActionListener(this);
            botonVolver.addActionListener(this);
            botonConfirmar.addActionListener(this);

            add(titulo);
            add(fechaCita);
            add(elijaCita);
            add(idCita);
            add(textFieldDate);
            add(textFieldIdCita);
            add(botonConsultar);
            add(botonVolver);
            add(botonConfirmar);
            add(citas);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(7));
            g.drawLine(0, 105, 660, 105);
            g.drawLine(0, 380, 660, 380);
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals(botonConsultar.getActionCommand())) {
                try {
                    fechaUtil = formatterDateSQL.parse(textFieldDate.getText());
                    fechaSQL = new java.sql.Date(fechaUtil.getTime());
                } catch (ParseException ex) {
                    System.out.println("Falló el método Parse: " + ex.getMessage());
                }
                try {
                    control.consultarCitas(WIDTH, fechaSQL);
                } catch (SQLException ex) {
                    System.out.println("Fallo SQL: " + ex.getMessage());
                }

            } else if (ae.getActionCommand().equals(botonVolver.getActionCommand())) {
                dispose();
            } else if (ae.getActionCommand().equals(botonConfirmar.getActionCommand())) {

            }
        }
    }

}
