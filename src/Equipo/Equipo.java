package Equipo;
import java.util.ArrayList;
import Personaje.Personaje;

public class Equipo {
    private String nombre;
    private ArrayList<Personaje> personajes = new ArrayList<>();
    public int danoRealizado;

    public Equipo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPersonaje(Personaje p) {
        personajes.add(p);
    }

    public ArrayList<Personaje> getPersonajes() {
        return personajes;
    }

    public void atacarOtroEquipo(Equipo e) {
        if (!estaDerrotado()) {
            System.out.println("--------- Equipo " + nombre + " ataca");
        ArrayList<Personaje> miEquipo = getPersonajes();
        ArrayList<Personaje> eContrario = e.getPersonajes();

        int i = 0;
        
        for (Personaje p : miEquipo) {
            Personaje contrario = eContrario.get(i);

            if (!p.estaDerrotado() && !contrario.estaDerrotado()){
                p.realizarAtaque(contrario, this);;
            }
/*             if (contrario.estaDerrotado()) {
                i = e.siguientePersonajeVivo(i);
                if (i < 0) {
                    break;
                }
                contrario = eContrario.get(i);
                p.realizarAtaque(contrario, this);
                continue;
            } */
            i++;
        }
        }
    }

    public boolean estaDerrotado() {
        ArrayList<Personaje> personajes = getPersonajes();

        int nPersonajes = personajes.size();
        for (int i = 0; i < nPersonajes; i++) {
            Personaje p = personajes.get(i);
            if (p.vida > 0) {
                return false;
            }
        }
        return true;
    }

    public int siguientePersonajeVivo(int currentIndex) {
        ArrayList<Personaje> personajes = getPersonajes();
        for (int i = currentIndex + 1; i < personajes.size(); i++) {
            if (!personajes.get(i).estaDerrotado()) {
                return i;
            }
        }
        return -1;
    }

    public double obtenerVidaTotal() {
        double vidaTotal = 0;
        ArrayList<Personaje> personajes = getPersonajes();
        for (Personaje personaje : personajes) {
            vidaTotal += personaje.vida;
        }
        return vidaTotal;
    }

    public void mostrarPersonajes() {
        ArrayList<Personaje> personajes = getPersonajes();
        String msg = "Equipo " + nombre + ":";
        for (Personaje personaje : personajes) {
            String inicial = personaje.getNombre().substring(0, 3);
            if (personaje.estaDerrotado()) {
                msg += "  X  ";
            } else {
            msg += " " + inicial + " ";
            }
        }
        System.out.println(msg);
    }
}
