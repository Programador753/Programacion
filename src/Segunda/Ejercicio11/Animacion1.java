/*
Primera animación
 */
package Segunda.Ejercicio11;

import java.awt.Event; // Importo clase Eventos
import java.awt.Frame; // Importo clase Frame
import java.awt.Graphics; // Importo clase Graphics 


public class Animacion1 extends Frame implements Runnable{ 
    Thread animacion; // Objeto de la clase Thread
    String frames[] = {"*", "**", "***", "****", "*****", "******", "*****", "****", "***", "**", "*"}; // Vector de cadenas
    int actual = 0; // Posicion actual 
    public static void main(String arg[]){ 
        Animacion1 app = new Animacion1(); // Instancio nuevo objeto de la clase FrameApp    
    }
    
    public Animacion1() { // Metodo constructor
        super("Animación sencilla"); // Titulo de la ventana
       
        this.pack(); // Empaquetar contenido
        this.setSize(200,200); // Tamaño de la ventana
        this.setVisible(true); // Hacerla visible
        animacion = new Thread(this); // Instanciamos el objeto de la clase Thread
        animacion.start(); // Start llama al metodo run 
    }
    public void paint(Graphics g){ // Metodo paint
        g.drawString(frames[actual], 80, 100); // Dibuja la cadena en la posicion actual
    }


    public boolean handleEvent(Event ev) {  // Control de eventos 
        if(ev.id == Event.WINDOW_DESTROY) // Control de evento para cerrar la ventana 
        {
            System.exit(0); // Cerrar ventana.
            return true; // Devuelve verdadero
        }
        return false; // Devuelve falso
    }

    @Override
    public void run(){ // Metodo run 
        do{ // Bucle do while 
            actual = (actual + 1) % frames.length; // Calcula la posicion actual
            repaint(); // Llama al metodo repaint
            try { // Manejo de excepciones 
                Thread.sleep(300); // Tiempo de espera
            } catch (InterruptedException ex) {} // Excepcion a manejar 
        }while(true); // Bucle infinito 
    }
}
