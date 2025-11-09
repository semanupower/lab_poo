package prac_2;

public class EstudianteMG {
    int matricula;
    String nombre;
    int edad;
    String carrera;
    int semestreActual;

    public EstudianteMG(int mat, String name, int age, String car, int semester) {
        this.matricula = mat;
        this.nombre = name;
        this.edad = age;
        this.carrera = car;
        this.semestreActual = semester;
    }

    public void estudiar()
    {
        System.out.println("Estudiando...\n");
    }

    public void dormir()
    {
        System.out.println("zzzzzzzzz....\n");
    }

    public void hacerTarea(){
        System.out.println("Haciendo tarea....\n");
    }

    public void iraUniversidad() {
        System.out.println("Yendo al transporte...\n");
    }

    public void comer() {
        System.out.println("Comiendo...\n");
    }
}
