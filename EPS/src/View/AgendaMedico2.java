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
import java.text.ParseException;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author wthoutjc
 */

public class AgendaMedico2 extends JFrame{
    
    private static final long serialVersionUID = 1L;
    private Panel panel;

    public AgendaMedico2() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Agenda Medico 2");
        setSize(new Dimension(575, 660));
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
        private JLabel selecDia;
        private JLabel selecHorario;
        private JLabel selecEspec;
        private JLabel selecTipoCita;
        private JFormattedTextField textFieldCampo1;
        private JFormattedTextField textFieldCampo2;
        private JFormattedTextField textFieldCampo3;
        private JFormattedTextField textFieldDate;
        private JButton botonConfirmar;
        private MaskFormatter formatterDate = null;
        private MaskFormatter formatterCampo = null;

        public Panel() {
            setBorder(BorderFactory.createStrokeBorder(new BasicStroke(7.0f)));
            setPreferredSize(new Dimension(575, 660));
            setBackground(new Color(91, 190, 192));
        }

        public void GenerarInterfaz() {

            titulo = new JLabel("Agenda Medico 2");
            selecDia = new JLabel("Seleccione el día: ");
            selecHorario = new JLabel("Seleccione el horario: ");
            selecEspec = new JLabel("Seleccione especialidad: ");
            selecTipoCita = new JLabel("Seleccione tipo de cita y hora inicial: ");

            try {
                formatterDate = new MaskFormatter("##/##/####");
                textFieldDate = new JFormattedTextField(formatterDate);
                formatterCampo = new MaskFormatter("########");
                textFieldCampo1 = new JFormattedTextField(formatterCampo);
                textFieldCampo2 = new JFormattedTextField(formatterCampo);
                textFieldCampo3 = new JFormattedTextField(formatterCampo);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            botonConfirmar = new JButton("Confirmar");
            /**
             * ***************************************************************************************************
             */
            titulo.setSize(350, 50);
            titulo.setLocation(55, 20);
            titulo.setFont(new Font("Comic Sans", Font.BOLD, 35));
            titulo.setHorizontalAlignment(SwingConstants.LEFT);

            selecDia.setSize(180, 30);
            selecDia.setLocation(55, 120);
            selecDia.setFont(new Font("font", Font.BOLD, 15));
            selecDia.setHorizontalAlignment(SwingConstants.LEFT);

            textFieldDate.setSize(250, 40);
            textFieldDate.setLocation(255, 120);
            textFieldDate.setFont(new Font("font", Font.BOLD, 15));
            textFieldDate.setHorizontalAlignment(SwingConstants.LEFT);

            selecHorario.setSize(180, 30);
            selecHorario.setLocation(55, 220);
            selecHorario.setFont(new Font("font", Font.BOLD, 15));
            selecHorario.setHorizontalAlignment(SwingConstants.LEFT);

            textFieldCampo1.setSize(250, 40);
            textFieldCampo1.setLocation(255, 220);
            textFieldCampo1.setFont(new Font("font", Font.BOLD, 15));
            textFieldCampo1.setHorizontalAlignment(SwingConstants.LEFT);

            selecEspec.setSize(180, 30);
            selecEspec.setLocation(55, 320);
            selecEspec.setFont(new Font("font", Font.BOLD, 15));
            selecEspec.setHorizontalAlignment(SwingConstants.LEFT);

            textFieldCampo2.setSize(180, 30);
            textFieldCampo2.setLocation(255, 320);
            textFieldCampo2.setFont(new Font("font", Font.BOLD, 15));
            textFieldCampo2.setHorizontalAlignment(SwingConstants.LEFT);

            selecTipoCita.setSize(280, 30);
            selecTipoCita.setLocation(55, 420);
            selecTipoCita.setFont(new Font("font", Font.BOLD, 15));
            selecTipoCita.setHorizontalAlignment(SwingConstants.LEFT);

            textFieldCampo3.setSize(180, 30);
            textFieldCampo3.setLocation(355, 420);
            textFieldCampo3.setFont(new Font("font", Font.BOLD, 15));
            textFieldCampo3.setHorizontalAlignment(SwingConstants.LEFT);

            botonConfirmar.setSize(150, 40);
            botonConfirmar.setLocation(55, 520);
            botonConfirmar.setFont(new Font("font", Font.BOLD, 20));
            /**
             * ***************************************************************************************************
             */
            add(titulo);
            add(selecDia);
            add(textFieldDate);
            add(selecEspec);
            add(textFieldCampo1);
            add(selecHorario);
            add(textFieldCampo2);
            add(selecTipoCita);
            add(textFieldCampo3);
            add(botonConfirmar);
        }
    }

}