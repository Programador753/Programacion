package Tercera.Ejercicio3;


import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Blackjack extends Applet{
    public static final int NUMCARTAS= 52;
    public static final int CPP = 13;
    Image imagenes[];
    String palos[] = {"_of_hearts.png", "_of_diamonds.png", "_of_clubs.png", "_of_spades.png"};

    Image imagen;
    Graphics noseve;
    Rectangle tablero[][];

    public void init(){
        imagen = this.createImage(700, 500);
        noseve = imagen.getGraphics();
        imagenes = new Image[NUMCARTAS];
       
        
        for(int i=0; i < NUMCARTAS; i++){ // Cargamos las imagenes
            imagenes[i] = getImage(getCodeBase(), "Tercera/Ejercicio3/Cartas/" + ((i%CPP) +1) + palos[i/CPP]);
        }
            
        this.setSize(700, 500);
    }
    public void update(Graphics g){
        paint(g);
    }
    public void paint(Graphics g){
        noseve.setColor(Color.BLACK);
        noseve.fillRect(0, 0, 700, 500);

        for(int i=0; i < NUMCARTAS; i++){
            noseve.drawImage(imagenes[i], (i%CPP)*50, (i/CPP)*100, this);
        }

        
        g.drawImage(imagen, 0, 0, this);
    }
    public boolean mouseDown(Event evt, int x, int y){
       
        return true;
    }
    
}