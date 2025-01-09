/*
Manipulacion de un archivo de texto
 */
package Segunda.Ejercicio07;

import java.awt.Event; // Importo clase Eventos
import java.awt.FileDialog; // Importo clase FileDialog
import java.awt.Frame; // Importo clase Frame
import java.awt.Menu; // Importo clase menu
import java.awt.MenuBar; // Importo clase MenuBar
import java.awt.MenuItem; // Importar clase MenuItem
import java.awt.TextArea; // Importo clase textArea
import java.io.DataInputStream; // Importo clase DataInputStream
import java.io.DataOutputStream; // Importo clase DataOutputStream
import java.io.FileInputStream; // Importo clase FileInputStream
import java.io.FileNotFoundException; // Importo clase FileNotFoundException
import java.io.FileOutputStream;
import java.io.IOException; // Importo clase IOException



public class EditorApp extends Frame{
    MenuBar menubar; // Defino Nombre menu
    TextArea texto; // Defino Nombre textArea
    FileDialog abrirFichero; // Defino nombre objeto de la clase FileDialog
    FileDialog guardarFichero; // Defino nombre objeto de la clase FileDialog
    
    
    public static void main(String arg[]){
        EditorApp app = new EditorApp(); // Instancio nuevo objeto de la clase FrameApp    
    }
    
    public EditorApp() { // Metodo constructor
        super("Editor de textos"); // Titulo de la ventana
       
        setup(); // Llamada a metodo setup
        
        
        this.pack(); // Empaquetar contenido
        this.setSize(texto.minimumSize()); // Tamaño de la ventana
        this.setVisible(true); // Hacerla visible
    }
    
    public void setup(){
        setupMenu(); // Llamada a setupMenu
        texto = new TextArea(25,50); // Defino dimensiones del textArea
        this.add("Center", texto); // Añado el textArea al centro de la ventana
        abrirFichero = new FileDialog(this, "Abrir Fichero", FileDialog.LOAD); // Paso los parametros para abrirFichero
        guardarFichero = new FileDialog(this, "Guardar Fichero", FileDialog.SAVE); // Paso los parametros para guardarFichero
    }
    
    private void setupMenu(){
        menubar = new MenuBar(); // Barra de menu
        Menu fileMenu = new Menu("Archivo"); // Nuevo menu
        fileMenu.add(new MenuItem("Nuevo")); // Nuevo elemento del menu
        fileMenu.add(new MenuItem("Abrir")); // Nuevo elemento del menu
        fileMenu.addSeparator(); // Nuevo elemento del menu
        fileMenu.add(new MenuItem("Guardar")); // Nuevo elemento del menu
        fileMenu.addSeparator(); // Nuevo elemento del menu
        fileMenu.add(new MenuItem("Salir")); // Nuevo elemento del menu
        menubar.add(fileMenu); // Añado menu a la barra del menu
        this.setMenuBar(menubar); // Añado el menu a la ventana 
    }
    
    public boolean handleEvent(Event ev) { 
        if(ev.id == Event.WINDOW_DESTROY) // Control de evento para cerrar la ventana 
        {
            System.exit(0); // Cerrar ventana.
            return true; // Devuelve verdadero
        }
        else if(ev.id == Event.ACTION_EVENT){ // Miro si es evento de accion 
                if(ev.target instanceof MenuItem){ // Si es un elemento del menu
                    if(ev.arg.equals("Salir")){ // Si el elemento es salir 
                        System.exit(0); // Cerrar ventana
                        return true; // Devuelvo verdadero
                    }
                    if(ev.arg.equals("Nuevo")){ // Si el elemento es salir 
                        texto.setText(" "); // Borrar el texto sustituyendo por espacio
                        return true; // Devuelvo verdadero
                    }
                    if(ev.arg.equals("Abrir")){ // Si el elemento es abrir 
                        abrirFichero.setVisible(true); // Hacemos visible el cuadro de dialogo de abrir
                        String inFile = abrirFichero.getDirectory() + abrirFichero.getFile(); // Paso la ruta del archivo a abrir a un String
                        leerFichero(inFile); // Le pasamos al metodo leerFichero la ruta del archivo 
                        return true; // Devuelvo verdadero
                    }
                    if(ev.arg.equals("Guardar")){ // Si el elemento es guardar 
                        guardarFichero.setVisible(true); // Hacemos visible el cuadro de dialogo de guardar
                        String outFile = guardarFichero.getDirectory() + guardarFichero.getFile(); // Paso la ruta donde guardar el archivo a un String
                        guardarFichero(outFile); // Le pasamos al metodo leerFichero la ruta del archivo
                        return true; // Devuelvo verdadero
                    }                    
                }
            }
        return false; // Devuelve falso
    }

    private void leerFichero(String inFile){ // Metodo para leer el archivo
        DataInputStream inStream; // Creo un objeto de DataInputStream
        try{ // Inicio control de excepciones 
            inStream = new DataInputStream(new FileInputStream(inFile)); /* Instancio el objeto inStream  abriendo el objeto de la ruta 
            inFile mediante FileInputStream y este se lo pasa a DataInputStream que lo instancia en la memoria RAM */
            String nuevo_texto = ""; // String para el nuevo texto
            String linea; // String para recorrer las lineas
            while((linea = inStream.readLine()) != null) // Recorro las lineas del texto 
                nuevo_texto += linea + "\n"; // Cargo las lineas en nuevo_texto
            texto.setText(nuevo_texto); // Cargo el nuevo texto en el textArea
        }catch(FileNotFoundException e){} // Defino la excepcion y el nombre del objeto de esa excepcion y lo que hago con ella
        catch(IOException e){} // Defino la excepcion y el nombre del objeto de esa excepcion y lo que hago con ella
    }
    private void guardarFichero(String outFile){ // Metodo para guardar el archivo
        DataOutputStream outStream; // Creo un objeto de DataOutputStream
        try{ // Inicio control de excepciones
            outStream = new DataOutputStream (new FileOutputStream(outFile)); // Instancio donde quiero guardar haciendo lo mismo que abrir pero para guardar
            outStream.writeBytes(texto.getText()); // Escribo el texto en el archivo
        }catch(FileNotFoundException e){} // Defino la excepcion y el nombre del objeto de esa excepcion y lo que hago con ella
        catch(IOException e){} // Defino la excepcion y el nombre del objeto de esa excepcion y lo que hago con ella
    }
}
