package model;

import java.util.Date;

public class Proyecto {
    private String name;
    private String nombreDelCliente;
    private Date fechaDeInicio;
    private Date fechaDeFinal;
    private Double presupuesto;
    private String nombreGerente;
    private int numeroCelular;

    public Proyecto(String name, String nombreDelCiente, Date fechaDeInicio, Date fechaDeFin, Double presupuesto,
            String nombreGerente, int numeroCelular) {

        this.name = name;
        this.nombreDelCliente = nombreDelCiente;
        this.fechaDeInicio = fechaDeInicio;
        this.fechaDeFinal = fechaDeFin;
        this.presupuesto = presupuesto;
        this.nombreGerente = nombreGerente;
        this.numeroCelular = numeroCelular;

    }

    public String getName() {

        return name;

    }

    public String getNombreDelCliente() {

        return nombreDelCliente;

    }

    public Date getFechaDeInicio() {

        return fechaDeInicio;

    }

    public Date getFechaDeFin() {

        return fechaDeFinal;

    }

    public Double getPresupuesto() {

        return presupuesto;
    }

}
