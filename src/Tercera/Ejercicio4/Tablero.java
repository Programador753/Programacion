package Tercera.Ejercicio4;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

public class Tablero extends Applet{
    public static final int TAM = 5; 
    Image imagen;
    Graphics noseve;
    Image imagenes [][];
    Lugar lugar [][];
    Point blanco; // Coordenadas del espacio en blanco

    public void init() {
        imagen = this.createImage(700, 500);
        noseve = imagen.getGraphics();
        
        imagenes = new Image[TAM][TAM]; // Instancio el vector de imagenes
        // Cargamos las imagenes en el vector
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                imagenes[i][j] = this.getImage(getCodeBase(), "Tercera/Ejercicio4/botones/" + ((i * TAM) + j + 1) + ".gif");
            }
        }
        
        lugar = new Lugar[TAM][TAM]; // Instancio el vector de lugares(piezas del juego)
        // Cargamos los lugares en el vector
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                lugar[i][j] = new Lugar(imagenes[i][j], ((i * TAM) + j));
            }
        }

        blanco = new Point(TAM - 1, TAM - 1); // Inicializo el espacio en blanco

        this.setSize(700,500);

    }

    public void update(Graphics g) {
        paint(g);
    }

    public void paint(Graphics g) {
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 700, 500);
        
        for (int i = 0; i < TAM; i++) {
            for (int j = 0; j < TAM; j++) {
                lugar[i][j].paint(noseve, this, i * Lugar.DIM, j * Lugar.DIM);
            }
        }
       
        g.drawImage(imagen, 0, 0, this);

    }

    public boolean mouseDown(Event ev, int x, int y){
        Point click;
        return true;
    }
    
    public boolean action(Event ev, Object obj){
        
        
        return true;
    }

}



