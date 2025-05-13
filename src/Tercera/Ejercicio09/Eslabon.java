package Tercera.Ejercicio09;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Eslabon extends Rectangle{
    public static final int TAM = 15; // el tamaño
    public static final int ARRIBA = 1;
    public static final int ABAJO = 2;
    public static final int DERECHO = 3;
    public static final int IZQUIERDA = 4;
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
        case ARRIBA: 
            y -= TAM;
            break;
        case ABAJO:
            y += TAM;
            break;
        case DERECHO:
            x += TAM;
            break;
        case IZQUIERDA:
            x -= TAM;
            break;
        }
    }
}
