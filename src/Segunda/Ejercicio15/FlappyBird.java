package Segunda.Ejercicio15;

import java.applet.Applet; // Importo clase Applet 
import java.awt.Graphics; // Importo clase Graphics
import java.awt.Image; // Importo clase Image
import java.awt.Color; // Importo clase Color
import java.awt.Event; // Importo clase Event


public class FlappyBird extends Applet implements Runnable {
    
    Thread animacion; // Creo un hilo de ejecucion
    Image imagen; // Creo una imagen
    Graphics noseve; // Creo un objeto de la clase Graphics
    Pajaro pajaro; // Creo un objeto de la clase Pajaro
    Columna[] columnas; // Creo un array de columnas


    @Override
    public void init() { // Metodo init para inicializar
        imagen = createImage(300, 300); // Creo una imagen de 300x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve
        this.setSize(300, 300); // Asigno tamaño al applet
        pajaro = new Pajaro(10, 0, 15, 15); // Creo un objeto de la clase Pajaro
        columnas = new Columna[300 / Columna.ANCHO]; // Creo un array de columnas
        for (int i = 0; i < columnas.length; i++) { // Bucle para recorrer el array de columnas
            columnas[i] = new Columna(300 + i * Columna.ANCHO * 3, 300, 100 + (int) (Math.random() * 100)); // Creo una columna
        }
        
    }

    @Override
    public void paint(Graphics g) { // Metodo paint para dibujar
        noseve.setColor(Color.black); // Asigno color negro
        noseve.fillRect(0, 0, 300, 300); // Relleno el fondo de negro
        pajaro.paint(noseve); // Llamo al metodo paint de la clase Pajaro
        for (int i = 0; i < 10; i++) {
            columnas[i].paint(noseve);
        }

        g.drawImage(imagen, 0, 0, this); // Dibujo la imagen
    }

    public void animacion() { // Metodo animacion para mover el pajaro y las columnas
        pajaro.actualizar(); // Actualizo la posicion del pajaro
        for (int i = 0; i < columnas.length; i++) { // Bucle para recorrer el array de columnas
            columnas[i].actualizar(); // Actualizo la posicion de la columna
            if (columnas[i].fueraDePantalla()) { // Si la columna esta fuera de la pantalla
                columnas[i].reiniciar(300, 0, 100 + (int) (Math.random() * 100)); // Reinicio la columna
            }
            if (columnas[i].colision(pajaro)) { // Si hay colision entre el pajaro y la columna
                // Manejar colision (por ejemplo, reiniciar el juego)
                pajaro = new Pajaro(10, 0, 15, 15); // Reinicio el pajaro
                for (int j = 0; j < columnas.length; j++) { // Reinicio todas las columnas
                    columnas[j].reiniciar(300 + j * Columna.ANCHO * 3, 0, 100 + (int) (Math.random() * 100));
                }
                break; // Salgo del bucle
            }
        }
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
        do{
            animacion(); // Llamo al metodo animacion
            repaint(); // Llamo al metodo repaint
            try {
                Thread.sleep(20); // Hago una pausa de 20 milisegundos
            } catch (InterruptedException e) {}
        } while (true); // Bucle infinito
    }

    
}
