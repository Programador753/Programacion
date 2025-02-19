package Segunda.Ejercicio16;

import java.applet.Applet; // Importamos la clase Applet
import java.awt.Color; // Importamos la clase Color
import java.awt.Event; // Importamos la clase Event
import java.awt.Graphics; // Importamos la clase Graphics
import java.awt.Image; // Importamos la clase Image
import java.util.ArrayList; // Importamos la clase ArrayList

public class Marcianitos  extends Applet implements Runnable { // Clase Marcianitos que hereda de la clase Applet e implementa la interfaz Runnable 
    public static final int TIEMPO = 35; // Variable de tiempo
    Thread animacion; // Hilo de animacion
    Image imagen; // Imagen para animar 
    Graphics noseve; // Objeto de la clase Graphics 
    Gun gun; // Objeto de la clase Gun
    ArrayList<Bala> balas; // ArrayList de balas para almacenar las balas 
    ArrayList<Nave> naves;  // ArrayList de naves para almacenar las naves
    
    boolean continua = true; // Variable booleana para saber si el juego continua
    int contador = 0; // Contador para saber cuando crear una nueva nave
    
    public void init(){  // Metodo init para inicializar el applet
        imagen = this.createImage(300, 300); // Creo una imagen de 300x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve 
        gun = new Gun(); // Creo un objeto de la clase Gun 
        balas = new ArrayList<Bala>(); // Creo un array de balas
        naves = new ArrayList<Nave>(); // Creo un array de naves
        for(int i = 0; i < 10; i++) // Bucle para añadir 10 naves al array de naves 
            naves.add(new Nave()); // Añado 10 naves al array de naves
        
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
        noseve.setColor(Color.BLACK); // Establezco el color de noseve que es el fondo del applet
        noseve.fillRect(0, 0, 300, 300); // Relleno el fondo del applet con el color 
        gun.dibujar(noseve); // Dibujo la gun con el objeto noseve
        for(Bala bala : balas) // Bucle para recorrer el array de balas
            bala.paint(noseve); // Pinto las balas con el objeto noseve
        
        for(Nave nave : naves) // Bucle para recorrer el array de naves
            nave.paint(noseve); // Pinto las naves con el objeto noseve
        
        if(!continua) noseve.drawString("GAME OVER", 120, 140); // Si continua es false pinto GAME OVER
        g.drawImage(imagen, 0, 0, this); // Dibujo la imagen en el applet
    }
    public void run(){ // Metodo run para el hilo de animacion 
        do{ // Bucle do while para que se ejecute el juego 
            contador += TIEMPO; // Sumo el tiempo al contador 
            if(contador >= 3000){ // Si el contador es mayor o igual a 3000 
                contador = 0; // Establezco el contador a 0
                naves.add(new Nave()); // Añado una nueva nave al array de naves 
            }
            for(Bala bala : balas) // Bucle para recorrer el array de balas 
                if(bala.update()){ // Si la bala se sale de la pantalla 
                    balas.remove(bala); // Elimino la bala del array de balas 
                    break; // Salgo del bucle 
                } 
            for(Nave nave : naves) // Bucle para recorrer el array de naves 
                nave.update(); // Actualizo la nave 
            
            boolean salir = false; // Variable booleana para saber si salir del bucle
            for(Bala bala : balas){ // Bucle para recorrer el array de balas
                for(Nave nave : naves) // Bucle para recorrer el array de naves
                    if(bala.intersects(nave)){ // Si la bala interseca con la nave
                        naves.remove(nave); // Elimino la nave del array de naves
                        salir = true; // Establezco la variable salir a true
                        break; // Salgo del bucle 
                    }
                if(salir){ // Si salir es true 
                    balas.remove(bala); // Elimino la bala del array de balas
                    break; // Salgo del bucle 
                }
            }
            
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
    
    
    public boolean mouseMove(Event e, int x, int y){ // Metodo mouseMove que recibe un objeto de la clase Event y dos enteros x e y
        gun.actualizar(x); // Actualizo la posicion de la gun con el entero x 
        return true;  // Devuelvo true 
    }
    public boolean mouseDown(Event e, int x, int y){ // Metodo mouseDown que recibe un objeto de la clase Event y dos enteros x e y
        balas.add(new Bala(x)); // Añado una nueva bala al array de balas para disparar
        return true; // Devuelvo true 
    }
}