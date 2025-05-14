
package Tercera.Ejercicio09;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

public class Snake extends Applet implements Runnable { // Clase principal del applet
    public static final int TIEMPO = 100;
    int contador = 0; // Contador para ir añadiendo manzanas
    Image imagen;
    Graphics noseve;
    Serpiente serpiente; // Declaramos la serpiente
    Image imgCasilla; // Imagen de la casilla
    Thread animacion; // Hilo para el applet
    Image manzana; // Imagen de la manzana
    ArrayList<Eslabon> manzanas; // Lista de manzanas

    public void init() { // Inicializa el applet
        imagen = this.createImage(700, 800); // Crea la imagen
        noseve = imagen.getGraphics();  // Crea el objeto Graphics para dibujar en la imagen
        imgCasilla = getImage(getCodeBase(), "Tercera/Ejercicio09/casilla.png"); // Carga la imagen de la casilla
        serpiente = new Serpiente(imgCasilla); // Crea la serpiente
        manzana = getImage(getCodeBase(), "Tercera/Ejercicio09/manzana.png"); // Carga la imagen de la manzana
        manzanas = new ArrayList<Eslabon>(); // Inicializa la lista de manzanas

        setSize(700, 800); // Establece el tamaño del applet
    }
    
    public void update(Graphics g) { // Actualiza el applet
        paint(g);   // Llama al metodo paint para dibujar el applet
    }
    
    public void paint(Graphics g) { // Dibuja el applet
        noseve.setColor(Color.GREEN); // Establece el color de fondo
        noseve.fillRect(0, 0, 700, 800); // Dibuja el fondo
        serpiente.paint(noseve, this); // Dibuja la serpiente
        for (Eslabon manzana : manzanas) { // Recorre la lista de manzanas
            manzana.paint(noseve, this); // Dibuja la manzana
        }

        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen en el applet
    }
    
    public void start() { // Inicia el applet
        animacion = new Thread(this); // Crea el hilo
        animacion.start(); // Inicia el hilo
    }

    public void run() { // Método para ejecutar el applet
        do {
            contador += TIEMPO; // Incrementa el contador
            if(contador > 5000){ // Si el contador es mayor a 1000
                int x = (int) (Math.random() * 700); // Genera una coordenada aleatoria
                int y = (int) (Math.random() * 800); // Genera una coordenada aleatoria
                manzanas.add(new Eslabon(manzana, x, y, Event.RIGHT)); // Crea la manzana
                contador = 0; // Reinicia el contador
            }
            serpiente.update(); // Actualiza la serpiente
            for(Eslabon manzana : manzanas){ // Recorre la lista de manzanas
                if(serpiente.primerEslabon().intersects(manzana)){ // Si la serpiente come la manzana
                    serpiente.agregarEslabon(imgCasilla); // Agrega un eslabon a la serpiente
                    manzanas.remove(manzana); // Elimina la manzana
                    break; // Sale del bucle
                }
            }
            repaint();
            try {
                Thread.sleep(TIEMPO);
            } catch (InterruptedException e) {}
        } while (true);
    }

    public boolean keyDown(Event e, int key) { // Método para detectar teclas
        serpiente.cambiarDireccion(key);
        return true;
    }


}