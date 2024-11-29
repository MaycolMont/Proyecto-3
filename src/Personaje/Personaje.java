package Personaje;

import Equipo.Equipo;

public abstract class Personaje {
    private String nombre;
    public int vida;
    public int ataque;
    public int defensa;

    public Personaje(String n, int v, int a, int d) {
        nombre = n;
        vida = v;
        ataque = a;
        defensa = d;
    }

    public Personaje(){}

    public String getNombre() {
        return nombre;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre");
    }

    public void recibirAtaque(int dano) {
        if ((vida - dano) < 0) {
            vida = 0;
            System.out.println(nombre + " ha sido derrotado.");
        } else {
            vida -= dano;

            String msg = nombre + " recibe " + dano + " de daño. Vida restante: " + vida;

            System.out.println(msg);
        }
    }

    public void realizarAtaque(Personaje contrario, Equipo e) {
        usarEstrategia(e);

        int danoReal = ataque - contrario.defensa;
        if (danoReal > 0) {
            contrario.recibirAtaque(danoReal);
            e.danoRealizado += danoReal;
        }
    }

    public boolean estaDerrotado() {
        return vida <= 0;
    }

    public abstract void usarEstrategia(Equipo e);
}
