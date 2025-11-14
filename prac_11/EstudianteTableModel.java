package prac_11;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EstudianteTableModel extends AbstractTableModel {
    private List<Estudiante> estudiantes;
    private final String[] columnNames = {"Matrícula", "Nombre", "Apellido", "Email", "Carrera", "Fecha Nac."};

    public EstudianteTableModel(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    @Override
    public int getRowCount() {
        return estudiantes.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Estudiante estudiante = estudiantes.get(rowIndex);
        switch (columnIndex) {
            case 0: return estudiante.getMatricula();
            case 1: return estudiante.getNombre();
            case 2: return estudiante.getApellido();
            case 3: return estudiante.getEmail();
            case 4: return estudiante.getCarrera();
            case 5: return estudiante.getFechaNacimiento();
            default: return null;
        }
    }

    public void setEstudiantes(List<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
        fireTableDataChanged();
    }

    public Estudiante getEstudianteAt(int rowIndex) {
        return estudiantes.get(rowIndex);
    }
}