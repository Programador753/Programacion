package Examen;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.awt.Event;

/* 
El centro del applet sale un círculo cada 2 segundos, tomando una trayectoria aleatoria. 
En el interior del círculo se ve un número, inicialmente el 1. 
Cada vez que el usuario haga click en el círculo, el número aumentará en 1 y cuando llegue al 5 el círculo desaparecerá.  
Llevaremos y mostraremos un contador con el número de círculos que el usuario se ha cargado 
y cuando en la lista haya 10 círculos el juego habrá terminado (GAME OVER).
 */
public class Ejercicio2 extends Applet implements Runnable{
    public static final int TIEMPO = 45; // Variable de tiempo
    Thread animacion; // Hilo de animacion
    Image imagen; // Imagen para animar
    Graphics noseve; // Objeto de la clase Graphics
    ArrayList<Circulo> circulos; // Array de objetos de la clase Circulo
    int contadorcirculo = 0; // Contador para saber cuantos circulos se han creado
    int circulospantalla = 0; // Contador para saber cuantos circulos hay en pantalla
    boolean continua = true; // Variable booleana para saber si el juego continua
    int contador = 0; // Contador para saber cuando crear una nueva nave

    public void init() { // Metodo init para inicializar el applet
        imagen = this.createImage(300, 300); // Creo una imagen de 300x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve
        circulos = new ArrayList<Circulo>(); // Inicializo el array de circulos
        this.setSize(300, 300); // Establezco el tamaño del applet
    }

    public void update(Graphics g) { // Metodo update que recibe un objeto de la clase Graphics
        paint(g); // Llamo al metodo paint con el objeto g
    }

    public void start() { // Metodo start para iniciar el hilo de animacion
        animacion = new Thread(this); // Creo un hilo de animacion
        animacion.start(); // Inicio el hilo de animacion
    }

    public void paint(Graphics g) { // Metodo paint que recibe un objeto de la clase Graphics
        noseve.setColor(Color.BLACK); // Establezco el color de noseve que es el fondo del applet
        noseve.fillRect(0, 0, 300, 300); // Relleno el fondo del applet con el color
        noseve.setColor(Color.WHITE); // Establezco el color de noseve que es el color de las letras
        noseve.drawString("Circulos creados: " + contadorcirculo, 10, 10); // Pinto el contador de circulos creados
        noseve.drawString("Circulos restantes: " + (10 - circulospantalla), 10, 20); // Pinto el contador de circulos restantes
        
        try { // Capturo la excepcion ConcurrentModificationException
            for (Circulo circulo : circulos) { // Recorro el array de circulos
                circulo.paint(noseve); // Llamo al metodo paint de la clase Circulo
            }
        } catch (ConcurrentModificationException e) {
        } // Capturo la excepcion ConcurrentModificationException

        if (!continua) {
            noseve.drawString("GAME OVER", 120, 140); // Si continua es false pinto GAME OVER

        }
        g.drawImage(imagen, 0, 0, this); // Dibujo la imagen en el applet
    }

    public void run() { // Metodo run para el hilo de animacion 
        do { // Bucle do while para que se ejecute el juego 
            contador += TIEMPO; // Sumo el tiempo al contador 
            if (contador >= 2000) { // Si el contador es mayor o igual a 2000
                contador = 0; // Reseteo el contador
                int x = 150; // Establezco la posicion x del circulo
                int y = 150; // Establezco la posicion y del circulo
                int velX = (int) (Math.random() * 5) - 2; // Establezco la velocidad en el eje X
                int velY = (int) (Math.random() * 5) - 2; // Establezco la velocidad en el eje Y
                circulos.add(new Circulo(x, y, velX, velY)); // Añado un nuevo circulo al array de circulos
                circulospantalla++; // Aumento el contador de circulos en pantalla
            }
            try { // Capturo la excepcion ConcurrentModificationException
                for (Circulo circulo : circulos) { // Recorro el array de circulos
                    circulo.update(); // Llamo al metodo update de la clase Circulo
                }
            } catch (ConcurrentModificationException e) {
            } // Capturo la excepcion ConcurrentModificationException


            if (!continua) { // Si continua es false
                repaint(); // Llamo al metodo repaint
                animacion.stop(); // Paro el hilo de animacion
            }
            repaint(); // Llamo al metodo repaint 
            try { // Capturo la excepcion InterruptedException
                Thread.sleep(TIEMPO); // Hago que el hilo de animacion duerma durante el tiempo establecido
            } catch (InterruptedException e) {
            }  // Capturo la excepcion InterruptedException
        } while (true); // Bucle infinito 
    }

    @Override
    public boolean mouseDown(Event evt, int x, int y) { // Metodo mouseDown que recibe un objeto de la clase Event y dos enteros
        for (Circulo circulo : circulos) { // Recorro el array de circulos 
            if (circulo.contains(x, y)) { // Si el click esta dentro del circulo
                if (circulo.numero < 5) { // Si el numero del circulo es menor que 5
                    circulo.numero++; // Aumento el numero del circulo
                } else { // Si el numero del circulo es igual a 5
                    circulos.remove(circulo); // Elimino el circulo del array de circulos
                    contadorcirculo++; // Aumento el contador de circulos
                    circulospantalla--; // Disminuyo el contador de circulos en pantalla
                }
            }
        }
        if(circulospantalla == 10){ // Si el contador de circulos en pantalla es igual a 10
            continua = false; // Cambio la variable continua a false
        }
        return true; // Devuelvo true
    }
}
