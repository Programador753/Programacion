package Tercera.Ejercicio4;


import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URL;

public class Tablero extends Applet{
    public static final int TAM = 5; 
    Image imagen;
    Graphics noseve;
    Image imagenes [][];
    Lugar lugar [][];
    Point blanco; // Coordenadas del espacio en blanco
    AudioClip error, acierto, exito; // Sonidos de error y acierto
    

    public void init() {
        imagen = this.createImage(700, 500);
        noseve = imagen.getGraphics();

        try {
            error = getAudioClip(new URL(getCodeBase(), "Tercera/Ejercicio4/sonidos/error.wav")); // Cargamos el sonido de error
            acierto = getAudioClip(new URL(getCodeBase(), "Tercera/Ejercicio4/sonidos/correct.wav")); // Cargamos el sonido de acierto
            exito = getAudioClip(new URL(getCodeBase(), "Tercera/Ejercicio4/sonidos/exito.wav")); // Cargamos el sonido de exito
        } catch (MalformedURLException e) {};
        
        
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
                lugar[i][j] = new Lugar(imagenes[j][i], ((i * TAM) + j));
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

    public boolean mover(Point click) {
        Point desplazamiento, hasta;
        desplazamiento = new Point(delta(click.x, blanco.x), delta(click.y, blanco.y)); // Calculo el desplazamiento.
        if((desplazamiento.x == 0) && ( desplazamiento.y == 0)) 
            return false;
        if((desplazamiento.x != 0) && ( desplazamiento.y != 0))
            return false;

        // Cargo hasta con la posicion a la que se va a mover la pieza
        hasta = new Point(click.x + desplazamiento.x, click.y + desplazamiento.y); // Calculo la posicion a la que se va a mover la pieza
        if(!(blanco.x == hasta.x && blanco.y == hasta.y)) // Si el espacio en blanco es el mismo que el de la pieza, no se puede mover
            mover(hasta); // Muevo la pieza al espacio en blanco
        lugar[blanco.x][blanco.y].setImagen(lugar[click.x][click.y].getImagen()); // Muevo la pieza al espacio en blanco
        lugar[blanco.x][blanco.y].valor = lugar[click.x][click.y].valor; // Muevo el valor de la pieza al espacio en blanco
        lugar[click.x][click.y].setImagen(null); // Dejo el espacio en blanco vacio
        lugar[click.x][click.y].valor = 24; // Dejo el valor de la pieza en el espacio en blanco 
        blanco = click; // Actualizo la posicion del espacio en blanco
        
        
        return true; // Si no se ha movido, devuelvo true
    }


    public int delta(int a, int b){ // Funcion para comprobas si es posible mover la pieza
        if(a == b) return 0; // Si son iguales devuelve 0
        else return ((b-a)/Math.abs(b-a)); // Devuelve -1 o 1 dependiendo de si a es menor o mayor que b
    }

    public boolean mouseDown(Event ev, int x, int y){
        Point click;
        click = new Point(x / Lugar.DIM , y / Lugar.DIM ); // Calculo la posicion del click en el tablero
        if(mover(click))
        {
            acierto.play(); // Si no se puede mover, reproduzco el sonido de error
            repaint();
        }
        else
            error.play(); // Si se puede mover, reproduzco el sonido de acierto
        return true;
    }
    
    public boolean action(Event ev, Object obj){
        // Boton para desordenar el tablero
        return true;
    }

}



