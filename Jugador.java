public class Jugador {

    private String nombre;
    private String nickname;
    private int edad;
    private int[] puntajes;
    private int partidasJugadas;

    public Jugador(String nombre, String nickname, int edad) {
        this.nombre = nombre;
        this.nickname = nickname;
        this.edad = edad;
        puntajes = new int[10];
        partidasJugadas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNickname() {
        return nickname;
    }

    public int getEdad() {
        return edad;
    }

    public int getPartidasJugadas() {
        return partidasJugadas;
    }

    public int getPartidasDisponibles() {
        return 10 - partidasJugadas;
    }

    public boolean registrarPuntaje(int puntaje) {
        if (puntaje < 0 || puntaje > 100) {
            return false;
        }

        if (partidasJugadas >= 10) {
            return false;
        }

        puntajes[partidasJugadas] = puntaje;
        partidasJugadas++;
        return true;
    }

    public void mostrarPuntajes() {
        if (partidasJugadas == 0) {
            System.out.println("No hay partidas registradas.");
            return;
        }

        for (int i = 0; i < partidasJugadas; i++) {
            System.out.println("Partida " + (i + 1) + ": " + puntajes[i] + " puntos");
        }
    }

    public int consultarPuntaje(int numeroPartida) {
        if (numeroPartida < 1 || numeroPartida > partidasJugadas) {
            return -1;
        }

        return puntajes[numeroPartida - 1];
    }

    public boolean modificarPuntaje(int numeroPartida, int nuevoPuntaje) {
        if (numeroPartida < 1 || numeroPartida > partidasJugadas) {
            return false;
        }

        if (nuevoPuntaje < 0 || nuevoPuntaje > 100) {
            return false;
        }

        puntajes[numeroPartida - 1] = nuevoPuntaje;
        return true;
    }

    public double calcularPromedio() {
        if (partidasJugadas == 0) {
            return 0;
        }

        int suma = 0;

        for (int i = 0; i < partidasJugadas; i++) {
            suma += puntajes[i];
        }

        return (double) suma / partidasJugadas;
    }

    public int obtenerMejorPuntaje() {
        if (partidasJugadas == 0) {
            return -1;
        }

        int mayor = puntajes[0];

        for (int i = 1; i < partidasJugadas; i++) {
            if (puntajes[i] > mayor) {
                mayor = puntajes[i];
            }
        }

        return mayor;
    }

    public int obtenerPeorPuntaje() {
        if (partidasJugadas == 0) {
            return -1;
        }

        int menor = puntajes[0];

        for (int i = 1; i < partidasJugadas; i++) {
            if (puntajes[i] < menor) {
                menor = puntajes[i];
            }
        }

        return menor;
    }
}
