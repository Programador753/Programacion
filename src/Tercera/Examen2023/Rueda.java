package Tercera.Examen2023;

import java.awt.Image; // Importo la clase Image
import java.awt.Graphics; // Importo la clase Graphics
import java.applet.Applet; // Importo la clase Applet

public class Rueda {
    public static final int TAM = 40; // Tamaño de la rueda
    Image imagenes[]; // Creo una variable de tipo Image llamada imagenes
    int posX = 0; // Creo una variable de tipo entero llamada posX
    int posY = 0; // Creo una variable de tipo entero llamada posY
    int imgActual = 0; // Creo una variable de tipo entero llamada imgActual

    
    public Rueda(Image[] imagenes, int x, int y) { // Constructor de la clase Rueda
        this.imagenes = imagenes;
        this.posX = x;
        this.posY = y;
    }

    public void paint(Graphics g, Applet applet) {

        g.drawImage(imagenes[imgActual], posX, posY, TAM, TAM, applet); // Dibujo la imagen en la posicion 0,0
    }

    public Image[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(Image[] imagenes) {
        this.imagenes = imagenes;
    }

    public void update() { // Metodo update de la clase DibujoAnimado
        imgActual = (imgActual + 1) % imagenes.length; // Actualizo el indice
    }

}