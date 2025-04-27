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
    Image imagen; // Imagen del tablero
    Graphics noseve; // Gráficos para la imagen
    Image imagenes[]; // Imágenes de las fichas
    Image reverso; // Imagen del reverso de las fichas
    Baraja baraja; // Objeto Baraja que contiene las cartas

    
    @Override
    public void init() {
        String palos[] = {"clubs", "diamonds", "hearts", "spades"};
        imagen = this.createImage(1920, 1080); // Crea una imagen para el tablero
        noseve = imagen.getGraphics(); // Obtiene los gráficos de la imagen

        imagenes = new Image[NUMCARTAS];

        for (int i = 0; i < NUMCARTAS; i++) {
            imagenes[i] = getImage(getCodeBase(), "Tercera/Ejercicio8/Cartas/" + (i % CPP) + "_of_" + palos[i / CPP] + ".png");
        }
        
        reverso = this.getImage(getCodeBase(), "Tercera/Ejercicio8/Cartas/reverso.png"); // Carga la imagen del reverso de las fichas

        baraja = new Baraja(imagenes, reverso); // Crea una nueva baraja con las imágenes de las cartas y el reverso
        
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

        // Pinto la baraja en el tablero 
        for (int i = 0; i < NUMCARTAS; i++) {
            Carta carta = baraja.cartas.get(i); // Obtiene la carta de la baraja
            carta.paint(noseve); // Dibuja la carta en la imagen del tablero
        }

        // Pinto el reverso de la baraja
        for (int i = 0; i < NUM_PALOS; i++) {
            for (int j = 0; j < CPP; j++) {
                noseve.drawImage(reverso, (j * Carta.ANCHO) + 10, (i * Carta.ALTO) + 10, this); // Dibuja el reverso de la carta en la imagen del tablero
            }
        }

        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen del tablero en el applet
    }

   // Metdo para manejar los eventos de ratón con las cartas desplazandose
    // Se utiliza el evento mouseDown para detectar cuando se hace clic en una carta y mouse drag para moverla y mouse up para soltarla
private Carta cartaSeleccionada = null; // Carta seleccionada para mover
private int offsetX, offsetY; // Desplazamiento del ratón respecto a la carta

@Override
public boolean mouseDown(Event evt, int x, int y) {
    // Detectar si se ha hecho clic en una carta
    for (Carta carta : baraja.cartas) {
        if (carta.contains(x, y)) {
            cartaSeleccionada = carta;
            offsetX = x - carta.x; // Calcular el desplazamiento del ratón respecto a la carta
            offsetY = y - carta.y;
            return true;
        }
    }
    return false;
}

@Override
public boolean mouseDrag(Event evt, int x, int y) {
    // Mover la carta seleccionada
    if (cartaSeleccionada != null) {
        cartaSeleccionada.setPosition(x - offsetX, y - offsetY);
        repaint();
        return true;
    }
    return false;
}

@Override
public boolean mouseUp(Event evt, int x, int y) {
    // Soltar la carta seleccionada
    if (cartaSeleccionada != null) {
        cartaSeleccionada = null;
        repaint();
        return true;
    }
    return false;
}

}