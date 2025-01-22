/*
Primera animación
 */
package Segunda.Ejercicio11;

import java.awt.Event; // Importo clase Eventos
import java.awt.Frame; // Importo clase Frame

public class Animacion1 extends Frame{ 
    
    public static void main(String arg[]){
        Animacion1 app = new Animacion1(); // Instancio nuevo objeto de la clase FrameApp    
    }
    
    public Animacion1() { // Metodo constructor
        super("Animación sencilla"); // Titulo de la ventana
       
        this.pack(); // Empaquetar contenido
        this.setSize(200,200); // Tamaño de la ventana
        this.setVisible(true); // Hacerla visible
    }
    
    public boolean handleEvent(Event ev) {  // Control de eventos 
        if(ev.id == Event.WINDOW_DESTROY) // Control de evento para cerrar la ventana 
        {
            System.exit(0); // Cerrar ventana.
            return true; // Devuelve verdadero
        }
        return false; // Devuelve falso
    }
}
