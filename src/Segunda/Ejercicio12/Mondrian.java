package Segunda.Ejercicio12;

import java.applet.Applet; // Importo la clase Applet
import java.awt.Color; // Importo la clase Color
import java.awt.Graphics; // Importo la clase Graphics

public class Mondrian extends Applet implements Runnable{
    Thread animacion; // Objeto de la clase Thread
    int posX , posY; // Variables de tipo entero
    public void init(){  // Metodo init 
        posX = 80; // Inicializo la variable posX
        posY = 100; // Inicializo la variable posY
    }
    public void start(){
        animacion = new Thread(this); // Instancio el objeto animacion
        animacion.start(); // Inicializo el objeto animacion
    }
    public void paint(Graphics g){ // Metodo paint
        g.setColor(Color.yellow); // Color amarillo
        g.fillRect(0, 0, 90, 90); // Dibuja un rectangulo
        g.fillRect(250,0,40,190); // Dibuja un rectangulo
        g.fillRect(80, 160, 100, 120); // Dibuja un rectangulo
        g.setColor(Color.BLUE); // Color azul
        g.fillRect(80, 220, 220, 90); // Dibuja un rectangulo
        g.fillRect(100, 10, 90, 80); // Dibuja un rectangulo
        g.setColor(Color.LIGHT_GRAY); // Color gris claro
        g.fillRect(posX, posY, 110, 90); // Dibuja un rectangulo
        g.setColor(Color.RED); // Color rojo
        g.fillRect(200, 0, 45, 45); // Dibuja un rectangulo
        g.fillRect(0, 110, 70, 200); // Dibuja un rectangulo
        g.setColor(Color.MAGENTA); // Color magenta
        g.fillRect(200, 55, 60, 135); // Dibuja un rectangulo
    }
    @Override
    public void run() { // Metodo run
        do{ // Bucle do while 
            posX++; // Incremento la variable posX
            repaint(); // Llama al metodo repaint
            try { // Manejo de excepciones 
                Thread.sleep(100); // Tiempo de espera
            } catch (InterruptedException ex) {} // Excepcion a manejar 
        }while(true); // Bucle infinito 
    }

}
