package Tercera.Ejercicio7;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Memory extends Applet {
    Image imagen; // Imagen del tablero
    Graphics noseve; // Gráficos para la imagen
    Image imagenes[]; // Imágenes de las fichas
    Image reverso; // Imagen del reverso de las fichas

    @Override
    public void init() {
        imagen = this.createImage(1920, 1080); // Crea una imagen para el tablero
        noseve = imagen.getGraphics(); // Obtiene los gráficos de la imagen

        // Establece el tamaño del applet
        this.setSize(1920, 1080); // Establece el tamaño del applet
    }

    @Override
    public void update(Graphics g) {
        paint(g); // Llama al método paint para dibujar el applet
    }

    @Override
    public void paint(Graphics g) {
        noseve.setColor(Color.green.darker()); // Establece el color de fondo
        noseve.fillRect(0, 0, 1920, 1080); // Dibuja el fondo verde

        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen del tablero en el applet
    }

    @Override
    public boolean mouseDown(Event e, int x, int y) {

        return false;
    }

}
