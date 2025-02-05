package Segunda.Ejercicio14;
// foreach -> for each traslada cada elemento de un array a una variable y avanza una posicion en java se llama for 
// for(elemento individual : array)


import java.awt.Color; // Importamos la clase Color
import java.awt.Graphics; // Importamos la clase Graphics
import java.awt.Rectangle; // Importamos la clase Rectangle

public class Raqueta extends Rectangle{ // Clase Raqueta extendida de la clase Rectangle
    public static final int VELX = 15; // Creo una constante VELX con valor 5
    public Raqueta(){ // Constructor de la Raqueta
        super(120, 270, 60, 10); // Llamamos al constructor de la clase Rectangle
    }

    public void paint(Graphics g){ // Metodo paint para dibujar la raqueta
        g.setColor(Color.white); // Asignamos el color blanco
        g.fillRect(x, y, width, height); // Dibujamos la raqueta
    }

    public void setX(int direccion){ // Metodo mover para mover la raqueta
        if (direccion == Arcanoi.DERECHA) // Si la direccion es 0 y la raqueta no llega al final
            x += VELX; // Aumentamos la posicion x
        else
            x -= VELX; // Disminuimos la posicion x
        if (x < 0) // Si la raqueta llega al final izquierdo
            x = 0; // Asignamos la posicion x a 0
        if (x > 240) // Si la raqueta llega al final derecho
            x = 240; // Asignamos la posicion x a 240
    }
}
