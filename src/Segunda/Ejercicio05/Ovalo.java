package Segunda.Ejercicio05;

import java.awt.Color; // Importo Clase Color
import java.awt.Graphics; // Importo Clase Graphics 
import java.util.Random; // Importo Clase Random

public class Ovalo {
    int posX, posY, anchura, altura; // Declaro variables
    Color color; // Declaro un nuevo objeto de la clase Color
    Random r;  // Declaro un nuevo objeto de la clase Random

    public Ovalo() {
        r = new Random(); // Instancio un nuevo objeto de Random 
        inicializar(); // Llamada al metodo inicializar
    }

    public void inicializar() { // Metodo inicializar
        posX = r.nextInt(200); // Genero PosX aleatoria
        posY = r.nextInt(200); // Genero PosY aleatoria
        anchura = r.nextInt(100); // Genero anchura aleatoria
        altura = r.nextInt(100); // Genero altura aleatoria
        color = new Color(r.nextInt(256),r.nextInt(256),r.nextInt(256)); // Instancio color aleatorio
    }
    public void dibujar(Graphics g){ // Metodo dibujar
        g.setColor(color); // Indico el color
        g.fillOval(posX, posY, anchura, altura); // Dibujo ovalo con color
    }
}
