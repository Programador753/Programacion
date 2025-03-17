package Tercera.Ejercicio2;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Pieza extends Rectangle{
    public static final int DIMENSION = 60;
    Image imagen;
    int posicion;
    private boolean colocado = false;
    public Pieza(Image img, int pos){
        super((int)(Math.random()*300 + 350), (int)(Math.random()*450), DIMENSION, DIMENSION);
        imagen = img;
        posicion = pos;
    }
    public void paint(Graphics g, Applet a){
        g.drawImage(imagen, x, y, a);
    }
    public boolean isColocado() {
        return colocado;
    }
    public void setColocado(boolean colocado) {
        this.colocado = colocado;
    }
    public void mover(int posx, int posy){
        x = posx - (DIMENSION / 2);
        y = posy - (DIMENSION / 2);
    }
    public void ajustar(int posx, int posy){
        x = posx;
        y = posy;
    }
    
}
