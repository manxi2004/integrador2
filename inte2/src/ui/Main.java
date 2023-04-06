package ui;

import model.Gerente;
import model.Capsula;
import model.Etapa;
import model.Proyecto;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Gerente gerente = new Gerente("Juan Perez");
        Proyecto proyecto = new Proyecto("Proyecto de software", gerente);

        int opcion;
        do {
            System.out.println("\n---- Menú ----");
            System.out.println("1. Crear etapa");
            System.out.println("2. Culminar etapa");
            System.out.println("3. Registrar cápsula");
            System.out.println("4. Aprobar cápsula");
            System.out.println("5. Publicar cápsula");
            System.out.println("6. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre de la etapa: ");
                    String nombreEtapa = scanner.nextLine();
                    Etapa etapa = proyecto.crearEtapa(nombreEtapa);
                    System.out.println("Etapa creada con éxito. ID de la etapa: " + etapa.getId());
                    break;
                case 2:
                    System.out.print("Ingrese el ID de la etapa a culminar: ");
                    int idEtapa = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    boolean etapaCulminada = proyecto.culminarEtapa(idEtapa);
                    if (etapaCulminada) {
                        System.out.println("Etapa culminada con éxito");
                    } else {
                        System.out.println("No se encontró ninguna etapa con ese ID");
                    }
                    break;
                case 3:
                    System.out.print("Ingrese el nombre de la cápsula: ");
                    String nombreCapsula = scanner.nextLine();
                    System.out.print("Ingrese la descripción de la cápsula: ");
                    String descripcionCapsula = scanner.nextLine();
                    System.out.print("Ingrese el ID de la etapa: ");
                    int idEtapaCapsula = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    Capsula capsula = new Capsula(idEtapaCapsula, nombreCapsula, descripcionCapsula);
                    boolean capsulaRegistrada = proyecto.registrarCapsula(capsula, idEtapaCapsula);
                    if (capsulaRegistrada = true) {
                        System.out.println("Cápsula registrada con éxito. ID de la cápsula: " + capsula.getId());
                    } else {
                        System.out.println("No se encontró ninguna etapa con ese ID");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ID de la cápsula a aprobar: ");
                    int idCapsula = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    boolean capsulaAprobada = gerente.aprobarCapsula(proyecto, idCapsula);
                    if (capsulaAprobada = true) {
                        System.out.println("Cápsula aprobada con éxito");
                    } else {
                        System.out
                                .println("No se encontró ninguna cápsula con ese ID o la cápsula ya ha sido aprobada");
                    }
                    break;
                case 5:
                    System.out.print("Ingrese el ID de la cápsula a publicar: ");
                    int idCapsulaPublicar = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer de entrada
                    boolean capsulaPublicada = gerente.publicarCapsula(proyecto, idCapsulaPublicar);
                    if (capsulaPublicada = true) {
                        System.out.println("Cápsula publicada con éxito");
                    } else {
                        System.out
                                .println("No se encontró ninguna cápsula con ese ID o la cápsula no ha sido aprobada");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo");
                    break;
            }

        } while (opcion != 6);
    }
}
