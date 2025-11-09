package prac_4;
import java.util.ArrayList;

public class Concesionaria273 {
    ArrayList<CamionG> camiones;
    ArrayList<AutoG> autos;
    ArrayList<MotocicletaG> motocicletas;

    public Concesionaria273() {
        this.camiones = new ArrayList<>();
        this.autos = new ArrayList<>();
        this.motocicletas = new ArrayList<>();
    }

    public void addAuto(AutoG auto) {
        this.autos.add(auto);
    }

    public void addMoto(MotocicletaG moto) {
        this.motocicletas.add(moto);
    }
    public void addCamion(CamionG camion) {
        this.camiones.add(camion);
    }

    public void getCamiones() {
        System.out.println("=====Camiones=====");
        for (CamionG camion : this.camiones) {
            System.out.println(camion.toString());
        }
    }
    public void getAutos() {
        System.out.println("=====Autos=====");
        for (AutoG auto : this.autos) {
            System.out.println(auto.toString());
        }
    }
    public void getMotocicletas() {
        System.out.println("=====Motocicletas=====");
        for (MotocicletaG motocicleta : this.motocicletas) {
            System.out.println(motocicleta.toString());
        }
    }
}
