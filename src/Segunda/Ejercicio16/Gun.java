package Segunda.Ejercicio16;

import java.awt.Color; // Importamos la clase Rectangle
import java.awt.Graphics; // Importamos la clase Color
import java.awt.Image; // Importamos la clase Color
import java.awt.Rectangle; // Importamos la clase Color
import java.util.ArrayList; // Importamos la clase Event



public class Gun extends Rectangle{ // Heredamos clase rectangle 
    
    int velX; // Velocidades de la gun
    Image imagen; // Imagen de la gun
    ArrayList<Bala> bala; // Lista de balas

    public Gun(int x, int y) { // Constructor de la clase Gun
        super(x, y, 50, 50); // Llamamos al constructor de la clase Rectangle
        velX = 5; // Establecemos la velocidad en X
        bala = new ArrayList<Bala>(); // Creamos una lista de balas
    }

    public void mover(int direccion) { // Metodo mover para mover la gun
        if (direccion == Marcianitos.DERECHA) { // Si la direccion es DERECHA
            x += velX; // Movemos la gun en X
        } else if (direccion == Marcianitos.IZQUIERDA) { // Si la direccion es IZQUIERDA
            x -= velX; // Movemos la gun en X
        }
    }

    public void paint(Graphics g) { // Metodo paint para dibujar
        g.setColor(Color.BLUE); // Asignamos el color
        g.fillRect(x, y, 50, 50); // Dibujamos la gun
    }

   

}