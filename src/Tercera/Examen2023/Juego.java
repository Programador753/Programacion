package Tercera.Examen2023;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Event;



public class Juego extends Applet implements Runnable {
    public static final int NUMIMG = 5; // Numero de imagenes
    public static final int NUMRUEDAS = 2; // Numero de ruedas
    public static int velocidad = 100; // Velocidad de la animacion
    int contador = 0; 
    Image imagen;
    Graphics noseve;
    Thread animacion; // Hilo para el applet
    Image imgFondo; // Imagen del fondo
    Fondo fondo; // Fondo del juego
    Image imgRuedas[]; // Array de imagenes de las ruedas
    Rueda ruedas[]; // Array de objetos Rueda
    Image imgCoche; // Imagen del coche
    Image imgLuz; // Imagen de la luz
    Coche coche; // Coche del juego
    Image imgPedal1, imgPedal2; // Imagenes de los pedales
    Pedal pedal1, pedal2; // Objeto Pedal

    @Override
    public void init() {
        imagen = this.createImage(500, 350); // Crea la imagen
        noseve = imagen.getGraphics();  // Crea el objeto Graphics para dibujar en la imagen
        imgFondo = getImage(getCodeBase(), "Tercera/Examen2023/imgsCoche/fondo.jpg"); // Carga la imagen del fondo
        fondo = new Fondo(imgFondo, this); // Crea el fondo
        imgCoche = getImage(getCodeBase(), "Tercera/Examen2023/imgsCoche/mercedes.png"); // Carga la imagen del coche
        imgLuz = getImage(getCodeBase(), "Tercera/Examen2023/imgsCoche/lightBeam.png"); // Carga la imagen de la luz
        coche = new Coche(imgCoche, imgLuz); // Crea el coche
        imgRuedas = new Image[NUMIMG]; // Crea el array de imagenes
        for (int i = 0; i < NUMIMG; i++) { // Carga las imagenes de las ruedas
            imgRuedas[i] = getImage(getCodeBase(), "Tercera/Examen2023/imgsCoche/rueda" + (i + 1) + ".gif");
        }
        ruedas = new Rueda[NUMRUEDAS]; // Crea el array de objetos Rueda
        for (int i = 0; i < NUMRUEDAS; i++) { // Crea las ruedas
            ruedas[i] = new Rueda(imgRuedas, 65 + (i*123), 250); // Crea la rueda
        }
        imgPedal1 = getImage(getCodeBase(), "Tercera/Examen2023/imgsCoche/pedal1.png"); // Carga la imagen del pedal 1
        imgPedal2 = getImage(getCodeBase(), "Tercera/Examen2023/imgsCoche/pedal2.png"); // Carga la imagen del pedal 2
        pedal1 = new Pedal(imgPedal1, 80, 50, 50, 50); // Crea el pedal 1
        pedal2 = new Pedal(imgPedal2, 20, 50, 50, 50); // Crea el pedal 2

        setSize(500, 350); // Establece el tamaño del applet
    }

    @Override
    public void paint(Graphics g) {
        fondo.paint(noseve); // Dibuja el fondocoche.paint(noseve); // Dibuja el coche
        coche.paint(noseve); // Dibuja el coche
        pedal1.paint(noseve); // Dibuja el pedal 1
        pedal2.paint(noseve); // Dibuja el pedal 2

        for (int i = 0; i < NUMRUEDAS; i++) { // Dibuja las ruedas
            ruedas[i].paint(noseve, this); // Dibuja la rueda
        }

        // Dibuja la imagen en el applet
        g.drawImage(imagen, 0, 0, this);
    }

    @Override
    public void update(Graphics g) {
        paint(g);
    }

    @Override
    public void start() { // Inicia el applet
        animacion = new Thread(this); // Crea el hilo
        animacion.start(); // Inicia el hilo
    }

    @Override
    public void run() {
        do {
            contador += velocidad; // Incrementa el contador
            fondo.update(); // Actualiza el fondo
            for (int i = 0; i < NUMRUEDAS; i++) { // Actualiza las ruedas
                ruedas[i].update(); // Actualiza la rueda
            }
           
            repaint();
            try {
                Thread.sleep(velocidad);
            } catch (InterruptedException e) {}
        } while (true);
    }

    @Override
    public boolean mouseDown(Event e, int x, int y) { // Detecta el click del ratón
        if (coche.contains(x, y)) { // Si el click está dentro del coche
            coche.turn(); // Cambia el estado de la luz
        }
        if (pedal1.contains(x, y)) { // Si el click está dentro del pedal 1
            pedal1.acelerar(); // Acelera el coche
        }
        if (pedal2.contains(x, y)) { // Si el click está dentro del pedal 2
            pedal2.frenar(); // Frenar el coche
        }
        return true;
    }
}