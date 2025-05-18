package Tercera.Examen2023;

import java.awt.Graphics;
import java.awt.Image;
import java.applet.Applet;


public class Fondo {
    Image imagen; // Imagen del fondo
    int posX = 0; // Posicion X del fondo
    Applet applet; // Applet donde se dibuja el fondo


    public Fondo(Image img, Applet a) {
        imagen = img; // Carga la imagen del fondo
        applet = a; // Carga el applet
    }

    public void paint(Graphics g) {
        g.drawImage(imagen, posX, 0, applet.getWidth(), applet.getHeight(), applet); // Dibuja la imagen del fondo
        g.drawImage(imagen, posX + imagen.getWidth(applet), 0, applet.getWidth(), applet.getHeight(), applet); // Dibuja la imagen del fondo
    }

    public void update() {
        posX -= 5; // Mueve el fondo hacia la izquierda
        if (posX <= -imagen.getWidth(applet)) { // Si el fondo ha salido de la pantalla
            posX = 0; // Reinicia la posicion X
        }
    }
}

