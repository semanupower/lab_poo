package prac_7;

import java.util.ArrayList;

public class SistemaBancoMG {
    ArrayList<Usuario> usuarios;

    public SistemaBancoMG() {
        usuarios = new ArrayList<>();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }
    public void buscarUsuarios(String matricula) {
        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                System.out.println("Usuario " + usuario.getNombre() + " " + usuario.getApellido() + " encontrado.");
                return;
            }
        }
        System.out.println("Usuario no encontrado.");
    }

    public void addUsuario(String nombre, String apellido, String matricula, double deposito) {
        Usuario usuario = new Usuario(nombre, apellido);
        usuario.setMatricula(matricula);
        usuario.depositar(deposito);
        usuarios.add(usuario);
    }


}
