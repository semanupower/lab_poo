package prac_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CampoValidado extends JTextField {
    private String tipoValidacion;
    private boolean esObligatorio;
    private Color colorOriginal;
    private JLabel labelError;

    public CampoValidado(String tipoValidacion, boolean esObligatorio) {
        super(20);
        this.tipoValidacion = tipoValidacion;
        this.esObligatorio = esObligatorio;
        this.colorOriginal = getBackground();

        setFont(new Font("SansSerif", Font.PLAIN, 14));
        configurarEventos();
    }

    public CampoValidado(String tipoValidacion) {
        this(tipoValidacion, true);
    }

    private void configurarEventos() {
        addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                validarCampo();
            }
        });

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (getBackground() != colorOriginal) {
                    setBackground(colorOriginal);
                }
            }
        });
    }

    public boolean validarCampo() {
        String texto = getText().trim();

        if (esObligatorio && texto.isEmpty()) {
            setBackground(new Color(255, 220, 220));
            return false;
        }

        switch (tipoValidacion) {
            case "matricula":
                if (!texto.matches("\\d{8}")) {
                    setBackground(new Color(255, 220, 220));
                    return false;
                }
                break;

            case "email":
                if (!texto.isEmpty() && !texto.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
                    setBackground(new Color(255, 220, 220));
                    return false;
                }
                break;

            case "nombre":
            case "texto":
                if (texto.length() == 1) {
                    setBackground(new Color(255, 220, 220));
                    return false;
                }
                break;
        }

        if (!texto.isEmpty()) {
            setBackground(new Color(220, 255, 220));
        } else {
            setBackground(colorOriginal);
        }
        return true;
    }

    public void limpiar() {
        setText("");
        setBackground(colorOriginal);
    }

    public void setLabelError(JLabel labelError) {
        this.labelError = labelError;
    }
}