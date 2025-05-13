
package Tercera.Ejercicio09;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake extends Applet implements Runnable { // Clase principal del applet
    public static final int TIEMPO = 300;
    Image imagen;
    Graphics noseve;
    Serpiente serpiente; // Declaramos la serpiente
    Image imgCasilla; // Imagen de la casilla
    Thread animacion; // Hilo para el applet

    public void init() { // Inicializa el applet
        imagen = this.createImage(700, 800); // Crea la imagen
        noseve = imagen.getGraphics();  // Crea el objeto Graphics para dibujar en la imagen
        imgCasilla = getImage(getCodeBase(), "Tercera/Ejercicio09/casilla.png"); // Carga la imagen de la casilla
        serpiente = new Serpiente(imgCasilla); // Crea la serpiente

        setSize(700, 800); // Establece el tamaño del applet
    }
    
    public void update(Graphics g) { // Actualiza el applet
        paint(g);   // Llama al metodo paint para dibujar el applet
    }
    
    public void paint(Graphics g) { // Dibuja el applet
        noseve.setColor(Color.GREEN); // Establece el color de fondo
        noseve.fillRect(0, 0, 700, 800); // Dibuja el fondo
        serpiente.paint(noseve, this); // Dibuja la serpiente


        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen en el applet
    }
    
    public void start() { // Inicia el applet
        animacion = new Thread(this); // Crea el hilo
        animacion.start(); // Inicia el hilo
    }

    public void run() { // Método para ejecutar el applet
        do {
            serpiente.update(); // Actualiza la serpiente
            
            serpiente.moverEslabon(); // Mueve la serpiente 
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        } while (true);
    }

    public boolean keyDown(Event e, int key) { // Método para detectar teclas
        switch (key) {
            case Event.UP: // Tecla arriba
                serpiente.cambiarDireccion(Eslabon.ARRIBA); // Cambia la dirección de la serpiente

                break;
            case Event.DOWN: // Tecla abajo
                serpiente.cambiarDireccion(Eslabon.ABAJO); // Cambia la dirección de la serpiente
                break;
            case Event.LEFT: // Tecla izquierda
                serpiente.cambiarDireccion(Eslabon.IZQUIERDA); // Cambia la dirección de la serpiente
                break;
            case Event.RIGHT: // Tecla derecha
                serpiente.cambiarDireccion(Eslabon.DERECHO); // Cambia la dirección de la serpiente
                break;
            default:
                break;
        }
        return true; // Devuelve true para indicar que la tecla fue procesada
    }


}