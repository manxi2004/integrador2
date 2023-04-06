package model;

public class Etapa {
    private static int ID_GLOBAL = 1;
    private int id;
    private String nombre;
    private boolean culminada;
    private Capsula[] capsulas;
    private int cantidadCapsulas;

    public Etapa(int contador, String nombre) {
        this.id = ID_GLOBAL;
        ID_GLOBAL++;
        this.nombre = nombre;
        this.culminada = false;
        this.capsulas = new Capsula[10];
        this.cantidadCapsulas = 0;
    }

    public boolean registrarCapsula(Capsula capsula) {
        if (culminada) {
            return false;
        }
        if (cantidadCapsulas >= 10) {
            return false;
        }
        capsulas[cantidadCapsulas] = capsula;
        cantidadCapsulas++;
        return true;
    }

    public void culminar() {
        culminada = true;
    }

    public int getId() {
        return id;
    }

    public Capsula[] getCapsulas() {
        return capsulas;
    }

    public boolean agregarCapsula(Capsula capsula) {
        if (culminada) {
            return false;
        }
        if (cantidadCapsulas >= 10) {
            return false;
        }
        boolean capsulaAgregada = false;
        for (int i = 0; i < capsulas.length; i++) {
            if (capsulas[i] == null) {
                capsulas[i] = capsula;
                cantidadCapsulas++;
                capsulaAgregada = true;
                break;
            }
        }
        return capsulaAgregada;
    }
    
}
