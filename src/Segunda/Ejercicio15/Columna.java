package Segunda.Ejercicio15;

import java.awt.Color; // Importo clase Graphics
import java.awt.Graphics; // Importo clase Rectangle
import java.awt.Rectangle; // Importo clase Color

public class Columna extends Rectangle{

    public static final int VELOCIDAD = 5; // Velocidad de la columna
    public static final int ANCHO = 20; // Ancho de la columna
    public static final int ESPACIO = 50; // Espacio entre columnas


    public Columna(int x, int y, int height) { // Constructor de la clase Columna
        super(x, y, ANCHO, height); // Constructor de la clase padre
    }

    public void actualizar(){ // Metodo para mover la columna
        x -= VELOCIDAD; // Disminuimos la posicion x
    }

    public boolean colision(Rectangle r){ // Metodo para comprobar colision
        return this.intersects(r); // Devolvemos si hay colision
    }

    public boolean fueraDePantalla(){ // Metodo para comprobar si la columna esta fuera de la pantalla
        return x + ANCHO < 0; // Devolvemos si la columna esta fuera de la pantalla

    }

    public void reiniciar(int x, int y, int height){ // Metodo para reiniciar la columna
        this.x = x; // Asignamos la posicion x
        this.y = y; // Asignamos la posicion y
        this.height = height; // Asignamos la altura
    }

    public void paint(Graphics g){ // Metodo para dibujar
        g.fillRect(x, y, ANCHO, height); // Dibujamos la columna
        g.setColor(Color.GREEN); // Asignamos el color
    }

}
