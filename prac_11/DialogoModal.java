package prac_11;

import javax.swing.*;
import java.awt.*;

public class DialogoModal extends JDialog {
    private boolean confirmado;

    public DialogoModal(Frame parent, String titulo, String mensaje) {
        super(parent, titulo, true);
        this.confirmado = false;

        inicializarComponentes(mensaje);
        configurarVentana();
    }

    private void inicializarComponentes(String mensaje) {
        Container contenido = getContentPane();
        contenido.setLayout(new BorderLayout());
        ((JComponent) contenido).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        JLabel labelMensaje = new JLabel(mensaje);
        labelMensaje.setFont(new Font("SansSerif", Font.PLAIN, 14));
        labelMensaje.setHorizontalAlignment(SwingConstants.CENTER);
        contenido.add(labelMensaje, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnConfirmar = new JButton("Confirmar");
        JButton btnCancelar = new JButton("Cancelar");

        
        estilizarBoton(btnConfirmar, new Color(46, 204, 113)); 
        estilizarBoton(btnCancelar, new Color(231, 76, 60));   

        btnConfirmar.addActionListener(e -> {
            confirmado = true;
            dispose();
        });

        btnCancelar.addActionListener(e -> {
            confirmado = false;
            dispose();
        });

        panelBotones.add(btnConfirmar);
        panelBotones.add(btnCancelar);

        contenido.add(panelBotones, BorderLayout.SOUTH);
    }

    private void estilizarBoton(JButton boton, Color color) {
        boton.setBackground(color);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("SansSerif", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

        
        boton.setOpaque(true);
        boton.setContentAreaFilled(true);
    }

    private void configurarVentana() {
        setSize(400, 200);
        setLocationRelativeTo(getParent());
        setResizable(false);

        
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public boolean isConfirmado() {
        return confirmado;
    }

    public static boolean mostrarConfirmacion(Component parent, String titulo, String mensaje) {
        Frame framePadre = null;
        if (parent != null) {
            Window ventanaPadre = SwingUtilities.getWindowAncestor(parent);
            if (ventanaPadre instanceof Frame) {
                framePadre = (Frame) ventanaPadre;
            }
        }

        DialogoModal dialogo = new DialogoModal(framePadre, titulo, mensaje);
        dialogo.setVisible(true);
        return dialogo.isConfirmado();
    }
}