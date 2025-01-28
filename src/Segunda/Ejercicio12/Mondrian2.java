package Segunda.Ejercicio12;
// 9 rectangulos instancia, color y rotacion a partir de la clase Rectangulo creada en el ejercicio anterior

import java.applet.Applet; // Importo la clase Applet
import java.awt.Color; // Importo la clase Color
import java.awt.Graphics; // Importo la clase Graphics
import java.awt.Image; // Importo la clase Image

public class Mondrian2 extends Applet implements Runnable{ // Clase Mondrian2 que hereda de la clase Applet e implementa la interfaz Runnable
    Thread animacion;
    Image imagen;
    Graphics noseve;
    Rectangulo rectangulos[];
    int posicionesX[] = {0, 250, 80, 80, 100, 80, 200, 0, 200}; // Posiciones en X 
    int posicionesY[] = {0, 0, 160, 220, 10, 100, 0, 110, 55}; // Posiciones en Y
    int anchuras[] = {90, 40, 100, 220, 90, 110, 45, 70, 60}; // Anchuras
    int alturas[] = {90, 190, 120, 90, 80, 90, 45, 200, 135}; // Alturas
    Color colores[] = {Color.yellow, Color.yellow, Color.yellow, Color.blue, Color.blue, Color.lightGray, Color.red, Color.red, Color.magenta}; // Colores
    
    @Override
    public void init(){ // Metodo init para vida del applet
        imagen = this.createImage(300, 300); // Creo una imagen
        noseve = imagen.getGraphics(); // Obtiene los graficos de la imagen
        rectangulos = new Rectangulo[9]; // Instancia de la clase Rectangulo con 9 elementos
        for(int i = 0; i < rectangulos.length; i++) // Bucle for para recorrer los rectangulos 
            rectangulos[i] = new Rectangulo(colores[i], posicionesX[i], posicionesY[i], anchuras[i], alturas[i]); // Instancia de la clase Rectangulo con los parametros de color, posiciones en X y Y, anchura y altura

    }
    @Override
    public void start(){ // Metodo start para iniciar la animacion
        animacion = new Thread(this); // Instancio el objeto animacion
        animacion.start(); // Inicializo el objeto animacion
    }
    @Override
    public void paint(Graphics g){  // Metodo paint para dibujar los rectangulos
        noseve.setColor(Color.BLACK); // Color de fondo negro
        noseve.fillRect(0, 0, 300, 300);  // Bucle para recorrer
        for (int i = 0; i < rectangulos.length; i++)  
            rectangulos[i].paint(noseve); // Pinto los rectangulos
        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen 

    }
    @Override
    public void run(){
        do{ // Bucle do while 
            for(int i = 0; i < rectangulos.length; i++) // Bucle para recorrer
                rectangulos[i].update(); // Actualizo
            repaint(); // Llama al metodo repaint 
            try { // Manejo de excepciones 
                Thread.sleep(100); // Tiempo de espera
            } catch (InterruptedException ex) {} // Excepcion a manejar 
        }while(true); // Bucle infinito 
    }
}
