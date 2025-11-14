package prac_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FormularioEstudiante extends JPanel {
    private CampoValidado campoMatricula;
    private CampoValidado campoNombre;
    private CampoValidado campoApellido;
    private CampoValidado campoEmail;
    private JComboBox<String> comboCarrera;
    private CampoValidado campoFechaNacimiento;
    private JButton btnGuardar;
    private JButton btnLimpiar;

    private JLabel labelErrorMatricula;
    private JLabel labelErrorNombre;
    private JLabel labelErrorApellido;
    private JLabel labelErrorEmail;
    private JLabel labelErrorFecha;

    private boolean editando;
    private String matriculaOriginal;

    public FormularioEstudiante() {
        editando = false;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Título
        JLabel titulo = new JLabel("Formulario de Estudiante");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 18));
        titulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 20, 0));
        add(titulo, BorderLayout.NORTH);

        // Panel de campos
        JPanel panelCampos = new JPanel();
        panelCampos.setLayout(new GridLayout(7, 1, 10, 5)); // CORRECCIÓN: 7 filas para incluir errores

        // CORRECCIÓN: Crear campos con parámetros correctos
        campoMatricula = new CampoValidado("matricula", true);
        campoNombre = new CampoValidado("nombre", true);
        campoApellido = new CampoValidado("texto", true);
        campoEmail = new CampoValidado("email", true);
        campoFechaNacimiento = new CampoValidado("fecha", true);

        // CORRECCIÓN: Configurar etiquetas de error
        labelErrorMatricula = new JLabel(" ");
        labelErrorNombre = new JLabel(" ");
        labelErrorApellido = new JLabel(" ");
        labelErrorEmail = new JLabel(" ");
        labelErrorFecha = new JLabel(" ");

        // Estilizar etiquetas de error
        estilizarLabelError(labelErrorMatricula);
        estilizarLabelError(labelErrorNombre);
        estilizarLabelError(labelErrorApellido);
        estilizarLabelError(labelErrorEmail);
        estilizarLabelError(labelErrorFecha);

        // CORRECCIÓN: Vincular etiquetas de error con campos
        campoMatricula.setLabelError(labelErrorMatricula);
        campoNombre.setLabelError(labelErrorNombre);
        campoApellido.setLabelError(labelErrorApellido);
        campoEmail.setLabelError(labelErrorEmail);
        campoFechaNacimiento.setLabelError(labelErrorFecha);

        // Combo box para carrera
        JPanel panelCarrera = new JPanel(new BorderLayout());
        panelCarrera.add(new JLabel("Carrera *"), BorderLayout.NORTH);
        String[] carreras = {"", "Ingeniería", "Medicina", "Derecho", "Administración", "Arquitectura"};
        comboCarrera = new JComboBox<>(carreras);
        comboCarrera.setFont(new Font("SansSerif", Font.PLAIN, 14));
        panelCarrera.add(comboCarrera, BorderLayout.CENTER);

        // CORRECCIÓN: Crear paneles individuales para cada campo con su etiqueta
        panelCampos.add(crearPanelCampo("Matrícula *", campoMatricula, labelErrorMatricula));
        panelCampos.add(crearPanelCampo("Nombre *", campoNombre, labelErrorNombre));
        panelCampos.add(crearPanelCampo("Apellido *", campoApellido, labelErrorApellido));
        panelCampos.add(crearPanelCampo("Email *", campoEmail, labelErrorEmail));
        panelCampos.add(panelCarrera);
        panelCampos.add(crearPanelCampo("Fecha de Nacimiento *", campoFechaNacimiento, labelErrorFecha));

        add(panelCampos, BorderLayout.CENTER);

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout());
        btnGuardar = new JButton("Guardar Estudiante");
        btnLimpiar = new JButton("Limpiar Formulario");

        estilizarBoton(btnGuardar);
        estilizarBoton(btnLimpiar);

        panelBotones.add(btnGuardar);
        panelBotones.add(btnLimpiar);

        add(panelBotones, BorderLayout.SOUTH);

        // Eventos
        btnLimpiar.addActionListener(e -> limpiarFormulario());
    }

    // CORRECCIÓN: Método para crear paneles individuales de campos
    private JPanel crearPanelCampo(String etiqueta, CampoValidado campo, JLabel errorLabel) {
        JPanel panelCampo = new JPanel(new BorderLayout());

        // Etiqueta del campo
        JLabel label = new JLabel(etiqueta);
        label.setFont(new Font("SansSerif", Font.BOLD, 12));
        panelCampo.add(label, BorderLayout.NORTH);

        // Campo de texto
        panelCampo.add(campo, BorderLayout.CENTER);

        // Etiqueta de error
        panelCampo.add(errorLabel, BorderLayout.SOUTH);

        return panelCampo;
    }

    private void estilizarLabelError(JLabel label) {
        label.setForeground(Color.RED);
        label.setFont(new Font("SansSerif", Font.PLAIN, 11));
        label.setPreferredSize(new Dimension(200, 15));
    }

    private void estilizarBoton(JButton boton) {
        boton.setBackground(new Color(52, 152, 219));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("SansSerif", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    }

    public void setGuardarListener(ActionListener listener) {
        btnGuardar.addActionListener(listener);
    }

    public Estudiante obtenerEstudiante() {
        // CORRECCIÓN: Validar todos los campos antes de crear el estudiante
        boolean matriculaValida = campoMatricula.validarCampo();
        boolean nombreValido = campoNombre.validarCampo();
        boolean apellidoValido = campoApellido.validarCampo();
        boolean emailValido = campoEmail.validarCampo();
        boolean fechaValida = campoFechaNacimiento.validarCampo();
        boolean carreraValida = comboCarrera.getSelectedIndex() != 0;

        // Verificar si hay errores
        if (!matriculaValida) throw new IllegalArgumentException("Matrícula inválida");
        if (!nombreValido) throw new IllegalArgumentException("Nombre inválido");
        if (!apellidoValido) throw new IllegalArgumentException("Apellido inválido");
        if (!emailValido) throw new IllegalArgumentException("Email inválido");
        if (!carreraValida) throw new IllegalArgumentException("Seleccione una carrera");
        if (!fechaValida) throw new IllegalArgumentException("Fecha de nacimiento inválida");

        return new Estudiante(
                campoMatricula.getText(), // CORRECCIÓN: getText() para JTextField
                campoNombre.getText(),
                campoApellido.getText(),
                comboCarrera.getSelectedItem().toString()
        );
    }

    public void cargarEstudiante(Estudiante estudiante) {
        campoMatricula.setText(estudiante.getMatricula());
        campoNombre.setText(estudiante.getNombre());
        campoApellido.setText(estudiante.getApellido());
        comboCarrera.setSelectedItem(estudiante.getCarrera());

        campoMatricula.validarCampo();
        campoNombre.validarCampo();
        campoApellido.validarCampo();
        campoEmail.validarCampo();
        campoFechaNacimiento.validarCampo();

        editando = true;
        matriculaOriginal = estudiante.getMatricula();
        btnGuardar.setText("Actualizar Estudiante");

        // Deshabilitar matrícula en modo edición
        campoMatricula.setEnabled(false);
    }

    public void limpiarFormulario() {
        campoMatricula.limpiar();
        campoNombre.limpiar();
        campoApellido.limpiar();
        campoEmail.limpiar();
        comboCarrera.setSelectedIndex(0);
        campoFechaNacimiento.limpiar();

        editando = false;
        matriculaOriginal = null;
        btnGuardar.setText("Guardar Estudiante");
        campoMatricula.setEnabled(true);
    }

    // CORRECCIÓN: Método para validar todo el formulario
    public boolean validarFormulario() {
        boolean matriculaValida = campoMatricula.validarCampo();
        boolean nombreValido = campoNombre.validarCampo();
        boolean apellidoValido = campoApellido.validarCampo();
        boolean emailValido = campoEmail.validarCampo();
        boolean fechaValida = campoFechaNacimiento.validarCampo();
        boolean carreraValida = comboCarrera.getSelectedIndex() != 0;

        return matriculaValida && nombreValido && apellidoValido &&
                emailValido && fechaValida && carreraValida;
    }

    public boolean isEditando() {
        return editando;
    }

    public String getMatriculaOriginal() {
        return matriculaOriginal;
    }
}