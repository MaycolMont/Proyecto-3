package Personaje;
import java.util.ArrayList;
import Equipo.Equipo;

public class Mago extends Personaje{
    //private final String tipo = "Mago";

    public Mago(String n, int v, int a, int d) {
        super(n, v, a, d);
    }

    public void usarEstrategia(Equipo e) {
        ArrayList<Personaje> personajes = e.getPersonajes();
        int nPersonajes = personajes.size();
        int iPersonaje = (int) (Math.random() * nPersonajes - 1);

        Personaje personaje = personajes.get(iPersonaje);
        while (personaje.estaDerrotado()) {
            iPersonaje = (int) (Math.random() * nPersonajes - 1);
            personaje = personajes.get(iPersonaje);
        }

        personaje.vida += vida * 0.25;

        System.out.println(getNombre() + " ha usado su estrategia");
        System.out.println(personaje.getNombre() + " ha aumentado su vida en " + (vida * 0.25));
    }
}
