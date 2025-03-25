
package Tercera.Ejercicio3;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

public class Carta {
    public static final int ALTURA= 200;
    public static final int ANCHURA= 150;
    private int posX,posY;
    int valor;
    Image imagen;

    public Carta(int valor, Image img) {
        this.imagen = img;
        //this.valor = valor;
        //if(valor > 10) this.valor = 10;
        this.valor = (valor > 10)? 10 : valor;
    }
    public void paint(Graphics g, Applet ap){
        g.drawImage(imagen, posX, posY,ANCHURA,ALTURA, ap);
    }

    public int getValor() {
        return valor;
    }

    public int getPosX() {
        return posX;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public int getPosY() {
        return posY;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
}
