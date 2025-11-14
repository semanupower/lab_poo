package prac_11;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BotonEstilizado extends JButton {
    private Color colorNormal;
    private Color colorHover;
    private Color colorPresionado;

    public BotonEstilizado(String texto) {
        super(texto);

        // Colores del gradiente
        colorNormal = new Color(52, 152, 219);    // Azul
        colorHover = new Color(41, 128, 185);     // Azul oscuro
        colorPresionado = new Color(44, 62, 80);  // Azul muy oscuro

        configurarApariencia();
        configurarEventos();
    }

    public BotonEstilizado(String texto, Color colorNormal, Color colorHover) {
        super(texto);
        this.colorNormal = colorNormal;
        this.colorHover = colorHover;
        this.colorPresionado = colorHover.darker();

        configurarApariencia();
        configurarEventos();
    }

    private void configurarApariencia() {
        setFont(new Font("SansSerif", Font.BOLD, 14));
        setForeground(Color.WHITE);
        setBorder(new EmptyBorder(12, 25, 12, 25));
        setFocusPainted(false);
        setContentAreaFilled(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void configurarEventos() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(colorHover);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(colorNormal);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                setBackground(colorPresionado);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                setBackground(colorHover);
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Suavizado
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Fondo con gradiente
        Color colorActual = getBackground();
        if (colorActual == null) {
            colorActual = colorNormal;
        }

        GradientPaint gradient = new GradientPaint(
                0, 0, colorActual,
                0, getHeight(), colorActual.darker()
        );

        g2.setPaint(gradient);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);

        // Sombra
        g2.setColor(new Color(0, 0, 0, 50));
        g2.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);

        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    public void setBackground(Color bg) {
        super.setBackground(bg);
        repaint();
    }

    public void setTema(Color normal, Color hover, Color presionado) {
        this.colorNormal = normal;
        this.colorHover = hover;
        this.colorPresionado = presionado;
        setBackground(colorNormal);
    }
}
