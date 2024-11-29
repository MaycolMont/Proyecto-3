package Personaje;
import Equipo.Equipo;

public class Guerrero extends Personaje{
    public Guerrero(String n, int v, int a, int d) {
        super(n, v, a, d);
    }

    public void usarEstrategia(Equipo e){
        ataque *= 2;
        System.out.println(getNombre() + " ha usado su estrategia");
        System.out.println(getNombre() + " ha aumentado su ataque al doble. Ataque: " + ataque);
    }
}
