/*
Dibujar líneas, rectángulos u óvalos
 */
package Segunda.Ejercicio10;



import java.awt.Event; // Importo clase Eventos
import java.awt.Frame; // Importo clase Frame
import java.awt.Menu; // Importo clase Menu
import java.awt.MenuBar; // Importo clase MenuBar
import java.awt.MenuItem; // Importo clase menuItem




public class DibujarApp extends Frame{ 
    MiCanvas canvas; // Declaro objeto de la clase MiCanvas
    public static void main(String arg[]){
        DibujarApp app = new DibujarApp(); // Instancio nuevo objeto de la clase FrameApp    
    }
    
    public DibujarApp() { // Metodo constructor
        super("Dibujar"); // Titulo de la ventana
       
        setup(); // Llamada a metodo setup
        
        
        this.pack(); // Empaquetar contenido
        this.setSize(400,400); // Tamaño de la ventana
        this.setVisible(true); // Hacerla visible
    }
    
    public void setup(){
        setupMenuBar(); // LLamo a metodo menu 
        canvas = new MiCanvas(DosPuntos.LINEA);  // Instancio objeto de la clase MiCanvas
        this.add("Center", canvas); // Añado el canvas al centro del frame
    }
    
    private void setupMenuBar() { // Metodo para menu
        MenuBar menuBar = new MenuBar(); // Nuevo objeto menuBar
        Menu menu1 = new Menu("Fichero"); // Nuevo menu 
        menu1.add(new MenuItem("Nuevo")); // Añado un nuevo elemento al menu
        menu1.addSeparator(); // Añado separador al menu 
        menu1.add(new MenuItem("Salir")); // Añado un nuevo elemento al menu
        menuBar.add(menu1); // Añado el menu al menuBar
        Menu menu2 = new Menu("Dibujar"); // Opcion de menu dibujar
        menu2.add(new MenuItem("Línea")); // Añado un nuevo elemento al menu
        menu2.add(new MenuItem("Óvalo")); // Añado un nuevo elemento al menu
        menu2.add(new MenuItem("Rectángulo")); // Añado un nuevo elemento al menu
        menuBar.add(menu2); // Añado el menu al menuBar
        this.setMenuBar(menuBar); // Meto el menuBar al frame
    }
    
    public boolean handleEvent(Event ev) {  // Control de eventos 
        if(ev.id == Event.WINDOW_DESTROY) // Control de evento para cerrar la ventana 
        {
            System.exit(0); // Cerrar ventana.
            return true; // Devuelve verdadero
        }else if(ev.id == Event.ACTION_EVENT){ // Miro si es evento de accion 
            if(ev.target instanceof MenuItem){ // Si es un elemento del menu
                if(ev.arg.equals("Salir")){ // Si el elemento es salir 
                    System.exit(0); // Cerrar ventana
                    return true; // Devuelvo verdadero
                }else if(ev.arg.equals("Línea")){ // Si el elemento es Línea
                    canvas.setTipo(DosPuntos.LINEA); // Cambio el tipo de dibujo a linea
                    return true; // Devuelvo verdadero
                }else if(ev.arg.equals("Óvalo")){ // Si el elemento es Óvalo
                    canvas.setTipo(DosPuntos.OVALO); // Cambio el tipo de dibujo a ovalo
                    return true; // Devuelvo verdadero
                }else if(ev.arg.equals("Rectángulo")){ // Si el elemento es Rectángulo
                    canvas.setTipo(DosPuntos.RECTANGULO); // Cambio el tipo de dibujo a rectangulo
                    return true; // Devuelvo verdadero
                }else if(ev.arg.equals("Nuevo")){ // Si el elemento es Nuevo borramos el contenido
                    // canvas.getGraphics().clearRect(0, 0, 400, 400); 
                    canvas.getLista().clear(); // Borro la lista
                    canvas.repaint(); // Repinto el canvas
                    return true; // Devuelvo verdadero
                }
            }
        }
        return false; // Devuelve falso
    }
}
