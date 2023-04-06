package model;

public class Capsula {
    private int id;
    private String titulo;
    private String contenido;
    private boolean aprobada;
    private boolean publicada;

    public Capsula(int id, String titulo, String contenido) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.aprobada = false;
        this.publicada = false;
    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public boolean estaAprobada() {
        return aprobada;
    }

    public boolean estaPublicada() {
        return publicada;
    }

    public void aprobar() {
        aprobada = true;
    }

    public void publicar() {
        publicada = true;
    }

    public void setId(int id) {
        this.id = id;
    }
}
