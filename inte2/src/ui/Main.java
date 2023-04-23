package ui;

import model.GreenSQA;

import java.text.ParseException;
import java.util.Scanner;

public class Main {

    private Scanner reader;
    private GreenSQA controller;

    public Main() {
        this.reader = new Scanner(System.in);
        this.controller = new GreenSQA();
    }

    public void iniciar() throws ParseException {
        int opcion;

        do {
            System.out.println("¿Qué desea hacer?");
            System.out.println("1. Registrar un projecto");
            System.out.println("2. culminar una etapa");
            System.out.println("registrar una capsula");
            System.out.println("4.aprobar una capsula ");
            System.out.println("5.ver numero de capsulas por tipo");
            System.out.println("6.ver si un colaborador ha añadido capsulas");
            System.out.println("7.informar situacion por #");
            System.out.println("8.salir");

            opcion = reader.nextInt();

            switch (opcion) {
                case 1:

                    controller.registrarProyecto();

                    break;
                case 2:
                    controller.culminarEtapa();
                    break;
                case 3:
                    controller.registrarCapsula();

                    break;

                case 4:
                    controller.aprobarCapsula();

                    break;

                case 5:

                    controller.contarTiposDeCapsula();

                    break;

                case 6:

                    controller.capsulasColaborador();

                    break;

                case 7:

                    controller.buscarCapsula();

                    break;

                case 8:

                    System.out.println("adios");

                default:
                    System.out.println("Opción inválida. Por favor, elija una opción válida.");
            }
        } while (opcion != 8);
    }

    public static void main(String[] args) throws ParseException {
        Main programa = new Main();
        programa.iniciar();
    }
}
