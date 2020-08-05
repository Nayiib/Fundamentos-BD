package View;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


/**
 *
 * @author wthoutjc
 */

public class AgendaMedico extends JFrame {

    private static final long serialVersionUID = 1L;
    private Panel panel;

    public AgendaMedico() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Agenda Medico 2");
        setSize(new Dimension(400, 300));
        GenerarPanel();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void GenerarPanel() {
        panel = new Panel();
        setContentPane(panel);
        panel.setLayout(null);
        panel.GenerarInterfaz();
    }

    public class Panel extends JPanel {

        /**
         *
         */
        private static final long serialVersionUID = 1L;
        /**
         *
         */
        private JLabel titulo;
        private JButton botonCrearProgramacion;

        public Panel() {
            setBorder(BorderFactory.createStrokeBorder(new BasicStroke(7.0f)));
            setPreferredSize(new Dimension(400, 300));
            setBackground(new Color(91, 190, 192));
        }

        public void GenerarInterfaz() {

            titulo = new JLabel("Agenda Medico");
            botonCrearProgramacion = new JButton("Crear programación");

            titulo.setSize(200, 50);
            titulo.setLocation(55, 20);
            titulo.setFont(new Font("Comic Sans", Font.BOLD, 25));
            titulo.setHorizontalAlignment(SwingConstants.LEFT);

            botonCrearProgramacion.setSize(150, 40);
            botonCrearProgramacion.setLocation(55, 120);
            botonCrearProgramacion.setFont(new Font("font", Font.BOLD, 20));

            add(titulo);
            add(botonCrearProgramacion);

        }

    }
    
}