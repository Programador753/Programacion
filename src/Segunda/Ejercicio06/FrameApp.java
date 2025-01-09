/*
Manipulamos las características del Frame
 */
package Segunda.Ejercicio06;

import java.awt.Button; // Importo clase Boton
import java.awt.Color;  // Importo clase color
import java.awt.Cursor; // Importo clase cursor
import java.awt.Event; // Importo clase Eventos
import java.awt.Font;   // Importo clase Font
import java.awt.Frame; // Importo clase Frame
import java.awt.Graphics; // Importo clase Graphics
import java.awt.GridLayout; // Importo clase GridLayout (Tablas)
import java.awt.Label; // Importo clase label (Etiquetas)
import java.awt.Menu; // Importo clase menu
import java.awt.MenuBar; // Importo clase MenuBar
import java.awt.MenuItem; // Importar clase MenuItem
import java.awt.Panel; // Importo clase Panel 

public class FrameApp extends Frame{
    MenuBar porDefecto, alternativo; // Defino Nombre menus
    String tituloInicial; // Defino atributo titulo
    int cursores[] = {Cursor.CROSSHAIR_CURSOR, Cursor.DEFAULT_CURSOR, Cursor.E_RESIZE_CURSOR, Cursor.HAND_CURSOR, Cursor.MOVE_CURSOR, Cursor.NE_RESIZE_CURSOR, Cursor.N_RESIZE_CURSOR, Cursor.TEXT_CURSOR, Cursor.WAIT_CURSOR}; // Vector con cursores
    int posCursor = 0;
    Color colores[] = {Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY, Color.GRAY, Color.LIGHT_GRAY, Color.MAGENTA, Color.ORANGE, Color.YELLOW}; // Vector colores
    int posColor = 0;
    String fuentes[] = {"Helvetica", "TimesRoman", "Courier", "Dialog", "DialogInput", "Arial", "Roboto", "Consolas"}; // Vector Fuentes 
    int posLetra = 0;   
    public static void main(String arg[]){
        FrameApp app = new FrameApp(); // Instancio nuevo objeto de la clase FrameApp    
    }
    
    public FrameApp() { // Metodo constructor
        super("Trabajando con Frames"); // Titulo de la ventana
        tituloInicial = this.getTitle();
        setup(); // Llamada a metodo setup
        setupMenu(); // Llamada a metodo setupMenu
        
        this.pack(); // Empaquetar contenido
        this.setSize(400, 400); // Tamaño de la ventana
        this.setVisible(true); // Hacerla visible
    }
    public void paint (Graphics g){
        g.drawString("Cambia el color al pulsar Foreground", 100, 150); // Pinto un texto  
    }
    
    public void setup(){
        Panel principal = new Panel(); // Instancio nuevo panel
        principal.setLayout(new GridLayout(4,1)); // defino nueva distribucion
        
        principal.add(new Label("Cambian las características de la ventana", Label.CENTER)); // Nueva etiqueta y añadirla al panel
        
        Panel panel1 = new Panel(); // Instancio nuevo panel
        panel1.add(new Button("Título")); // Instancio un nuevo objeto boton de la clase boton
        panel1.add(new Button("MenuBar")); // Instancio un nuevo objeto boton de la clase boton
        panel1.add(new Button("Resizable")); // Instancio un nuevo objeto boton de la clase boton
        principal.add(panel1); // Añado el panel 1 al principal
        
        principal.add(new Label("Salidas en la ventana", Label.CENTER)); // Nueva etiqueta y añadirla al panel
        
        Panel panel2 = new Panel(); // Instancio nuevo panel
        panel2.add(new Button("Cursor")); // Instancio un nuevo objeto boton de la clase boton
        panel2.add(new Button("Background")); // Instancio un nuevo objeto boton de la clase boton
        panel2.add(new Button("Foreground")); // Instancio un nuevo objeto boton de la clase boton
        panel2.add(new Button("Font")); // Instancio un nuevo objeto boton de la clase boton
        principal.add(panel2); // Añado el panel 2 al principal
        
        this.add("South", principal); // Añado el panel a la ventana 
    }
    
    private void setupMenu(){
        porDefecto = new MenuBar(); // Barra de menu
        Menu fileMenu = new Menu("File"); // Nuevo menu
        fileMenu.add(new MenuItem("Exit")); // Nuevo elemento del menu
        porDefecto.add(fileMenu); // Añado menu a la barra del menu
        this.setMenuBar(porDefecto); // Añado el menu a la ventana 
        alternativo = new MenuBar(); // Barra de menu
        Menu archivoMenu = new Menu("Archivo"); // Nuevo elemento del menu
        archivoMenu.add(new MenuItem("Salir")); // Nuevo elemento del menu
        alternativo.add(archivoMenu); // Añado menu a la barra del menu
    }
    
    public boolean handleEvent(Event ev) { 
        if(ev.id == Event.WINDOW_DESTROY) // Control de evento para cerrar la ventana 
        {
            System.exit(0); // Cerrar ventana.
            return true; // Devuelve verdadero
        }else if(ev.id == Event.ACTION_EVENT){ // Miro si es evento de accion 
                if(ev.target instanceof Button){ // Si es boton
                    if(ev.arg.equals("Título")){ // Si el boton es Título
                        if(this.getTitle().equals(tituloInicial)) // Si título es igual al inicial cambio
                            this.setTitle("Título Alternativo"); // Texto título cambiado
                        else
                            this.setTitle(tituloInicial); // Título original si no es el inicial
                        return true; // Devuelvo verdadero
                    } 
                    else if(ev.arg.equals("MenuBar")){ // Si el boton es Menu 
                        if(this.getMenuBar().equals(porDefecto)) // Compruebo si el menu es el por defecto
                            this.setMenuBar(alternativo); // Cambio de menu
                        else
                            this.setMenuBar(porDefecto); // Menu original si no es el menu por defecto
                        return true; // Devuelvo verdadero    
                    }
                    else if(ev.arg.equals("Resizable")){ // Si el boton es Resizable
                        this.setResizable(!this.isResizable()); // Modifico al valor contrario de lo que tengo 
                        return true; // Devuelvo verdadero
                    }
                    else if(ev.arg.equals("Cursor")){ // Si el boton es Cursor
                        this.setCursor(cursores[(posCursor++) % cursores.length]); // Modifico el cursor de manera que incremento el valor de posCursores 
                                                                                   // y luego divido entre la longitud y me quedo el resto
                        return true; // Devuelvo verdadero
                    }
                    else if(ev.arg.equals("Foreground")){ // Si el boton es Foreground
                        this.setForeground(colores[(posColor++) % colores.length]); // Modifico el color de foreground
                        return true; // Devuelvo verdadero
                    }
                    else if(ev.arg.equals("Background")){ // Si el boton es Background
                        this.setBackground(colores[(posColor++) % colores.length]); // Modifico el color de foreground
                        return true; // Devuelvo verdadero
                    }
                    else if(ev.arg.equals("Font")){ // Si el boton es Font
                        this.setFont(new Font(fuentes[(posLetra++) % fuentes.length], Font.BOLD, 14)); // Modifico la fuente
                        repaint(); // Repinto
                        return true; // Devuelvo verdadero
                    }
                }
        }
        return false; // Devuelve falso
    }
}
