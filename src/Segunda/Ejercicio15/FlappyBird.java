package Segunda.Ejercicio15;

import java.applet.Applet; // Importo clase Applet
import java.awt.Color; // Importo clase Graphics
import java.awt.Event; // Importo clase Image
import java.awt.Graphics; // Importo clase Color
import java.awt.Image; // Importo clase Event


public class FlappyBird extends Applet implements Runnable {
    
    Thread animacion; // Creo un hilo de ejecucion
    Image imagen; // Creo una imagen
    Graphics noseve; // Creo un objeto de la clase Graphics
    Pajaro pajaro; // Creo un objeto de la clase Pajaro
    Columna[] columnas; // Creo un array de objetos de la clase Columna
    
    @Override
    public void init() { // Metodo init para inicializar
        imagen = createImage(300, 300); // Creo una imagen de 300x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve
        this.setSize(300, 300); // Asigno tamaño al applet
        pajaro = new Pajaro(10, 0, 15, 15); // Creo un objeto de la clase Pajaro
        columnas = new Columna[300 / (Columna.ANCHO + 50)]; // Creo un array de objetos de la clase Columna
        for (int i = 0; i < columnas.length; i++) { // Bucle para recorrer el array de columnas
            columnas[i] = new Columna(300 + i * (Columna.ANCHO + 50), 0, (int) (Math.random() * 200) + 50); // Creo un objeto de la clase Columna con separación adicional
        }
    }

    public void animacion() { // Metodo animacion para actualizar el estado del juego
        pajaro.actualizar(); // Actualizo el estado del pajaro
        if (pajaro.y > 300) // Si la posicion y del pajaro es mayor que 300
            pajaro.y = 0; // La posicion y del pajaro es 0
        for (Columna columna : columnas) { // Bucle para recorrer el array de columnas
            columna.mover(); // Muevo las columnas
            if (columna.colision(pajaro)) { // Si hay colision entre las columnas y el pajaro
                pajaro.y = 0; // La posicion y del pajaro es 0
                for (int j = 0; j < columnas.length; j++) { // Bucle para recorrer el array de columnas
                    columnas[j] = new Columna(300 + j * (Columna.ANCHO + 50), 0, (int) (Math.random() * 200) + 50); // Creo un objeto de la clase Columna con separación adicional
                }
            }
        }
    }

    @Override
    public void paint(Graphics g) { // Metodo paint para dibujar
        noseve.setColor(Color.black); // Asigno color negro
        noseve.fillRect(0, 0, 300, 300); // Relleno el fondo de negro
        pajaro.paint(noseve); // Llamo al metodo paint de la clase Pajaro
        for (Columna columna : columnas) { // Bucle para recorrer las columnas
            columna.paint(noseve); // Pinto las columnas
        }
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
    public boolean keyDown(Event e, int tecla) { // Metodo keyDown para mover el pajaro
        if (tecla == Event.UP) // Si la tecla es la flecha arriba
            pajaro.saltar();
        return true;
    }

    @Override
    public void run() { // Metodo run para ejecutar el hilo
        do {
            animacion(); // Llamo al metodo animacion
            repaint(); // Llamo al metodo repaint
            try {
                Thread.sleep(20); // Hago una pausa de 20 milisegundos
            } catch (InterruptedException e) {}
        } while (true); // Bucle infinito
    }
}
