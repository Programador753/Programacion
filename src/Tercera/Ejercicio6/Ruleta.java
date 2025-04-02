package Tercera.Ejercicio6;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;




public class Ruleta extends Applet{
    public static final int FILAS = 12; // Dimensiones del tablero
    public static final int COLUMNAS = 3; // Dimensiones del tablero
    Image imagen; // Imagen del tablero
    Graphics noseve; // Gráficos para la imagen
    Casilla casillas[][]; // Matriz de casillas del tablero
    public int rojos[] = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36}; // Números rojos



    public void init(){
        imagen = this.createImage(400, 500); // Crea la imagen del tablero
        noseve = imagen.getGraphics(); // Obtiene los gráficos de la imagen

        casillas = new Casilla[FILAS][COLUMNAS]; // Inicializa la matriz de casillas
       
        

        // Establece el tamaño del applet
        this.setSize(400, 500); // Establece el tamaño del applet
    }


    public void update(Graphics g){
        paint(g); // Llama al método paint para dibujar el applet
    }

    public void paint(Graphics g){
        // Dibuja el tablero
        noseve.setColor(Color.GREEN); // Establece el color de fondo
        noseve.fillRect(0, 0, 700, 500); // Dibuja el fondo verde

        for (int i = 0; i < FILAS; i++){
            for (int j = 0; j < COLUMNAS; j++){
                casillas[i][j].paint(noseve); // Dibuja cada casilla
            }
        }

        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen del tablero en el applet
    }

    // Método para manejar eventos de ratón para descubrir casillas y colocar banderas
    public boolean mouseDown(Event e, int x, int y) {

        return true;
    }
}
