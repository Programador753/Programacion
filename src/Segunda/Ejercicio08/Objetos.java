/*
Objetos de java 
 */
package Segunda.Ejercicio08;


import java.awt.Event; // Importo clase Eventos
import java.awt.FlowLayout; // Importo clase FlowLayout
import java.awt.Frame; // Importo clase Frame
import java.awt.GridLayout; // Importo clase GridLayout
import java.awt.HeadlessException;
import java.awt.Label; //  Importo clase Label 
import java.awt.Panel; // Importo clase Panel
import java.awt.TextField; // Importo clase TextField



public class Objetos extends Frame{
        
    
    public static void main(String arg[]){
        Objetos app = new Objetos(); // Instancio nuevo objeto de la clase FrameApp    
    }
    
    public Objetos() { // Metodo constructor
        super("Trabajando con objetos de Java"); // Titulo de la ventana
       
        setup(); // Llamada a metodo setup
        
        
        this.pack(); // Empaquetar contenido
        this.setSize(400,400); // Tamaño de la ventana
        this.setVisible(true); // Hacerla visible
    }
    
    public void setup(){
        Panel principal = new Panel(); // Instancio un nuevo objeto Panel
        principal.setLayout(new GridLayout(3,3)); // Declaro distribucion del panel 
        Panel paneles[][] = new Panel [3][3]; // Creo nuevo panel en un array bidimensional 
        for(int i=0; i < 3; i++) 
            for(int j=0; j < 3; j++){
                paneles[i][j] = new Panel(); // Cargo los paneles 
                paneles[i][j].setLayout(new FlowLayout(FlowLayout.LEFT)); // Paneles con alineacion lineal y a izquierda
            }
        paneles[0][0].add(new Label("Campo de texto:")); // Añado una etiqueta
        paneles[0][0].add(new MiTextField("", 15)); // Añado campo de texto 
        principal.add(paneles[0][0]); // Añado el panel [0][0] al principal
        this.add("Center", principal); // Añado el panel principal a la ventana
    }
    
    
    public boolean handleEvent(Event ev) { 
        if(ev.id == Event.WINDOW_DESTROY) // Control de evento para cerrar la ventana 
        {
            System.exit(0); // Cerrar ventana.
            return true; // Devuelve verdadero
        }
        return false; // Devuelve falso
    }
}

class MiTextField extends TextField{ // Nueva clase extendida de TextField
    public MiTextField(String text, int columns){ // Metodo constructor
        super(text, columns); 
    }
    public boolean action(Event ev, Object obj){ // Control de acciones
        String texto = this.getText(); // Guardo el texto en la variable texto
        this.setText(texto.toUpperCase()); // Modifico el texto guardado 
        return true; // Devuelvo cierto 
    }
}
