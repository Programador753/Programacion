package Examen;

import java.applet.Applet; // Importo clase Applet
import java.awt.Color; // Importo clase color
import java.awt.Graphics; // Importo clase Graphics
import java.awt.Image; // Importo clase Image
import java.util.ArrayList; // Importo clase ArrayList
import java.util.ConcurrentModificationException; // Importo clase ConcurrentModificationException
import java.awt.Event; // Importo clase Event

/*
Este es un juego en el que 4 naves, cada una de un color y de forma cuadrada, se mueven en el eje de las “x”, rebotando.  Todas van a la misma velocidad, pero se sitúan a diferentes alturas. 
En la parte inferior hay 4 puestos de ametralladora (no se mueven), cada ametralladora es de un color.
Las ametralladoras lanzan balas de su mismo color y lo hacen cuando el usario hace click en la ametralladora, cada click una bala.
Las balas salen disparadas en línea recta y con trayectoria ascendente y si impactan contra una nave de su mismo color, la nave aumenta su tamaño.
 */
public class Ejercicio1 extends Applet implements Runnable {
    public static final int TIEMPO = 35; // Variable de tiempo
    Thread animacion; // Hilo de animacion
    Image imagen; // Imagen para animar
    Graphics noseve; // Objeto de la clase Graphics
    ArrayList<Naves> naves; // Array de objetos de la clase Naves
    ArrayList<Gun> guns; // Array de objetos de la clase Gun 
    ArrayList<Bala> balas; // Array de objetos de la clase Bala
    

    boolean continua = true; // Variable booleana para saber si el juego continua
    int contador = 0; // Contador para saber cuando crear una nueva nave

    public void init() { // Metodo init para inicializar el applet
        imagen = this.createImage(300, 300); // Creo una imagen de 300x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve
        naves = new ArrayList<Naves>(); // Inicializo el array de naves
        guns = new ArrayList<Gun>(); // Inicializo el array de guns
        balas = new ArrayList<Bala>(); // Inicializo el array de balas
        for (int i = 0; i < 4; i++) { // Bucle for para crear 4 naves
            naves.add(new Naves(20, 20 + i * 50)); // Añado una nueva nave al array de naves
        }
        for (int i = 0; i < 4; i++) { // Bucle for para crear 4 guns
            guns.add(new Gun(20 + i * 60, 300)); // Añado una nueva gun al array de guns
        }
            

        
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

        for(Naves nave : naves){ // Recorro el array de naves
            nave.paint(noseve); // Llamo al metodo paint de la clase Naves
        }
        for(Gun gun : guns){ // Recorro el array de guns
            gun.paint(noseve); // Llamo al metodo paint de la clase Gun
        }
        for(Bala bala : balas){ // Recorro el array de balas
            bala.paint(noseve); // Llamo al metodo paint de la clase Bala
        }

        if (!continua) {
            noseve.drawString("GAME OVER", 120, 140); // Si continua es false pinto GAME OVER

        }
        g.drawImage(imagen, 0, 0, this); // Dibujo la imagen en el applet
    }

    public void run() { // Metodo run para el hilo de animacion 
        do { // Bucle do while para que se ejecute el juego 
            contador += TIEMPO; // Sumo el tiempo al contador 
            for(Naves nave : naves){ // Recorro el array de naves
                nave.update(); // Llamo al metodo update de la clase Naves
            }
            
            try{ 
                for(Bala bala : balas){ // Recorro el array de balas
                    bala.update(); // Llamo al metodo update de la clase Bala
                    for(Naves nave : naves){ // Recorro el array de naves
                        if(nave.colisiona(bala)){ // Si la nave colisiona con la bala aumenta su tamaño
                            nave.width += 5; // Aumento el ancho de la nave
                            nave.height += 5; // Aumento el alto de la nave
                            balas.remove(bala); // Elimino la bala del array de balas
                        }
                    }
                }
            }catch(ConcurrentModificationException e){} // Manejo de excepciones

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

    public boolean mouseDown(Event evt, int x, int y) { // Metodo mouseDown que recibe un objeto de la clase Event y dos enteros
        if (continua) { // Si continua es true
            for (Gun gun : guns) { // Recorro el array de guns
                if (gun.inside(x, y)) { // Si el click esta dentro de la gun
                    balas.add(new Bala(gun.x + Gun.ANCHURA / 2, gun.color)); // Añado una nueva bala al array de balas
                }
            }
        }
        return true; // Devuelvo true
    }
}
