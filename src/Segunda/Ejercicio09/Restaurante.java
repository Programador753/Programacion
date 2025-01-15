/*
Restaurante 
 */
package Segunda.Ejercicio09;


import java.awt.Event; // Importo clase Eventos
import java.awt.Frame; // Importo clase Frame



public class Restaurante extends Frame{ 
    String comidas[] = {"Desayuno", "Almuerzo", "Cena"};
    String platos[][] = {{"Leche", "Café", "Huevos", "Tostadas", "Mermelada", "Bacon"},
                         {"Paella", "Sopa", "Macarrones","Ensalada", "Filete", "Pescado", "Albóndigas", "Hamburguesa" },
                         {"Torilla", "Sopa", "Hamburguesa", "Ensalada","Pollo", "Bocadillo", "Samdwich"}};
    
    public static void main(String arg[]){
        Restaurante app = new Restaurante(); // Instancio nuevo objeto de la clase FrameApp    
    }
    
    public Restaurante() { // Metodo constructor
        super("Restaurante Salesiano"); // Titulo de la ventana
       
        setup(); // Llamada a metodo setup
        
        
        this.pack(); // Empaquetar contenido
        this.setSize(275,175); // Tamaño de la ventana
        this.setVisible(true); // Hacerla visible
    }
    
    public void setup(){
        
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

