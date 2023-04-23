package model;

import java.util.Date;

public class Etapa {

    private Date fechaDeInicioReal;
    private Date fechaDeFinalReal;
    private boolean aprobada;
    private boolean estado;

    public Etapa(Date fechaDeInicioReal, Date fechaDeFinalReal, boolean aprobada, boolean estado) {

        this.fechaDeInicioReal = fechaDeInicioReal;
        this.fechaDeFinalReal = fechaDeFinalReal;
        this.aprobada = aprobada;
        this.estado = estado;

    }

}
