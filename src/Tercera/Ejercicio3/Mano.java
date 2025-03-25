
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
}
