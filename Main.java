import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Jugador jugador = crearJugador(scanner);

        int opcion = 0;

        while (opcion != 9) {
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
            opcion = leerEntero(scanner);

            switch (opcion) {

                case 1:
                    jugador = crearJugador(scanner);
                    System.out.println("Nuevo jugador creado correctamente.");
                    break;

                case 2:
                    System.out.print("Ingrese el puntaje de la partida (0-100): ");
                    int puntaje = leerEntero(scanner);

                    if (puntaje < 0 || puntaje > 100) {
                        System.out.println("Error: el puntaje debe estar entre 0 y 100.");
                    } else if (jugador.getPartidasJugadas() >= 10) {
                        System.out.println("Error: ya se registraron las 10 partidas permitidas.");
                    } else {
                        jugador.registrarPuntaje(puntaje);
                        System.out.println("Puntaje registrado correctamente.");
                    }
                    break;

                case 3:
                    jugador.mostrarPuntajes();
                    break;

                case 4:
                    System.out.print("Ingrese el numero de partida: ");
                    int partidaConsulta = leerEntero(scanner);

                    int resultado = jugador.consultarPuntaje(partidaConsulta);

                    if (resultado == -1) {
                        System.out.println("Error: esa partida no esta registrada.");
                    } else {
                        System.out.println("Puntaje de la partida " + partidaConsulta + ": " + resultado);
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el numero de partida a modificar: ");
                    int partidaModificar = leerEntero(scanner);

                    System.out.print("Ingrese el nuevo puntaje (0-100): ");
                    int nuevoPuntaje = leerEntero(scanner);

                    if (nuevoPuntaje < 0 || nuevoPuntaje > 100) {
                        System.out.println("Error: el puntaje debe estar entre 0 y 100.");
                    } else if (jugador.modificarPuntaje(partidaModificar, nuevoPuntaje)) {
                        System.out.println("Puntaje modificado correctamente.");
                    } else {
                        System.out.println("Error: esa partida no esta registrada.");
                    }
                    break;

                case 6:
                    if (jugador.getPartidasJugadas() == 0) {
                        System.out.println("No hay partidas registradas.");
                    } else {
                        System.out.printf("Promedio: %.2f%n", jugador.calcularPromedio());
                    }
                    break;

                case 7:
                    if (jugador.getPartidasJugadas() == 0) {
                        System.out.println("No hay partidas registradas.");
                    } else {
                        System.out.println("Mejor puntaje: " + jugador.obtenerMejorPuntaje());
                        System.out.println("Peor puntaje: " + jugador.obtenerPeorPuntaje());
                    }
                    break;

                case 8:
                    System.out.println("Partidas jugadas: " + jugador.getPartidasJugadas());
                    System.out.println("Partidas disponibles: " + jugador.getPartidasDisponibles());
                    break;

                case 9:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
                    break;
            }
        }

        scanner.close();
    }

    public static Jugador crearJugador(Scanner scanner) {
        System.out.println("\n--- Datos del jugador ---");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nickname: ");
        String nickname = scanner.nextLine();

        System.out.print("Edad: ");
        int edad = leerEntero(scanner);

        return new Jugador(nombre, nickname, edad);
    }

    public static void mostrarMenu() {
        System.out.println("\n--- TORNEO UNIVERSITARIO DE VIDEOJUEGOS ---");
        System.out.println("1. Nuevo jugador");
        System.out.println("2. Registrar nueva partida");
        System.out.println("3. Consultar puntajes");
        System.out.println("4. Consultar una partida");
        System.out.println("5. Modificar puntaje");
        System.out.println("6. Mostrar promedio");
        System.out.println("7. Mostrar mejor y peor puntaje");
        System.out.println("8. Consultar partidas disponibles");
        System.out.println("9. Salir");
    }

    public static int leerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Entrada invalida. Ingrese un numero entero: ");
            scanner.next();
        }

        int numero = scanner.nextInt();
        scanner.nextLine();
        return numero;
    }
}
