package model;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class GreenSQA {
    public static final int SIZE = 3000;
    private Capsula[] capsulas;

    Scanner reader = new Scanner(System.in);
    public static final int SIZEE = 60;
    private Etapa[] etapas;

    public static final int SIZEEP = 10;
    private Proyecto[] proyectos;

    private String[] tiposCapsula;
    private String[] hashtagsCapsula;
    private String[] nombresColaboradores;

    public GreenSQA() {

        capsulas = new Capsula[SIZE];
        etapas = new Etapa[SIZEE];
        proyectos = new Proyecto[SIZEEP];
        tiposCapsula = new String[SIZE];
        hashtagsCapsula = new String[SIZE];
        nombresColaboradores = new String[SIZE];

    }

    public void anadirProyecto(String name, String nombreDelCiente, Date fechaDeInicio, Date fechaDeFin,
            Double presupuesto,
            String nombreGerente, int numeroCelular) {

        int pos = getFirstValidPosition();

        Proyecto proyecto = new Proyecto(name, nombreDelCiente, fechaDeInicio, fechaDeFin, presupuesto, nombreGerente,
                numeroCelular);

        if (pos != -1) {
            proyectos[pos] = proyecto;
        }
    }

    public int getFirstValidPosition() {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < SIZEEP && !isFound; i++) {
            if (proyectos[i] == null) {
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }

    public void registrarProyecto() throws ParseException {
        String name = "", nombreDelCliente = "";
        String fechaDeInicio;
        String fechaDeFin;
        Double presupuesto;
        String nombreGerente = "";
        int numeroCelular;

        System.out.println("Digite el título del libro a añadir:");
        name = reader.next();

        System.out.println("Digite el nombre del cliente:");
        nombreDelCliente = reader.next();
        System.out.println("Digite la fecha de inicio del proyecto:");
        fechaDeInicio = reader.nextLine();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaDeInicioProyecto = formato.parse(fechaDeInicio);
        System.out.println("Digite la fecha estipulada para terminar el proyecto:");
        fechaDeFin = reader.nextLine();
        Date fechaEstipulada = formato.parse(fechaDeFin);

        System.out.println("Digita el nombre del gerente a cargo");
        nombreGerente = reader.next();
        System.out.println("Digite su numero de celular");
        numeroCelular = reader.nextInt();

        System.out.println("Digite el presupuesto del proyecto");
        presupuesto = reader.nextDouble();

        anadirProyecto(name, nombreDelCliente, fechaDeInicioProyecto, fechaDeInicioProyecto, presupuesto, nombreGerente,
                numeroCelular);

        System.out.println("proyecto creado con exito.");
    }

    public void culminarEtapa() {
        int proyectoSeleccionado = 0;
        int etapaSeleccionada = 0;

        System.out.println("A las etapas de cuál proyecto deseas ingresar? (1-10)");
        proyectoSeleccionado = reader.nextInt();

        if (proyectoSeleccionado < 1 || proyectoSeleccionado > 10) {
            System.out.println("Opción inválida. Intente de nuevo.");
            return;
        }

        System.out.println("¿Cuál etapa deseas terminar? (1-6)");
        etapaSeleccionada = reader.nextInt();

        if (etapaSeleccionada < 1 || etapaSeleccionada > 6) {
            System.out.println("Opción inválida. Intente de nuevo.");
            return;
        }

        int indiceInicial = (proyectoSeleccionado - 1) * 6;
        int indiceFinal = indiceInicial + 5;

        if (etapaSeleccionada < 1 || etapaSeleccionada > 6) {
            System.out.println("Opción inválida. Intente de nuevo.");
            return;
        }

        etapaSeleccionada += indiceInicial - 1;

        if (etapas[etapaSeleccionada] == null) {
            System.out.println("La etapa ya ha sido culminada anteriormente.");
        } else {
            etapas[etapaSeleccionada] = null;
            System.out.println("Se ha culminado con éxito la etapa.");
        }
    }

    public void registrarCapsula() {
        int id;
        String descripcion, tipo, nombreColaborador, cargoColaborador, aprendizaje, hashtag;

        System.out.println("Ingrese el id de la cápsula:");
        id = reader.nextInt();

        System.out.println("Ingrese la descripción de la cápsula:");
        descripcion = reader.next();

        System.out.println("Ingrese el tipo de la cápsula:");
        tipo = reader.next();

        int pos = getFirstValidPositionCapsula(); // Obtener la primera posición válida
        if (pos != -1) {
            tiposCapsula[pos] = tipo; // Guardar el tipo de cápsula en el arreglo tiposCapsula
        }

        System.out.println("Ingrese el nombre del colaborador:");
        nombreColaborador = reader.next();

        int posc = getFirstValidPositionColaborador(); // Obtener la primera posición válida
        if (posc != -1) {
            nombresColaboradores[posc] = nombreColaborador; // Guardar el nombre del colaborador en el arreglo
        }

        System.out.println("Ingrese el cargo del colaborador:");
        cargoColaborador = reader.next();

        System.out.println("Ingrese el aprendizaje de la cápsula:");
        aprendizaje = reader.next();

        System.out.println("Ingrese el hashtag de la cápsula:");
        hashtag = reader.next();

        int posch = getFirstValidPositionColaborador(); // Obtener la primera posición válida
        if (posch != -1) {
            hashtagsCapsula[posch] = hashtag; // Guardar el nombre del colaborador en el arreglo
        }

        hashtagsCapsula[pos] = hashtag; // Guardar el hashtag en el arreglo hashtagsCapsula

        Capsula capsula = new Capsula(id, descripcion, tipo, nombreColaborador, cargoColaborador, aprendizaje, hashtag);

        if (pos != -1) {
            capsulas[pos] = capsula;
        }
    }

    public int getFirstValidPositionCapsula() {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < SIZE && !isFound; i++) {
            if (capsulas[i] == null) {
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }

    public int getFirstValidPositionColaborador() {
        int posc = -1;
        boolean isFound = false;
        for (int i = 0; i < SIZE && !isFound; i++) {
            if (nombresColaboradores[i] == null) {
                posc = i;
                isFound = true;
            }
        }
        return posc;
    }

    public int getFirstValidPositionHashtag() {
        int pos = -1;
        boolean isFound = false;
        for (int i = 0; i < SIZE && !isFound; i++) {
            if (hashtagsCapsula[i] == null) {
                pos = i;
                isFound = true;
            }
        }
        return pos;
    }

    public void aprobarCapsula() {
        System.out.println("Escoge el proyecto en donde esta la capsula a aprobar (1-10): ");
        int proyectoSeleccionado = reader.nextInt();
        if (proyectoSeleccionado < 1 || proyectoSeleccionado > 10) {
            System.out.println("Opción inválida. Intente de nuevo.");
            return;
        }

        System.out.println("¿En qué etapa deseas añadir la capsula? (1-6): ");
        int etapaSeleccionada = reader.nextInt();
        if (etapaSeleccionada < 1 || etapaSeleccionada > 6) {
            System.out.println("Opción inválida. Intente de nuevo.");
            return;
        }

        System.out.println("Ingresa el ID de la capsula que deseas aprobar: ");
        int idCapsula = reader.nextInt();

        int indiceProyecto = proyectoSeleccionado - 1;
        int indiceEtapa = ((proyectoSeleccionado - 1) * 6) + (etapaSeleccionada - 1);

        if (capsulas[indiceEtapa] == null || capsulas[indiceEtapa].getId() != idCapsula) {
            System.out.println("La capsula no existe.");
            return;
        } else {
            capsulas[indiceEtapa].setAprobada(true);
            System.out.println("La capsula fue aprobada con éxito.");
            System.out.println("La capsula se agregó el día " + LocalDate.now());
        }
    }

    public void contarTiposDeCapsula() {
        int tecnico = 0, gestion = 0, dominio = 0, experiencias = 0;

        for (String tipo : tiposCapsula) {
            if (tipo != null) {
                switch (tipo.toLowerCase()) {
                    case "técnico":
                        tecnico++;
                        break;
                    case "gestión":
                        gestion++;
                        break;
                    case "dominio":
                        dominio++;
                        break;
                    case "experiencias":
                        experiencias++;
                        break;
                }
            }
        }

        System.out.println("Tipos de cápsulas:");
        System.out.println("- Técnico: " + tecnico);
        System.out.println("- Gestión: " + gestion);
        System.out.println("- Dominio: " + dominio);
        System.out.println("- Experiencias: " + experiencias);
    }

    public void capsulasColaborador() {
        System.out.println("Digite el proyecto en el cual quiere verificar si se han creado cápsulas (1-10):");
        int proyecto = reader.nextInt();

        if (proyecto < 1 || proyecto > 10) {
            System.out.println("Opción inválida. Intente de nuevo.");
            return;
        }

        int indiceInicial = (proyecto - 1) * 300;

        System.out.println("Revisando las posiciones " + (indiceInicial + 1) + " a " + (indiceInicial + 300) + "...");

        boolean seEncontraronCapsulas = false;

        for (int i = indiceInicial; i < indiceInicial + 300; i++) {
            if (nombresColaboradores[i] != null) {
                seEncontraronCapsulas = true;
                System.out.println(nombresColaboradores[i] + " ha subido una cápsula.");
            }
        }

        if (!seEncontraronCapsulas) {
            System.out.println("No se encontraron cápsulas para el proyecto seleccionado.");
        }
    }

    public void buscarCapsula() {
        System.out.println("Ingrese una palabra con un caracter #:");
        String palabra = reader.next();

        boolean encontrado = false;
        for (int i = 0; i < SIZE && !encontrado; i++) {
            if (capsulas[i] != null && capsulas[i].getHashtag().contains(palabra)) {
                encontrado = true;
                System.out.println("Se ha encontrado una cápsula con conocimiento empresarial.");
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron datos.");
        }
    }

}
