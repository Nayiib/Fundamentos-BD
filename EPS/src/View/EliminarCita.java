package View;

import java.awt.BasicStroke;
import java.awt.Color;
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
import java.text.ParseException;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

public class EliminarCita extends JFrame {

    private Panel panel;

    public EliminarCita() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Eliminar Cita");
        setSize(new Dimension(660, 475));
        GenerarPanel();
        setVisible(true);
        setLocationRelativeTo(null);
        pack();
    }

    public void GenerarPanel() {
        panel = new Panel();
        setContentPane(panel);
        panel.setLayout(null);
        panel.GenerarInterfaz();
    }

    public class Panel extends JPanel {

        private JLabel titulo;
        private JLabel idUsuario;
        private JLabel fechaCita;
        private JFormattedTextField textFieldId;
        private JFormattedTextField textFieldDate;
        private JButton botonConsultar;
        private JButton botonConfirmar;
        private MaskFormatter formatterDate = null;
        private MaskFormatter formatterId = null;

        public Panel() {
            setBorder(BorderFactory.createStrokeBorder(new BasicStroke(7.0f)));
            setPreferredSize(new Dimension(660, 475));
            setBackground(new Color(91, 190, 192));
        }

        public void GenerarInterfaz() {
            titulo = new JLabel("ELIMINAR UNA CITA");
            idUsuario = new JLabel("Identificación del usuario");
            fechaCita = new JLabel("Fecha de la cita");
            try {
                formatterDate = new MaskFormatter("##/##/####");
                formatterId = new MaskFormatter("##########");
                textFieldDate = new JFormattedTextField(formatterDate);
                textFieldId = new JFormattedTextField(formatterId);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            botonConsultar = new JButton("Consultar");
            botonConfirmar = new JButton("Confirmar");
            /**
             * ***************************************************************************************************
             */
            titulo.setSize(600, 100);
            titulo.setLocation(20, 20);
            titulo.setFont(new Font("Comic Sans", Font.BOLD, 45));
            titulo.setHorizontalAlignment(SwingConstants.CENTER);

            idUsuario.setSize(330, 70);
            idUsuario.setLocation(10, 150);
            idUsuario.setFont(new Font("font", Font.BOLD, 25));
            idUsuario.setHorizontalAlignment(SwingConstants.CENTER);

            fechaCita.setSize(330, 70);
            fechaCita.setLocation(10, 230);
            fechaCita.setFont(new Font("font", Font.BOLD, 25));
            fechaCita.setHorizontalAlignment(SwingConstants.CENTER);

            textFieldId.setSize(250, 40);
            textFieldId.setLocation(360, 165);
            textFieldId.setFont(new Font("font", Font.BOLD, 25));
            textFieldId.setHorizontalAlignment(SwingConstants.CENTER);

            textFieldDate.setSize(250, 40);
            textFieldDate.setLocation(360, 245);
            textFieldDate.setFont(new Font("font", Font.BOLD, 25));
            textFieldDate.setHorizontalAlignment(SwingConstants.CENTER);

            botonConsultar.setSize(170, 35);
            botonConsultar.setLocation(130, 360);
            botonConsultar.setFont(new Font("font", Font.BOLD, 25));

            botonConfirmar.setSize(170, 35);
            botonConfirmar.setLocation(330, 360);
            botonConfirmar.setFont(new Font("font", Font.BOLD, 25));
            /**
             * ***************************************************************************************************
             */
            add(titulo);
            add(idUsuario);
            add(fechaCita);
            add(textFieldId);
            add(textFieldDate);
            add(botonConsultar);
            add(botonConfirmar);
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(7));
            g.drawLine(0, 135, 660, 135);
            g.drawLine(0, 328, 660, 328);
        }
    }

}
