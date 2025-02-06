package Segunda.Ejercicio14;

import java.applet.Applet; // Importo clase Applet
import java.awt.Color; // Importo la clase Color
import java.awt.Event; // Importo la clase Graphics
import java.awt.Graphics; // Importo la clase Image
import java.awt.Image; // Importo la clase List
import java.util.ArrayList; // Importo la clase Event

public class Arcanoi extends Applet implements Runnable { // Clase Arcanoi extendida de la clase Applet e implementa la interfaz Runnable
    public static final int FILAS = 8; // Creo una constante FILAS con valor 5
    public static final int COLUMNAS = 10; // Creo una constante COLUMNAS con valor 10
    public static final int DERECHA = 0; // Creo una constante DERECHA con valor 0
    public static final int IZQUIERDA = 1; // Creo una constante IZQUIERDA con valor 1
    Thread animacion; // Creo un hilo de ejecucion
    Image imagen; // Creo una imagen
    Graphics noseve; // Creo un objeto de la clase Graphics
    ArrayList<Ladrillo> ladrillos; // Creo una lista de ladrillos
    Color colores[] = {Color.red, Color.blue, Color.green, Color.white, Color.orange, Color.yellow, Color.pink, Color.cyan}; // Creo un array de colores
    Raqueta raqueta; // Creo un objeto de la clase Raqueta
    Pelota pelota; // Creo un objeto de la clase Pelota

    @Override
    public void init () { // Metodo init para inicializar
        imagen = createImage(300, 300); // Creo una imagen de 300x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve
        ladrillos = new ArrayList<>(); // Creo una lista de ladrillos
        this.setSize(300, 300); // Asigno tamaño al applet
        for (int i = 0; i < FILAS; i++) { // Bucle for para crear 5 filas de ladrillos
            for (int j = 0; j < COLUMNAS; j++)  // Bucle for para crear 10 ladrillos
                ladrillos.add(new Ladrillo((Ladrillo.ANCHURA + 2) * j, (Ladrillo.ALTURA + 4) * i, colores[i])); // Añado un ladrillo a la lista
        }
        raqueta = new Raqueta(); // Creo un objeto de la clase Raqueta
        pelota = new Pelota(); // Creo un objeto de la clase Pelota

    }
    @Override
    public void update(Graphics g) { // Metodo update para actualizar
        noseve.setColor(Color.black); // Asigno color negro
        noseve.fillRect(0, 0, 300, 300); // Relleno el fondo de negro
        paint(noseve); // Llamo al metodo paint
        raqueta.paint(noseve); // Llamo al metodo paint de la clase Raqueta
        pelota.paint(noseve); // Llamo al metodo paint de la clase Pelota
        g.drawImage(imagen, 0, 0, this); // Dibujo la imagen

    }
    @Override
    public void start() { // Metodo start para iniciar el hilo
        if (animacion == null) { // Si el hilo es nulo
            animacion = new Thread(this); // Creo un nuevo hilo
            animacion.start(); // Inicio el hilo
        }
    }

    @Override
    public void stop() { // Metodo stop para parar el hilo
        if (animacion != null) { // Si el hilo no es nulo
            animacion.stop(); // Paro el hilo
            animacion = null; // Asigno el hilo a nulo
        }
    }

    public void gameover() { // Metodo gameover para mostrar un mensaje de fin de juego
        noseve.setColor(Color.red); // Asigno color rojo
        noseve.drawString("GAME OVER", 100, 150); // Escribo GAME OVER
        stop(); // Llamo al metodo stop
    }

    public void win(){ // Metodo win para mostrar un mensaje de victoria y sacar puntos
        noseve.setColor(Color.green); // Asigno color verde
        noseve.drawString("YOU WIN", 100, 150); // Escribo YOU WIN
        noseve.drawString("1000 POINTS", 100, 170); // Escribo 1000 POINTS
        stop(); // Llamo al metodo stop

    }

    public void animacion() { // Metodo animacion para mover la pelota y comprobar colisiones con la raqueta y ladrillos y rebotes en los bordes
        pelota.mover(); // Llamo al metodo mover de la clase Pelota
        if (pelota.intersects(raqueta)) // Si la pelota choca con la raqueta
            pelota.velY = -pelota.velY; // Cambio la direccion en Y
        for (Ladrillo ladrillo : ladrillos) { // Bucle for para recorrer la lista de ladrillos
            if (pelota.intersects(ladrillo)) { // Si la pelota choca con un ladrillo
                ladrillos.remove(ladrillo); // Elimino el ladrillo
                pelota.velY = -pelota.velY; // Cambio la direccion en Y
                break; // Salgo del bucle
            }
        }
    }

    @Override
    public void paint(Graphics g) { // Metodo paint para dibujar los ladrillos
        for (int i = 0; i < ladrillos.size(); i++) // Bucle for para crear 50 ladrillos
            ladrillos.get(i).paint(g); // Llamo al metodo paint de la clase Ladrillo
        if(pelota.y >= 290) // Si la pelota llega al final inferior
            gameover(); // Llamo al metodo gameover
        if (ladrillos.isEmpty()) // Si la lista de ladrillos esta vacia
            win(); // Llamo al metodo win
        else
            pelota.paint(g); // Llamo al metodo paint de la clase Pelota
    }

    @Override
    public void run() { // Metodo run para ejecutar el hilo
        do{
            animacion(); // Llamo al metodo animacion
            repaint(); // Llamo al metodo repaint
            try {
                Thread.sleep(20); // Hago una pausa de 20 milisegundos
            } catch (InterruptedException e) {}
        } while (true); // Bucle infinito
    }


    public boolean keyDown(Event e, int tecla) { // Metodo keyDown para mover la raqueta
        if (tecla == Event.RIGHT) // Si la tecla es la flecha derecha
            raqueta.setX(DERECHA); // Llamo al metodo setX de la clase Raqueta
        if (tecla == Event.LEFT) // Si la tecla es la flecha izquierda
            raqueta.setX(IZQUIERDA); // Llamo al metodo setX de la clase Raqueta
        return true; // Devuelvo verdadero
    }
}
 