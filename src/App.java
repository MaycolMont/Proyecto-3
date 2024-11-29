import Equipo.Equipo;
import Personaje.Guerrero;
import Personaje.Mago;
import Personaje.Mistico;

public class App {
    public static void main(String[] args) throws Exception {
        Equipo equipo1 = new Equipo("Rojo");
        equipo1.agregarPersonaje(new Guerrero("Guerrero Rojo 1", 100, 20, 10));
        equipo1.agregarPersonaje(new Guerrero("Guerrero Rojo 2", 85, 25, 14));
        equipo1.agregarPersonaje(new Mago("Mago Extra Rojo", 75, 22, 4));
        equipo1.agregarPersonaje(new Mistico("Mistico Rojo", 85, 18, 8));

        // Equipo 2
        Equipo equipo2 = new Equipo("Azul");
        equipo2.agregarPersonaje(new Guerrero("Guerrero Azul 1", 95, 22, 12));
        equipo2.agregarPersonaje(new Guerrero("Guerrero Azul 2", 90, 23, 15));
        equipo2.agregarPersonaje(new Mago("Mago Extra Azul", 65, 28, 2));
        equipo2.agregarPersonaje(new Mistico("Mistico Azul", 80, 20, 7));

        comenzarBatalla(equipo1,equipo2);
    }

    public static void comenzarBatalla(Equipo e1, Equipo e2) {
        int i = 1;
        boolean limiteAlcanzado = false;

        while ((!e1.estaDerrotado()) && (!e2.estaDerrotado())) {
            System.out.println("Ronda " + i + ":");
            e1.mostrarPersonajes();
            e2.mostrarPersonajes();

            e1.atacarOtroEquipo(e2);
            e2.atacarOtroEquipo(e1);
            System.out.println("--------------------------------");

            i++;

            if (i > 15) {
                System.out.println("Máximo de rondas alcanzado.");
                double vidaEquipo = e1.obtenerVidaTotal();
                double vidaEnemigo = e2.obtenerVidaTotal();

                System.out.println("Vida total de " + e1.getNombre() + ": " + vidaEquipo);
                System.out.println("Vida total de " + e2.getNombre() + ": " + vidaEnemigo);

                if (vidaEquipo > vidaEnemigo) {
                    mostrarGanador(e1);
                } else if (vidaEquipo == vidaEnemigo) {
                    System.out.println("Empate!");
                } else {
                    mostrarGanador(e2);
                }
                
                limiteAlcanzado = true;
                break;
            }
        }

        if (!limiteAlcanzado) {
            if (e1.estaDerrotado()) {
                mostrarGanador(e2);
            } else {
                mostrarGanador(e1);
            }
        }
    }

    public static void mostrarGanador(Equipo e) {
        System.out.println("El equipo " + e.getNombre() + " ha ganado la batalla!");
    }
}
