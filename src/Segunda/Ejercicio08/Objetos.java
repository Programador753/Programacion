/*
Objetos de java 
 */
package Segunda.Ejercicio08;


import java.awt.Button; // Importo clase Button 
import java.awt.Choice; // Importo clase Choice
import java.awt.Color; // Importo clase Color
import java.awt.Event; // Importo clase Eventos
import java.awt.FlowLayout; // Importo clase FlowLayout
import java.awt.Frame; // Importo clase Frame
import java.awt.GridLayout; // Importo clase GridLayout
import java.awt.Label; //  Importo clase Label 
import java.awt.Panel; // Importo clase Panel
import java.awt.TextArea; // Importo clase TextArea
import java.awt.TextField; // Importo clase TextField



public class Objetos extends Frame{
    TextArea textArea; // Objeto de la clase textArea 
    
    
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
        
        textArea = new TextArea(5,10); // Instancio objeto text area de 5 x 10 
        textArea.setBackground(Color.yellow); // Pongo el color de fondo del textArea
        paneles[0][1].add(textArea); // Añado el textArea al panel 
        
        paneles[0][2].add(new MiBoton("Borrar", textArea)); // Añado el Boton para borrar el textArea al panel 
        
        String opciones[] = {"Sí", "No", "Quizás"}; // Opciones para el choice 
        paneles[1][1].add(new MiChoice(opciones, textArea)); // Añado el select(Choice) al panel 
        
        principal.add(paneles[0][0]); // Añado el panel [0][0] al principal
        principal.add(paneles[0][1]); // Añado el panel [0][1] al principal
        principal.add(paneles[0][2]); // Añado el panel [0][2] al principal
        principal.add(paneles[1][1]); // Añado el panel [1][1] al principal
        
        this.add("Center", principal); // Añado el panel principal a la ventana
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

class MiChoice extends Choice{ // Nueva clase extendida de TextField
    private final TextArea textoAreaB; // Objeto textoAreaB
    public MiChoice(String opciones[], TextArea textoArea2){ // Metodo constructor con los parametos que espera recibir
        super(); // LLamo al metodo constructor de la superclase
        for(int i = 0; i < opciones.length; i++) // Recorro las opciones
            this.add(opciones[i]); // Añado la opcion al choice
        this.textoAreaB = textoArea2; // creo una variable desde la que poder trabajar en el action con el contenido de textoAreaB
    }
    public boolean action(Event ev, Object obj){ // Control de acciones
        textoAreaB.setText(this.getSelectedItem()); // Modifico el textArea
        return true; // Devuelvo cierto 
    }
}

class MiBoton extends Button{ // Nueva clase extendida de Button
    private final TextArea textoAreaB; // Objeto textoAreaB
    public MiBoton(String texto, TextArea textoArea2){ // Metodo constructor con los parametos que espera recibir
        super(texto);
        this.textoAreaB = textoArea2; // creo una variable desde la que poder trabajar en el action con el contenido de textoAreaB
    }
    public boolean action(Event ev, Object obj){ // Control de acciones
        textoAreaB.setText(" "); // Modifico borrando el texto de textArea
        return true; // Devuelvo cierto 
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
