package Segunda.Ejercicio13;

import java.applet.Applet; // Importo la clase Applet
import java.awt.Color; // Importo la clase Color
import java.awt.Event;
import java.awt.Graphics; // Importo la clase Graphics 
import java.awt.Image; // Importo la clase Image
import java.awt.event.MouseEvent;
import java.util.List; // Importo la clase List
import java.util.ArrayList; // Importo la clase ArrayList

public class Jugando extends Applet implements Runnable{ // Clase jugando que hereda de la clase Applet e implementa la interfaz Runnable
    Thread animacion; // Creo un hilo
    Image imagen; // Creo una imagen
    Graphics noseve; // Creo un objeto de la clase Graphics 
    List<Pelota> pelotas; // Creo un objeto de la clase Pelota 
    
    public void init(){ // Metodo init para vida del applet
        imagen = this.createImage(400, 400); // Creo una imagen
        noseve = imagen.getGraphics(); // Obtiene los graficos de la imagen
        pelotas = new ArrayList<Pelota>(); // Instancio un objeto de la clase Pelota
        for(int i = 0; i < 10; i++){ // Bucle for para crear 10 pelotas
            pelotas.add(new Pelota()); // Añado una pelota a la lista
        }
        this.setSize(400, 400); // Asigno un tamaño al applet
    }
    public void update(Graphics g){ // Metodo update para actualizar
        paint(g); // Llamo al metodo paint
    }
    
    @Override
    public void start(){ // Metodo start para iniciar la animacion
        animacion = new Thread(this); // Instancio el objeto animacion
        animacion.start(); // Inicializo el objeto animacion
    }
    @Override
    public void paint(Graphics g){  // Metodo paint para dibujar los rectangulos
        noseve.setColor(Color.black); // Asigno el color de fondo negro
        noseve.fillRect(0, 0, 400, 400); // Dibujo un rectangulo blanco
        for(int i = 0; i < pelotas.size(); i++){ // Bucle for para crear 10 pelotas
            pelotas.get(i).paint(noseve); // Llamo al metodo paint de la clase pelota
        }
        g.drawImage(imagen, 0, 0, this); // Dibujo la imagen
    }
    @Override
    public void run(){
        do{ // Bucle do while
            for(int i = 0; i < pelotas.size(); i++){ // Bucle for para crear 10 pelotas
                pelotas.get(i).update(); // Llamo al metodo update de la clase pelota
            }
            repaint(); // Repinto la pelota
            try { // Manejo de excepciones 
                Thread.sleep(30); // Tiempo de espera
            } catch (InterruptedException ex) {} // Excepcion a manejar 
        }while(true); // Bucle infinito 
    }

    // Metodo para borrar pelota si hacemos click sobre ella
    public boolean mouseDown(Event ev, int x, int y){
        for(int i = 0; i < pelotas.size(); i++) // Bucle for para crear 10 pelotas
            if(pelotas.get(i).contains(x, y)) // Si la pelota contiene las coordenadas
                pelotas.remove(i); // Borro la pelota
        return true; // Devuelve verdadero
    }
}
