package Segunda.Ejercicio18;

import java.applet.Applet; // Importo clase Applet
import java.awt.Color; // Importo clase color
import java.awt.Graphics; // Importo clase Graphics 
import java.awt.Image; // Importo clase Image
import java.awt.Event; // Importamos la clase Event
import java.util.ArrayList; // Importo la clase ArrayList
import java.util.ConcurrentModificationException; // Importo clase para control de la excepcion



public class Juegorana extends Applet implements Runnable {
    public static final int TIEMPO = 35; // Variable de tiempo
    Thread animacion; // Hilo de animacion
    Image imagen; // Imagen para animar 
    Graphics noseve; // Objeto de la clase Graphics
    int tiempoAleatorio; // Variable para tiempo aleatorio
    Rana rana; // Objeto de la clase rana
    ArrayList<Coche>coches; // Lista de coches 
    

    
    boolean continua = true; // Variable booleana para saber si el juego continua
    int contador = 0; // Contador para nuevo coche
    
    public void init(){  // Metodo init para inicializar el applet
        imagen = this.createImage(500, 300); // Creo una imagen de 500x300
        noseve = imagen.getGraphics(); // Asigno la imagen a noseve 
        rana = new Rana(); // Creo una nueva rana
        coches = new ArrayList<Coche>(); // Instancio una nueva lista de coches.
        coches.add(crearCoche());// LLamamos a crear coche.
        
        tiempoAleatorio = (int)(Math.random()*500)+500; // Calculo tiempo aleatorio
        this.setSize(500,300); // Establezco el tamaño del applet
    }

    public Coche crearCoche() { // Metodo para crear el coche.
        int velocidad = (int)(Math.random()*3) + 3; // Velocidad aleatoria
        if(Math.random() < 0.5){ // Valor aleatorio para direccion de coche 
            return new Coche(-40,(int)(Math.random()*80) + 150, velocidad); // Creo un nuevo coche y le asigno una posicion y velocidad aleatoria
        }else{
            return new Coche(500,(int)(Math.random()*80) + 50, -velocidad); // Creo un nuevo coche y le asigno una posicion y velocidad aleatoria
        }
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
        rana.paint(noseve); // Pinto la rana
        for(Coche c: coches) // Recorro la lista de coches
            c.paint(noseve); // Pinto el coche
        
        if(!continua) noseve.drawString("GAME OVER", 120, 140); // Si continua es false pinto GAME OVER
        g.drawImage(imagen, 0, 0, this); // Dibujo la imagen en el applet
    }
    
    public void run(){ // Metodo run para el hilo de animacion 
        do{
            
            contador += TIEMPO; // Sumo el tiempo al contador            
            if(contador >= tiempoAleatorio){ 
                contador = 0; // Pongo el contador a 0
                tiempoAleatorio = (int)(Math.random()*500)+500; // Calculo tiempo aleatorio
                coches.add(crearCoche());// LLamamos a crear coche.
            }
                  
            try{ 
                for(Coche coche: coches){ // Recorro la lista coches
                    if(coche.update()) // LLamo a update de obstaculo
                        coches.remove(coche); // Elimino el obstáculo
                    if(coche.colision(rana)) // LLamo a update de obstaculo
                        continua = !continua; // Pongo a falso continua
                }
            }catch(ConcurrentModificationException e){} // Manejo de excepciones
             
            
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
