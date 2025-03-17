package Tercera.Ejercicio2;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Puzzle extends Applet{
    public static final int PIEZAS = 25;
    public static final int FILAS = 5;
    Image imagenes[];
    Pieza piezas[];
    Pieza actual;
    Image imagen;
    Graphics noseve;
    Rectangle tablero[][];

    public void init(){
        imagen = this.createImage(700, 500);
        noseve = imagen.getGraphics();
        imagenes = new Image[PIEZAS];
        piezas = new Pieza[PIEZAS];
        tablero = new Rectangle[FILAS][FILAS];
        
        for(int i=0; i < FILAS; i++)
            for(int j=0; j < FILAS; j++)
                tablero[i][j] = new Rectangle(j * Pieza.DIMENSION + 10, i * Pieza.DIMENSION + 10, Pieza.DIMENSION, Pieza.DIMENSION);
        
        for(int i=0; i < PIEZAS; i++){
            imagenes[i] = getImage(getCodeBase(), "Tercera/Ejercicio2/directorioImagenes/" + (i+1) + ".png");
            piezas[i] = new Pieza(imagenes[i], i);
        }
        this.setSize(700, 500);
    }
    public void update(Graphics g){
        paint(g);
    }
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 700, 500);
        noseve.setColor(Color.WHITE);
        for(int i=0; i < FILAS; i++)
            for(int j=0; j < FILAS; j++)
                noseve.drawRect(tablero[i][j].x, tablero[i][j].y, tablero[i][j].width, tablero[i][j].height);
        for(int i=0; i < PIEZAS; i++)
            piezas[i].paint(noseve, this);
            
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean mouseDown(Event ev, int x, int y){
        for(Pieza pieza : piezas){
            if(pieza.contains(x, y) && (!pieza.isColocado()))
                actual = pieza;
        }
        return true;
    }
    public boolean mouseDrag(Event ev, int x, int y){
        if(actual != null){
            actual.mover(x, y);
            repaint();
        }
        return true;
    }
    public boolean mouseUp(Event ev, int x, int y){
        if(actual != null){
            for(int i=0; i < FILAS; i++)
                for(int j=0; j < FILAS; j++)
                    if(tablero[i][j].intersects(actual))
                        if(actual.posicion == (i * FILAS) + j){
                            actual.setColocado(true);
                            actual.ajustar(tablero[i][j].x, tablero[i][j].y);
                            repaint();
                        }
        }
        actual = null;
        return true;
    }
}
