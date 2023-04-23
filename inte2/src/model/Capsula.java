package model;

import java.util.Date;

public class Capsula {

    private int id;
    private String descripcion;
    private String tipo;
    private String nombreColaborador;
    private String cargoColaborador;
    private String aprendizaje;
    private String hashtag;

    public Capsula(int id, String descripcion, String tipo, String nombreColaborador, String cargoColaborador,
            String aprendizaje, String hashtag) {

        this.id = id;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.nombreColaborador = nombreColaborador;
        this.cargoColaborador = cargoColaborador;
        this.aprendizaje = aprendizaje;
        this.hashtag = hashtag;

    }

    public int getId() {

        return id;

    }

    public String getDescripcion() {

        return descripcion;
    }

    public String getTipo() {

        return tipo;

    }

    public String getNombreColaborador() {

        return nombreColaborador;

    }

    public String getCargoColaborador() {

        return cargoColaborador;
    }

    public void setAprobada(boolean b) {
    }

    public void setFechaAprobacion(Date date)

    {
    }

    public String getFechaAprobacion() {
        return null;
    }

    public String getHashtag() {
        return hashtag;
    }

}
