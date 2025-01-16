/*
Restaurante 
 */
package Segunda.Ejercicio09;


import java.awt.Choice; // Importo clase Choice
import java.awt.Event; // Importo clase Eventos
import java.awt.Frame; // Importo clase Frame
import java.awt.Label; // Importo clase Label
import java.awt.List; // Importo clase List
import java.awt.TextField; // Importo clase textField



public class Restaurante extends Frame{ 
    String comidas[] = {"Desayuno", "Almuerzo", "Cena"}; // Vector comidas
    String platos[][] = {{"Leche", "Café", "Huevos", "Tostadas", "Mermelada", "Bacon"},
                         {"Paella", "Sopa", "Macarrones","Ensalada", "Filete", "Pescado", "Albóndigas", "Hamburguesa" },
                         {"Torilla", "Sopa", "Hamburguesa", "Ensalada","Pollo", "Bocadillo", "Sandwich"}}; // Vector con los diferentes platos que ofrecen
    Choice chComida; // Creo un objeto de la clase Choice
    List[] listasPlatos; // Creo un vector de la clase List
    List presentar; // Creo un objeto de la clase List
    TextField texto; // Creo un nuevo objeto TextField
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
        this.add("North", new Label("Elige tu comanda", Label.CENTER)); // Añado una nueva etiqueta al frame en la parte superior 
        this.chComida = new Choice(); // Instancio el desplegable chComida
        for(int i=0; i < comidas.length; i++) // Bucle que recorre el vector comidas
            chComida.add(comidas[i]); // Cargamos los datos de comidas en chComida
        this.add("West",chComida); // Añadimos chComida al frame a la izquierda (West)
        this.listasPlatos = new List[comidas.length]; // Instancio el vector listasPlatos con el tamaño de comidas 
        for(int i=0; i < comidas.length; i++){ // Bucle que recorre el vector comidas
            listasPlatos[i] = new List(5,true); // Instanciamos una nueva lista en cada iteracion 
            for(int j=0; j < platos[i].length; j++) // Recorremos platos
                listasPlatos[i].add(platos[i][j]); // Cargamos la lista listasPlatos con los valores de platos
        }
        presentar = listasPlatos[0]; // Instancio la lista presentar
        this.add("East", presentar); // Añado presentar al frame
        texto = new TextField("", 40); // Instancio nuevo textfield
        add("South", texto); // Añado el textfield en la parte de abajo
    }
    
    
    public boolean handleEvent(Event ev) {  // Control de eventos 
        if(ev.id == Event.WINDOW_DESTROY) // Control de evento para cerrar la ventana 
        {
            System.exit(0); // Cerrar ventana.
            return true; // Devuelve verdadero
        }else if(ev.id == Event.ACTION_EVENT){ // Control de evento de accion 
            if(ev.target instanceof Choice){ // Compruebo si el evento se a producido sobre un elemento de la clase Choice
                this.remove(presentar); // Borramos del frame presentar
                presentar = listasPlatos[chComida.getSelectedIndex()]; // Cargo presenter con la lista del elemento selecionado 
                this.add("East", presentar); // Añado presentar al frame
                this.setVisible(true); // Hago visible actualizando el frame
                texto.setText(chComida.getSelectedItem() + ":"); // Cargo el item seleccionado al campo de texto
            }
        }else if((ev.id == Event.LIST_SELECT) || (ev.id == Event.LIST_DESELECT)){ // Pregunto si se a producido el evento de accion (Seleccion de elemento) 
            String frase = chComida.getSelectedItem() + ": "; // Frase por defecto
            String elementos[] = presentar.getSelectedItems(); // Vector para guardar los elementos selecionados
            String seleccionado = ""; // Variable para guardar el texto que se mostrara con los elementos seleccionados y el retorno de carro 
            for(int i=0; i < elementos.length; i++) // Recorro los elementos seleccionados 
                seleccionado += elementos[i] + " "; // Concateno los elementos a una variable con un retorno de carro 
            texto.setText(frase + seleccionado ); // Cargo el campo de texto
        }
        return false; // Devuelve falso
    }
}

