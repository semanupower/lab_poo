package prac_11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaEstudiantilM73 extends JFrame { // CORRECCIÓN: Nombre de clase debe coincidir
    private List<Estudiante> estudiantes;
    private JTable tablaEstudiantes;
    private EstudianteTableModel tableModel;
    private FormularioEstudiante formulario;
    private JTextField campoBusqueda;

    // CORRECCIÓN: El constructor debe tener el mismo nombre que la clase
    public SistemaEstudiantilM73() {
        super("Sistema Estudiantil - Gestión de Estudiantes");
        estudiantes = new ArrayList<>();
        inicializarComponentes();
        cargarDatosEjemplo();
    }

    private void inicializarComponentes() {
        // Configurar ventana principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(1000, 700));

        // Crear menú personalizado
        crearMenu();

        // Panel principal dividido
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setDividerLocation(400);

        // Formulario a la izquierda
        formulario = new FormularioEstudiante();
        splitPane.setLeftComponent(formulario);

        // Tabla a la derecha
        JPanel panelTabla = crearPanelTabla();
        splitPane.setRightComponent(panelTabla);

        add(splitPane, BorderLayout.CENTER);

        // Configurar eventos
        configurarEventos();
    }

    private void crearMenu() {
        JMenuBar menuBar = new JMenuBar();

        // Menú Archivo
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem itemNuevo = new JMenuItem("Nuevo Estudiante");
        JMenuItem itemSalir = new JMenuItem("Salir");

        menuArchivo.add(itemNuevo);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);

        // Menú Estudiantes
        JMenu menuEstudiantes = new JMenu("Estudiantes");
        JMenuItem itemListar = new JMenuItem("Listar Todos");
        JMenuItem itemReportes = new JMenuItem("Generar Reportes");

        menuEstudiantes.add(itemListar);
        menuEstudiantes.add(itemReportes);

        // Menú Ayuda
        JMenu menuAyuda = new JMenu("Ayuda");
        JMenuItem itemAcerca = new JMenuItem("Acerca de...");
        menuAyuda.add(itemAcerca);

        menuBar.add(menuArchivo);
        menuBar.add(menuEstudiantes);
        menuBar.add(menuAyuda);

        setJMenuBar(menuBar);

        // Eventos del menú
        itemNuevo.addActionListener(e -> formulario.limpiarFormulario());
        itemSalir.addActionListener(e -> System.exit(0));
        itemListar.addActionListener(e -> actualizarTabla());
    }

    private JPanel crearPanelTabla() {
        JPanel panel = new JPanel(new BorderLayout());

        // Panel de búsqueda
        JPanel panelBusqueda = new JPanel(new FlowLayout());
        panelBusqueda.add(new JLabel("Buscar:"));
        campoBusqueda = new JTextField(20);
        panelBusqueda.add(campoBusqueda);

        // CORRECCIÓN: Usar JButton si BotonEstilizado no existe
        JButton btnBuscar = new JButton("Buscar");
        estilizarBoton(btnBuscar);
        panelBusqueda.add(btnBuscar);

        panel.add(panelBusqueda, BorderLayout.NORTH);

        // Tabla de estudiantes
        tableModel = new EstudianteTableModel(estudiantes);
        tablaEstudiantes = new JTable(tableModel);

        // Personalizar tabla
        tablaEstudiantes.setRowHeight(30);
        tablaEstudiantes.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 14));

        JScrollPane scrollPane = new JScrollPane(tablaEstudiantes);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Panel de acciones de tabla
        JPanel panelAcciones = new JPanel(new FlowLayout());

        // CORRECCIÓN: Usar JButton si BotonEstilizado no existe
        JButton btnEditar = new JButton("Editar Seleccionado");
        JButton btnEliminar = new JButton("Eliminar Seleccionado");

        estilizarBoton(btnEditar);
        estilizarBoton(btnEliminar);

        panelAcciones.add(btnEditar);
        panelAcciones.add(btnEliminar);

        // CORRECCIÓN: Agregar eventos a los botones
        btnEditar.addActionListener(e -> editarEstudianteSeleccionado());
        btnEliminar.addActionListener(e -> eliminarEstudianteSeleccionado());

        btnBuscar.addActionListener(e -> buscarEstudiantes(campoBusqueda.getText()));

        panel.add(panelAcciones, BorderLayout.SOUTH);

        return panel;
    }

    // CORRECCIÓN: Método para estilizar botones
    private void estilizarBoton(JButton boton) {
        boton.setBackground(new Color(52, 152, 219));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("SansSerif", Font.BOLD, 12));
        boton.setFocusPainted(false);
        boton.setBorder(BorderFactory.createEmptyBorder(8, 15, 8, 15));
    }

    private void configurarEventos() {
        // Evento para guardar estudiante desde el formulario
        formulario.setGuardarListener(e -> guardarEstudiante());

        // Evento para buscar estudiantes
        campoBusqueda.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                buscarEstudiantes(campoBusqueda.getText());
            }
        });

        // Evento doble clic en tabla para editar
        tablaEstudiantes.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    editarEstudianteSeleccionado();
                }
            }
        });
    }

    private void guardarEstudiante() {
        try {
            Estudiante estudiante = formulario.obtenerEstudiante();

            if (formulario.isEditando()) {
                // Actualizar estudiante existente
                int index = estudiantes.indexOf(estudiante);
                if (index != -1) {
                    estudiantes.set(index, estudiante);
                }
            } else {
                // Agregar nuevo estudiante
                estudiantes.add(estudiante);
            }

            actualizarTabla();
            formulario.limpiarFormulario();

            JOptionPane.showMessageDialog(this,
                    "Estudiante " + (formulario.isEditando() ? "actualizado" : "guardado") + " correctamente",
                    "Éxito", JOptionPane.INFORMATION_MESSAGE);

        } catch (IllegalArgumentException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void editarEstudianteSeleccionado() {
        int fila = tablaEstudiantes.getSelectedRow();
        if (fila >= 0) {
            Estudiante estudiante = estudiantes.get(fila);
            formulario.cargarEstudiante(estudiante);
        } else {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un estudiante para editar",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    // CORRECCIÓN: Método para eliminar estudiante
    private void eliminarEstudianteSeleccionado() {
        int fila = tablaEstudiantes.getSelectedRow();
        if (fila >= 0) {
            Estudiante estudiante = estudiantes.get(fila);
            int confirmacion = JOptionPane.showConfirmDialog(this,
                    "¿Está seguro de eliminar al estudiante: " + estudiante.getNombre() + " " + estudiante.getApellido() + "?",
                    "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                estudiantes.remove(fila);
                actualizarTabla();
                JOptionPane.showMessageDialog(this, "Estudiante eliminado correctamente");
            }
        } else {
            JOptionPane.showMessageDialog(this,
                    "Seleccione un estudiante para eliminar",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void buscarEstudiantes(String texto) {
        if (texto.isEmpty()) {
            tableModel.setEstudiantes(estudiantes);
        } else {
            List<Estudiante> resultados = new ArrayList<>();
            String textoLower = texto.toLowerCase();

            for (Estudiante e : estudiantes) {
                if (e.getNombre().toLowerCase().contains(textoLower) ||
                        e.getApellido().toLowerCase().contains(textoLower) ||
                        e.getMatricula().toLowerCase().contains(textoLower) ||
                        e.getCarrera().toLowerCase().contains(textoLower)) {
                    resultados.add(e);
                }
            }
            tableModel.setEstudiantes(resultados);
        }
    }

    private void actualizarTabla() {
        tableModel.fireTableDataChanged();
    }

    private void cargarDatosEjemplo() {
        estudiantes.add(new Estudiante("20230001", "Ana", "García", "ana.garcia@universidad.edu", "Ingeniería", "2000-05-15"));
        estudiantes.add(new Estudiante("20230002", "Carlos", "López", "carlos.lopez@universidad.edu", "Medicina", "1999-08-22"));
        estudiantes.add(new Estudiante("20230003", "María", "Rodríguez", "maria.rodriguez@universidad.edu", "Derecho", "2001-02-10"));
        actualizarTabla();
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new SistemaEstudiantilM73().setVisible(true); // CORRECCIÓN: Usar el nombre correcto
        });
    }
}