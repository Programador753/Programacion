package Tercera.Ejercicio09;

import java.applet.Applet;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Eslabon extends Rectangle{
    public static final int TAM = 15; // el tamaño
    private int direccion; // la encapsulamos
    Image imagen;
    
    public Eslabon(Image img, int x, int y, int direccion){
        super (x, y, TAM, TAM);
        imagen = img;
        this.direccion = direccion;
    
    }
    

    public int getDireccion() {
        return direccion;
    }

    public void setDireccion(int direccion) {
        this.direccion = direccion;
    }

    public void paint(Graphics g, Applet a){ //Dibujamos el eslabon
        g.drawImage(imagen, x, y, width, height, a);

    }

    public void update(){  // Método para cambiar la posición del eslabon
    switch (direccion) {
        case Event.UP: 
            y -= TAM;
            break;
        case Event.DOWN:
            y += TAM;
            break;
        case Event.RIGHT:
            x += TAM;
            break;
        case Event.LEFT:
            x -= TAM;
            break;
        }
    }
    
}
