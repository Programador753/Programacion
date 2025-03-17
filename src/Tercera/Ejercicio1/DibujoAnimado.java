package Tercera.Ejercicio1;

import java.awt.Graphics; // Importo la clase Graphics
import java.awt.Image; // Importo la clase Image
import java.applet.Applet; // Importo la clase Applet

public class DibujoAnimado { // Clase DibujoAnimado
    private Image imagenes[]; // Creo una variable de tipo Image llamada imagenes

    public int indice = 0; // Creo una variable de tipo entero llamada indice 


    public Image[] getImagenes() {
        return imagenes;
    }

    public void setImagenes(Image[] imagenes) {
        this.imagenes = imagenes;
    }

    public DibujoAnimado(Image imgs[]){ // Constructor de la clase DibujoAnimado
        imagenes = imgs; // Igualo la variable imagenes con imgs

    }

    public void paint(Graphics g, Applet ap){ // Metodo paint de la clase DibujoAnimado
        g.drawImage(imagenes[indice], 0, 0, 200, 250, ap); // Dibujo la imagen en la posicion 0,0 con un tamaño de 200x250
    }

    public void update(){ // Metodo update de la clase DibujoAnimado
        indice = (indice + 1) % imagenes.length;  // Actualizo el indice
        
    }
}
