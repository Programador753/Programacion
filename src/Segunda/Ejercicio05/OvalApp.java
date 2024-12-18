package Segunda.Ejercicio05;

import java.awt.Button; // Importo clase Boton.
import java.awt.Event; // Importo clase Evento.
import java.awt.Frame; // Importo clase Frame ( Para hacer ventanas ).
import java.awt.Graphics; // Importo clase Graphics ( Para dibujar ).
import java.awt.Panel; // Importo clase Panel.

public class OvalApp extends Frame{
    Ovalo ovalo; // Declaro un nuevo objeto de la clase Ovalo
    public static void main(String arg[]){
        OvalApp app = new OvalApp(); // Instancio nuevo objeto de la clase OvalApp
        
    }
    
    // Metodo constructor de la clase OvalApp
    public OvalApp() {
        super("Dibujando óvalos"); // Titulo de la ventana
        
        ovalo = new Ovalo(); // Instancio el nuevo objeto de la clase Ovalo
        
        Button boton1 = new Button("Siguiente"); // Instancio un nuevo objeto boton de la clase boton 
        Button boton2 = new Button("Salir"); // Instancio un nuevo objeto boton de la clase boton 
        
        Panel panel = new Panel(); // Instancio un nuevo objeto panel de la clase Panel
        
        panel.add(boton1); // Añado el boton al panel 
        panel.add(boton2); // Añado el boton al panel 
        
        this.add("South", panel); // Añado el panel a la ventana 
        
        this.pack(); // Empaqueto el contenido
        this.resize(300, 300); // Dimensiones de la ventana
        this.show(); // Muestros la ventana 
    }
    // Metodo Pintar 
    public void paint(Graphics g) { 
        ovalo.dibujar(g); // Llamo a metodo dibujar de la clase ovalo 
    }
    // Control de eventos
    public boolean handleEvent(Event ev) { 
        if(ev.id == Event.WINDOW_DESTROY) // Control de evento para cerrar la ventana 
        {
            System.exit(0); // Cerrar ventana.
            return true; // Devuelve verdadero
        }
        else if(ev.id == Event.ACTION_EVENT){ // Es un evento de accion
                if(ev.target instanceof Button) // El evento se ha producido sobre un objeto Boton 
                    if(ev.arg.equals("Salir")){ // El evento se ha producido sobre el boton con argumento Salir
                        System.exit(0); // Cerrar ventana.
                        return true; // Devuelve verdadero
                    }else if(ev.arg.equals("Siguiente")){ // El evento se ha producido sobre el boton con argumento Salir
                        ovalo.inicializar(); // Llamo a inicializar para regenerar los valores del ovalo
                        repaint(); // Redibujo ( Borrar y volver a dibujar)
                        return true; // Devuelve verdadero
                    }
        }
        return false; // Devuelve falso
    }
}
