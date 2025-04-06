package Tercera.Ejercicio6;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Image;
import java.applet.Applet;

public class Ficha extends Rectangle {

    public static final int DIM = 75;
    public Image fichaImage;
    public int precio;

    public Ficha(int x, int y, int v, Image fichaImage) {
        super(x, y, DIM, DIM);
        this.fichaImage = fichaImage;
        this.precio = v;

    }

    public void paint(Graphics g, Applet applet) {
        g.drawImage(fichaImage, x, y, width, height, applet);
    }

    // Método para mover la ficha
    public void mover(int PosX, int PosY) {
        x = PosX - (DIM / 2);
        y = PosY - (DIM / 2);
    }

}
