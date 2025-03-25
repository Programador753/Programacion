
package Tercera.Ejercicio3;

import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;


public class Mano {
    ArrayList<Carta> cartas;
    int posY;

    public Mano(int pY) {
        cartas = new ArrayList<Carta>();
        this.posY = pY;
    }
    public void paint(Graphics g, Applet a){
        int x = 0;
        for(Carta carta : cartas){
            carta.setPosY(posY);
            carta.setPosX(100 + (x++*30));
            carta.paint(g, a);
        }
    }
    public void anadirCarta(Carta carta){
        cartas.add(carta);
    }

    // Metodo para calcular el valor de la mano del jugador en el blackjack Comprueba si hay un as en la mano para sumar 11 o 1 segun convenga
    public int getValor(){
        int valor = 0;
        boolean hayAs = false;
        for(Carta carta : cartas){
            valor += carta.getValor();
            if(carta.getValor() == 1) hayAs = true;
        }
        if(hayAs && valor + 10 <= 21) valor += 10;
        return valor;
    }
}
