package model;

public class Proyecto {
    private static int contadorEtapa = 0;
    private static int contadorCapsula = 0;

    private String nombre;
    private Gerente gerente;
    private Etapa[] etapas;
    private Capsula[] capsulas;

    public Proyecto(String nombre, Gerente gerente) {
        this.nombre = nombre;
        this.gerente = gerente;
        this.etapas = new Etapa[10];
        this.capsulas = new Capsula[100];
    }

    public Etapa crearEtapa(String nombre) {
        Etapa etapa = new Etapa(contadorEtapa++, nombre);
        etapas[etapa.getId()] = etapa;
        return etapa;
    }

    public boolean culminarEtapa(int id) {
        Etapa etapa = buscarEtapa(id);
        if (etapa == null) {
            return false;
        }
        etapa.culminar();
        return true;
    }

    public boolean registrarCapsula(Capsula capsula, int idEtapa) {
        Etapa etapa = buscarEtapa(idEtapa);
        if (etapa == null) {
            return false;
        }
        capsula.setId(contadorCapsula++);
        etapa.agregarCapsula(capsula);
        capsulas[capsula.getId()] = capsula;
        return true;
    }

    public boolean aprobarCapsula(int id) {
        Capsula capsula = buscarCapsula(id);
        if (capsula == null) {
            return false;
        }
        gerente.aprobarCapsula(this, capsula.getId());
        return true;
    }

    public boolean publicarCapsula(int id) {
        Capsula capsula = buscarCapsula(id);
        if (capsula == null) {
            return false;
        }
        gerente.publicarCapsula(this, capsula.getId());
        return true;
    }

    private Etapa buscarEtapa(int id) {
        if (id >= etapas.length || etapas[id] == null) {
            return null;
        }
        return etapas[id];
    }

    public Capsula buscarCapsula(int id) {
        for (Capsula capsula : capsulas) {
            if (capsula != null && capsula.getId() == id) {
                return capsula;
            }
        }
        return null;
    }

    public String getNombre() {
        return nombre;
    }
}
