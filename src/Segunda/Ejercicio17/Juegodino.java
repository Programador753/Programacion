package Segunda.Ejercicio17;

import java.applet.Applet; // Importamos la clase Applet
import java.awt.Color; // Importamos la clase Color
import java.awt.Event; // Importamos la clase Event
import java.awt.Graphics; // Importamos la clase Graphics
import java.awt.Image; // Importamos la clase Image
import java.util.ArrayList; // Importo clase ArrayList


public class Juegodino extends Applet implements Runnable {
    public static final int TIEMPO = 35; // Variable de tiempo
    Thread animacion; // Hilo de animacion
    Image imagen; // Imagen para animar 
    Graphics noseve; // Objeto de la clase Graphics
    Dinosaurio dinosaurio; // Objeto de la clase dinosaurio
    ArrayList<Obstaculo> obstaculos; // Creo un objeto de la clase Columna
    
    boolean continua = true; // Variable booleana para saber si el juego continua
    int contador = 0; // Contador para saber cuando crear una nueva nave
    
    public void init(){  // Metodo init para inicializar el applet
        imagen = this.createImage(300, 300); // Creo una imagen de 300x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve 
        dinosaurio = new Dinosaurio(); // Creo un objeto de la clase dinosaurio
        obstaculos = new ArrayList<Obstaculo>(); // Creo un objeto de la clase ArrayList
        obstaculos.add(new Obstaculo()); // Añado un nuevo obstaculo
        
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
        dinosaurio.dibujar(noseve); // Dibujo el objeto de la clase dinosaurio
        
        for(Obstaculo o : obstaculos){ // Bucle for each para recorrer los obstaculos
            o.paint(noseve); // Dibujo el obstaculo
        }

        if(!continua) noseve.drawString("GAME OVER", 120, 140); // Si continua es false pinto GAME OVER
        g.drawImage(imagen, 0, 0, this); // Dibujo la imagen en el applet
    }
    
    public void run(){ // Metodo run para el hilo de animacion 
        do{ // Bucle do while para que se ejecute el juego
            dinosaurio.actualizar(); // LLamo a actualizar de dinosaurio.
            contador += TIEMPO; // Sumo el tiempo al contador 
            
            if(contador >= 7000){ // Si el contador es mayor o igual a 3000
                obstaculos.add(new Obstaculo()); // Añado un nuevo obstaculo
                contador = 0; // Pongo el contador a 0
            }
            for(Obstaculo o : obstaculos){ // Bucle for each para recorrer los obstaculos
                o.update(); // Llamo al metodo actualizar de obstaculo
            }

            if(!obstaculos.isEmpty()) // Compruebo si la columna esta vacia)
                if(obstaculos.get(0).rect1.x <= -50) // Si la columna llega al final del applet
                    obstaculos.remove(0); // Elimino el obstáculo
            
            continua = !dinosaurio.colision(obstaculos.get(0)); // Continua es falso
            
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
        if(tecla == 32) // Si pulso la tecla espacio
            dinosaurio.setSaltando(true); // Llamo al metodo setSaltando del objeto dinosaurio y le paso true
        return true; // retorno verdadero 
    }
    
}
