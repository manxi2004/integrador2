package model;

public class Gerente {
    private String nombre;
    private int ultimaCapsulaAprobada;

    public Gerente(String nombre) {
        this.nombre = nombre;
        this.ultimaCapsulaAprobada = 0;
    }

    public boolean aprobarCapsula(Proyecto proyecto, int idCapsula) {
        Capsula capsula = proyecto.buscarCapsula(idCapsula);
        if (capsula == null) {
            return false; // La cápsula no existe
        } else if (capsula.estaAprobada()) {
            return false; // La cápsula ya ha sido aprobada
        } else if (idCapsula <= ultimaCapsulaAprobada) {
            return false; // La cápsula ya ha sido aprobada anteriormente
        } else {
            capsula.aprobar();
            ultimaCapsulaAprobada = idCapsula;
            return true;
        }
    }

    public boolean publicarCapsula(Proyecto proyecto, int idCapsula) {
        Capsula capsula = proyecto.buscarCapsula(idCapsula);
        if (capsula == null) {
            return false; // La cápsula no existe
        } else if (!capsula.estaAprobada()) {
            return false; // La cápsula no ha sido aprobada
        } else if (capsula.estaPublicada()) {
            return false; // La cápsula ya ha sido publicada
        } else {
            capsula.publicar();
            return true;
        }
    }
}
