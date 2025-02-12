package Segunda.Ejercicio16;

import java.applet.Applet; // Importo clase Color
import java.awt.Color;  // Importo clase Event
import java.awt.Event; // Importo clase Graphics
import java.awt.Graphics; // Importo clase Image
import java.awt.Image; // Importo clase ArrayList
import java.util.ArrayList; // Importo clase Applet


public class Marcianitos extends Applet implements Runnable {
    public static final int FILAS = 8; // Creo una constante FILAS con valor 5
    public static final int COLUMNAS = 10; // Creo una constante COLUMNAS con valor 10
    public static final int DERECHA = 0; // Creo una constante DERECHA con valor 0
    public static final int IZQUIERDA = 1; // Creo una constante IZQUIERDA con valor 1
    Thread animacion; // Creo un hilo de ejecucion
    Image imagen; // Creo una imagen
    Graphics noseve; // Creo un objeto de la clase Graphics
    Gun gun; // Creo un objeto de la clase Gun
    ArrayList<Bala> bala; // Creo una lista de balas
    ArrayList<Nave> naves; // Creo una lista de naves
    public static int direccion = DERECHA; // Creo una variable direccion con valor DERECHA

    public void init() { // Metodo para inicializar
        setSize(800, 600); // Establecemos el tamaño
        imagen = createImage(800, 600); // Creamos una imagen
        noseve = imagen.getGraphics(); // Obtenemos los graficos de la imagen
        gun = new Gun(400, 500); // Creamos un objeto de la clase Gun
        bala = new ArrayList<Bala>(); // Creamos una lista de balas
        naves = new ArrayList<Nave>(); // Creamos una lista de naves
        for (int i = 0; i < FILAS; i++) { // Recorremos las filas
            for (int j = 0; j < COLUMNAS; j++) { // Recorremos las columnas
                naves.add(new Nave(j * 50, i * 50)); // Añadimos una nave
                
            }
        }
    }

    public void start() { // Metodo para iniciar
        animacion = new Thread(this); // Creamos un hilo de ejecucion
        animacion.start(); // Iniciamos el hilo
    }

    public void stop() { // Metodo para detener
        animacion.stop(); // Detenemos el hilo
    }

    public void paint(){
        noseve.setColor(Color.BLACK); // Establecemos el color
        noseve.fillRect(0, 0, 800, 600); // Dibujamos un rectangulo
        gun.paint(noseve); // Dibujamos la gun
        for (int i = 0; i < bala.size(); i++) { // Recorremos la lista de balas
            bala.get(i).paint(noseve); // Dibujamos la bala
        }
        for (int i = 0; i < naves.size(); i++) { // Recorremos la lista de naves
            naves.get(i).paint(noseve); // Dibujamos la nave
        }
        repaint(); // Llamamos al metodo repaint
    }

    public void update(Graphics g) { // Metodo para actualizar
        paint(); // Llamamos al metodo paint
        g.drawImage(imagen, 0, 0, this); // Dibujamos la imagen
    }

    public void run() { // Metodo run
        while (true) { // Bucle infinito
            for (int i = 0; i < bala.size(); i++) { // Recorremos la lista de balas
                bala.get(i).update(); // Actualizamos la bala
                if (bala.get(i).y < 0) { // Si la bala llega al limite
                    bala.remove(i); // Eliminamos la bala
                }
            }
            for (int i = 0; i < naves.size(); i++) { // Recorremos la lista de naves
                naves.get(i).mover(direccion); // Movemos la nave
            }
            for (int i = 0; i < bala.size(); i++) { // Recorremos la lista de balas
                for (int j = 0; j < naves.size(); j++) { // Recorremos la lista de naves
                    if (naves.get(j).colision(bala.get(i))) { // Si hay colision
                        bala.remove(i); // Eliminamos la bala
                        naves.remove(j); // Eliminamos la nave
                    }
                }
            }
            repaint(); // Llamamos al metodo repaint

            try { // Capturamos excepcion
                Thread.sleep(100); // Dormimos el hilo
            } catch (InterruptedException e) {}
        }
    }

    public boolean keyDown(Event e, int tecla) { // Metodo para cuando se pulsa una tecla
        if (tecla == Event.RIGHT) { // Si la tecla es derecha
            gun.mover(DERECHA); // Movemos la gun a la derecha
            direccion = DERECHA; // Establecemos la direccion
        } else if (tecla == Event.LEFT) { // Si la tecla es izquierda
            gun.mover(IZQUIERDA); // Movemos la gun a la izquierda
            direccion = IZQUIERDA; // Establecemos la direccion
        } else if (tecla == 32) { // Si la tecla es espacio
            bala.add(new Bala(gun.x + 25, gun.y)); // Añadimos una bala
        }
        return true; // Devolvemos true
    }

}
