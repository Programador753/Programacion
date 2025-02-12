package Segunda.Ejercicio16;

import java.awt.Color; // Importo clase Color
import java.awt.Graphics; // Importo clase Graphics


public class Nave {
    public static final int VELX = 5; // Creo una constante VELX con valor 5
    public static final int VELY = 5; // Creo una constante VELY con valor 5
    int x; // Creo una variable x
    int y; // Creo una variable y

    public Nave(int x, int y) { // Constructor de la clase Nave
        this.x += x += 10; // Inicializamos la x
        this.y = y; // Inicializamos la y

    }

    public void mover(int direccion) { // Metodo para mover la nave
        if (direccion == Marcianitos.DERECHA) { // Si la direccion es DERECHA
            x += VELX; // Aumentamos la x
        } else if (direccion == Marcianitos.IZQUIERDA) { // Si la direccion es IZQUIERDA
            x -= VELX; // Disminuimos la x
        }
    }

    public void paint(Graphics g) { // Metodo para pintar la nave
        g.setColor(Color.RED); // Establecemos el color
        g.fillRect(x, y, 50, 50); // Dibujamos un rectangulo
    }

    public void update() { // Metodo para actualizar
        y += VELY; // Aumentamos la y
    }
    
    public boolean colision(Bala bala) { // Metodo para comprobar colision
        return bala.getBounds().intersects(x, y, 50, 50); // Devolvemos si hay colision
    }   

}