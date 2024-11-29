package Personaje;
import java.util.Scanner;
import Equipo.Equipo;

public class Mistico extends Personaje{
    public int ataqueOriginal;

    public Mistico(String n, int v, int a, int d) {
        super(n, v, a, d);
        ataqueOriginal = a;
    }

    public void usarEstrategia(Equipo e) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entre 1 y 6: ");
        int valorIngresado = scanner.nextInt();
        int randomNum = (int) (Math.random() * 6 + 1);
        System.out.println("El número a adivinar era " + randomNum);
        
        if (randomNum == valorIngresado) {
            ataque += e.danoRealizado;
            System.out.println(getNombre() + " ha usado su estrategia");
            System.out.println(getNombre() + " ha aumentado su ataque en " + e.danoRealizado + ". Ataque: " + ataque);
        }
    }

    @Override
    public void realizarAtaque(Personaje contrario, Equipo e) {
        super.realizarAtaque(contrario, e);
        if (ataque != ataqueOriginal) {
            ataque = ataqueOriginal;
            System.out.println(getNombre() + " ha restaurado su ataque a su estado original. Ataque: " + ataque);
        }
        e.danoRealizado = 0;
    }
}
