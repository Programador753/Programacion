package Tercera.Ejercicio8;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Solitario extends Applet {
    public static final int NUMCARTAS = 52;
    public static final int CPP = 13;
    public static final int NUM_PALOS = 4;
    String palos[] = {"clubs", "diamonds", "hearts", "spades"};
    Image imagen; // Imagen del tablero
    Graphics noseve; // Gráficos para la imagen
    Image imagenes[]; // Imágenes de las fichas
    Image reverso; // Imagen del reverso de las fichas

    
    @Override
    public void init() {
        imagen = this.createImage(1920, 1080); // Crea una imagen para el tablero
        noseve = imagen.getGraphics(); // Obtiene los gráficos de la imagen

        imagenes = new Image[NUMCARTAS];

        for (int i = 0; i < NUMCARTAS; i++) {
            imagenes[i] = getImage(getCodeBase(), "Tercera/Ejercicio8/Cartas/" + (i % CPP) + "_of_" + palos[i / CPP] + ".png");
        }
        
        reverso = this.getImage(getCodeBase(), "Tercera/Ejercicio8/Cartas/reverso.png"); // Carga la imagen del reverso de las fichas


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

   
    public boolean mouseDown(Event e, int x, int y) {
        
        return true; // Devuelve true para indicar que el evento ha sido manejado
    }

}