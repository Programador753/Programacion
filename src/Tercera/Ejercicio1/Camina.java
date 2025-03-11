package Tercera.Ejercicio1;

import java.applet.Applet; // Importo clase Applet
import java.awt.Color; // Importo clase color
import java.awt.Graphics; // Importo clase Graphics 
import java.awt.Image; // Importo clase Image




public class Camina extends Applet implements Runnable {
    public static final int TIEMPO = 35; // Variable de tiempo
    Thread animacion; // Hilo de animacion
    Image imagen; // Imagen para animar 
    Graphics noseve; // Objeto de la clase Graphics
    Image fotogramas[] []; // Imagenes para la animacion
    String lugares[] = {"Guerrillero/g", "Hampon/h", "Vaquero/v"}; // Array de lugares

    
    boolean continua = true; // Variable booleana para saber si el juego continua
    int contador = 0; // Contador para nuevo coche
    
    public void init(){  // Metodo init para inicializar el applet
        imagen = this.createImage(500, 300); // Creo una imagen de 500x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve 
        fotogramas = new Image[3][4]; // Creo un array de 4x4 para los fotogramas
        for(int i = 0; i < 3; i++){ // Bucle para recorrer el array de lugares
            for(int j = 0; j < 4; j++){ // Bucle para recorrer el array de lugares
                fotogramas[i][j] = getImage(getCodeBase(), lugares[i] + j + ".gif"); // Asigno las imagenes a los fotogramas
            }
        }

        this.setSize(500,300); // Establezco el tamaño del applet
    }

    
    public void update(Graphics g){ // Metodo update que recibe un objeto de la clase Graphics
        paint(g); // Llamo al metodo paint con el objeto g 
    }
    public void start(){ // Metodo start para iniciar el hilo de animacion 
        animacion = new Thread(this); // Creo un hilo de animacion 
        animacion.start(); // Inicio el hilo de animacion 
    }
    
    public void paint(Graphics g){ // Metodo paint que recibe un objeto de la clase Graphics 
        noseve.setColor(Color.BLACK); // Fondo de color negro
        noseve.fillRect(0, 0, 300, 300); // Pinto rectangulo 300 * 300
        noseve.drawImage(fotogramas[2][2], 0, 0, 200, 250, this);
        g.drawImage(imagen, 0, 0, this);
    }
    
    public void run(){ // Metodo run para el hilo de animacion 
        do{
            repaint(); // Llamo al metodo repaint 
            try{ // Capturo la excepcion InterruptedException
                Thread.sleep(TIEMPO); // Hago que el hilo de animacion duerma durante el tiempo establecido
            }catch(InterruptedException e){}  // Capturo la excepcion InterruptedException
        }while(true); // Bucle infinito 
    }
}
