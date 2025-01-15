/*
Objetos de java 
 */
package Segunda.Ejercicio08;


import java.awt.Button; // Importo clase Button 
import java.awt.Canvas; // Importo clase Canvas
import java.awt.Checkbox; // Importo clase Checkbox
import java.awt.Choice; // Importo clase Choice
import java.awt.Color; // Importo clase Color
import java.awt.Event; // Importo clase Eventos
import java.awt.FlowLayout; // Importo clase FlowLayout
import java.awt.Frame; // Importo clase Frame
import java.awt.Graphics; // Importo clase Graphics
import java.awt.GridLayout; // Importo clase GridLayout
import java.awt.Label; //  Importo clase Label 
import java.awt.List; // Importo clase List
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
        paneles[1][0].add(new MiChoice(opciones, textArea)); // Añado el select(Choice) al panel 
        
        String deportes[] = {"Atletismo", "Baloncesto", "Tenis", "Esgrima", "Balonmano", "Futbol"}; // Vector desportes para elemento lista de multiple seleccion 
        paneles[1][1].add(new MiLista(deportes, textArea)); // Añado la lista al panel 
        
        paneles[1][2].add(new MiCanvas()); // Añado el canvas al panel 
        
        String alimentos[] = {"Patatas", "Cebollas", "Tomates", "Lechuga"}; // Vector alimentos para checkbox
        paneles[2][0].add(new MiCheckBoxGroup(alimentos)); // Añado el checkbox al panel 
        
        
        for(int i=0; i < 3; i++) // Bucle para recorrer los paneles
            for(int j=0; j < 3; j++) // Bucle para recorrer los paneles
                principal.add(paneles[i][j]); // Añado los paneles al principal
        
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

class MiChoice extends Choice{ // Nueva clase extendida de Choice
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

class MiLista extends List{ // Nueva clase extendida de List
    private final TextArea textoAreaB; // Objeto textoAreaB
    public MiLista(String deps[], TextArea textoArea){ // Metodo constructor con los parametos que espera recibir
        super(5, true); // LLamo al metodo constructor de la superclase mostrando 5 elementos y permitiendo multiple seleccion 
        for(int i = 0; i < deps.length; i++) // Recorro las opciones
            this.add(deps[i]); // Añado la opcion a la lista
        this.textoAreaB = textoArea; // creo una variable desde la que poder trabajar en el action con el contenido de textoAreaB
    }
    public boolean handleEvent(Event ev){ // Control de acciones
        if(ev.id == Event.ACTION_EVENT){ // Pregunto si se a producido el evento de accion (Doble click)
            this.textoAreaB.setText("Doble Click"); // Modifico el textArea si el evento se produce
            return true; // Devuelvo verdadero 
        }else if(ev.id == Event.LIST_SELECT){ // Pregunto si se a producido el evento de accion (Seleccion de elemento)
            this.textoAreaB.setText("Selecciono un elemento"); // Modifico el textArea si el evento se produce
            String elementos[] = this.getSelectedItems(); // Vector para guardar los elementos selecionados 
            String texto = ""; // Variable para guardar el texto que se mostrara con los elementos seleccionados y el retorno de carro 
            for(int i=0; i < elementos.length; i++) // Recorro los elementos seleccionados 
                texto += elementos[i] + "\n"; // Concateno los elementos a una variable con un retorno de carro 
            this.textoAreaB.setText(texto); // Modifico el textArea añadiendo los elementos seleccionados
            return true; // Devuelvo verdadero 
        }else if(ev.id == Event.LIST_DESELECT){ // Pregunto si se a producido el evento de accion (Deseleccion de elemento)
            this.textoAreaB.setText("Deselecciono un elemento"); // Modifico el textArea si el evento se produce
            return true; // Devuelvo verdadero 
        }
        return false; // Devuelvo falso 
    }
}

class MiBoton extends Button{ // Nueva clase extendida de Button
    private final TextArea textoAreaB; // Objeto textoAreaB
    public MiBoton(String texto, TextArea textoArea2){ // Metodo constructor con los parametos que espera recibir
        super(texto); // LLamo al metodo constructor de la superclase
        this.textoAreaB = textoArea2; // creo una variable desde la que poder trabajar en el action con el contenido de textoAreaB
    }
    public boolean action(Event ev, Object obj){ // Control de acciones
        textoAreaB.setText(" "); // Modifico borrando el texto de textArea
        return true; // Devuelvo cierto 
    }
}

class MiTextField extends TextField{ // Nueva clase extendida de TextField
    public MiTextField(String text, int columns){ // Metodo constructor
        super(text, columns); // LLamo al metodo constructor de la superclase
    }
    public boolean action(Event ev, Object obj){ // Control de acciones
        String texto = this.getText(); // Guardo el texto en la variable texto
        this.setText(texto.toUpperCase()); // Modifico el texto guardado 
        return true; // Devuelvo cierto 
    }
}

class MiCanvas extends Canvas{ // Nueva clase extendida de la clase Canvas
    int posx = 20; // posicion del dibujo del canvas en el eje x
    int posy = 20; // posicion del dibujo del canvas en el eje y
    public MiCanvas(){ // Metodo constructor
        super(); // LLamo al metodo constructor de la superclase
        this.setSize(75, 75); // Dimensiones del canvas
        this.setBackground(Color.yellow); // Color de fondo del canvas 
        this.setForeground(Color.red); // Color del contenido del canvas 
        this.setVisible(true); // Hacerla visible 
    }
    public void paint(Graphics g){ // Metodo paint
        g.fillRect(posx, posy, 5, 5); // Dibujo cuadrado 
    }
    public boolean mouseDown(Event ev, int x, int y){ // Evento de click mouse
        posx = x; // Modifico posx a donde haga click con el mouse en el eje x
        posy = y; // Modifico posy a donde haga click con el mouse en el eje y
        repaint(); // LLamo a repaint para pintar el canvas con el cudrado rojo en la nueva posición 
        return true; // Devuelvo cierto
    }
}

class MiCheckBoxGroup extends Panel{ // Nueva clase extendida de la clase Panel
    Checkbox checkBoxes[]; // Objeto CheckBox
    TextField resultado; // Objeto TextField
    
    public MiCheckBoxGroup(String elementos[]){ // Metodo constructor
        
        super(); // LLamo al metodo constructor de la superclase
        this.setLayout(new GridLayout(elementos.length +1, 1)); // Ddeclaro la distribucion del nuevo panel
        checkBoxes = new Checkbox[elementos.length]; // Instancio nuevo checkBoxes para la cantidad de elementos 
        for(int i = 0; i < elementos.length; i++){ // Bucle for para instancia nuevo objeto de la clase checkbox
            checkBoxes[i] = new Checkbox(elementos[i]); // Instancio y cargo los checkBox con los elementos 
            this.add(checkBoxes[i]); // Añado los checkBox al panel 
        }
        resultado = new TextField("", 15); // Instancio el campo de texto 
        this.add(resultado); // Añado resultado al panel 
    }
    public boolean action(Event ev, Object obj){ // Control de acciones
        String mostrar = ""; // String para almacenar lo que se va a mostrar
        for(int i = 0; i < checkBoxes.length; i++) // Bucle for para recorrer elementos de checkBoxes
            if(checkBoxes[i].getState()) // Si el estado es verdadero es que esta marcado 
                mostrar += checkBoxes[i].getLabel() + "  "; // Concateno la etiqueta del elemento del checkbox con mostrar
        resultado.setText(mostrar); // Paso a resultado el contenido de mostrar 
        return false; // Devuelvo cierto
    }
    
}
