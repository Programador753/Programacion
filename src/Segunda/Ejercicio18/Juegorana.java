package Segunda.Ejercicio18;

import java.applet.Applet; // Importo clase Applet
import java.awt.Color; // Importo clase color
import java.awt.Graphics; // Importo clase Graphics 
import java.awt.Image; // Importo clase Image
import java.awt.Event; // Importamos la clase Event



public class Juegorana extends Applet implements Runnable {
    public static final int TIEMPO = 35; // Variable de tiempo
    Thread animacion; // Hilo de animacion
    Image imagen; // Imagen para animar 
    Graphics noseve; // Objeto de la clase Graphics
    int tiempoAleatorio = (int)(Math.random()*2000)+2000; // Tiempo aleatorio
    Rana rana; // Objeto de la clase rana
    

    
    boolean continua = true; // Variable booleana para saber si el juego continua
    int contador = 0; // Contador para nuevo coche
    
    public void init(){  // Metodo init para inicializar el applet
        imagen = this.createImage(500, 300); // Creo una imagen de 500x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve 
        rana = new Rana(); // Creo una nueva rana 
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
        noseve.setColor(Color.pink); // Establezco el color de noseve que es el fondo del applet
        noseve.fillRect(0, 0, 500, 300); // Relleno el fondo del applet con el color
        noseve.setColor(Color.black); // Establezco el color de noseve para la linea
        noseve.fillRect(0, 50, 580, 200); // Pinto la linea
        noseve.setColor(Color.WHITE); // color linea
        noseve.drawLine(0, 149, 500, 149); // Pinto la linea
        rana.paint(noseve); // Pinto la ran
        
        if(!continua) noseve.drawString("GAME OVER", 120, 140); // Si continua es false pinto GAME OVER
        g.drawImage(imagen, 0, 0, this); // Dibujo la imagen en el applet
    }
    
    public void run(){ // Metodo run para el hilo de animacion 
        do{
            
            contador += TIEMPO; // Sumo el tiempo al contador 
            tiempoAleatorio = (int)(Math.random()*2000)+2000; // Calculo tiempo aleatorio
            
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
    public boolean keyDown(Event e, int tecla) { // Metodo keyDown para hacer saltar al dinosaurio cuando se pulsa la tecla espacio
        rana.actualizar(tecla); // LLama a actualizar la rana 
        return true; // retorno verdadero 
    }
}
