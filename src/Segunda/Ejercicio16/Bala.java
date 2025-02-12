package Segunda.Ejercicio16;

import java.awt.Rectangle; // Importamos la clase Color



public class Bala extends Rectangle{ // Heredamos clase rectangle

    public Bala(int x, int y) { // Constructor de la clase Bala
        super(x, y, 5, 10); // Llamamos al constructor de la clase Rectangle
    }

    public void update() { // Metodo update para actualizar
        y -= 5; // Disminuimos la y
    }

    public Rectangle getBounds() { // Metodo getBounds para obtener los limites
        return new Rectangle(x, y, 5, 10); // Devolvemos un rectangulo
    }

    public void mover() { // Metodo mover para mover la bala
        y -= 5; // Disminuimos la y
    }

    public void paint(java.awt.Graphics g) { // Metodo paint para dibujar
        g.setColor(java.awt.Color.WHITE); // Asignamos el color
        g.fillRect(x, y, 5, 10); // Dibujamos la bala
    }
    
}