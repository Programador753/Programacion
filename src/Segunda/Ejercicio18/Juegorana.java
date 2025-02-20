package Segunda.Ejercicio18;

import java.applet.Applet; // Importo clase Applet
import java.awt.Color; // Importo clase color
import java.awt.Graphics; // Importo clase Graphics 
import java.awt.Image; // Importo clase Image




public class Juegorana extends Applet implements Runnable {
    public static final int TIEMPO = 35; // Variable de tiempo
    Thread animacion; // Hilo de animacion
    Image imagen; // Imagen para animar 
    Graphics noseve; // Objeto de la clase Graphics{
    
    boolean continua = true; // Variable booleana para saber si el juego continua
    int contador = 0; // Contador para nuevo coche
    
    public void init(){  // Metodo init para inicializar el applet
        imagen = this.createImage(300, 300); // Creo una imagen de 300x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve 
    
        this.setSize(300,300); // Establezco el tamaño del applet
    }
    
    public void update(Graphics g){ // Metodo update que recibe un objeto de la clase Graphics
        paint(g); // Llamo al metodo paint con el objeto g 
    }
    public void start(){ // Metodo start para iniciar el hilo de animacion 
        animacion = new Thread(this); // Creo un hilo de animacion 
        animacion.start(); // Inicio el hilo de animacion 
    }
    
    public void paint(Graphics g){ // Metodo paint que recibe un objeto de la clase Graphics 
        noseve.setColor(Color.white); // Establezco el color de noseve que es el fondo del applet
        noseve.fillRect(0, 0, 300, 300); // Relleno el fondo del applet con el color
        noseve.setColor(Color.black); // Establezco el color de noseve para la linea
        noseve.drawLine(0, 280, 280, 280); // Pinto la linea
    
        if(!continua) noseve.drawString("GAME OVER", 120, 140); // Si continua es false pinto GAME OVER
        g.drawImage(imagen, 0, 0, this); // Dibujo la imagen en el applet
    }
    
    public void run(){ // Metodo run para el hilo de animacion 
        do{
            
            if(!continua){ // Si continua es false
                repaint(); // Llamo al metodo repaint
                animacion.stop(); // Paro el hilo de animacion
            }
            repaint(); // Llamo al metodo repaint 
            try{ // Capturo la excepcion InterruptedException
                Thread.sleep(TIEMPO); // Hago que el hilo de animacion duerma durante el tiempo establecido
            }catch(InterruptedException e){}  // Capturo la excepcion InterruptedException
        }while(true); // Bucle infinito 
    }
    
}
