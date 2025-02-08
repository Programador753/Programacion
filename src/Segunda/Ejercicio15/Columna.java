package Segunda.Ejercicio15;

import java.awt.Color; // Importo clase Graphics
import java.awt.Graphics; // Importo clase Color
import java.awt.Rectangle; // Importo clase Graphics

public class Columna{ // clase Columna formada por 2 rectangulos separados por un espacio entre medios para formar la columna
    // Un objeto de la clase Columna tiene 2 rectangulos y un espacio entre ellos
    Rectangle arriba; // Creo un objeto de la clase Rectangle con una longitud entre 20 y 125
    Rectangle abajo; // Creo un objeto de la clase Rectangle para la parte inferior de la columna
    public static final int ESPACIO = 100; // Creo un entero espacio
    public static final int ANCHO = 25; // Ancho de la columna
    

    public Columna(int x, int y, int alto){ // Constructor de la clase Columna
        arriba = new Rectangle(x, y, ANCHO, alto ); // Creo un objeto de la clase Rectangle
        abajo = new Rectangle(x, y + alto + 50, ANCHO, 300 - alto - 50); // Creo un objeto de la clase Rectangle
    }

    public void mover(){ // Metodo mover de la clase Columna
        arriba.x -= 1; // Decremento la coordenada x del objeto arriba
        abajo.x -= 1; // Decremento la coordenada x del objeto abajo
    }

    public void paint(Graphics g){ // Metodo paint de la clase Columna
        g.setColor(Color.green); // Establezco el color del objeto g
        g.fillRect(arriba.x, arriba.y, arriba.width, arriba.height); // Dibujo un rectangulo con las coordenadas y dimensiones del objeto arriba
        g.fillRect(abajo.x, abajo.y, abajo.width, abajo.height); // Dibujo un rectangulo con las coordenadas y dimensiones del objeto abajo
    }

    public boolean colision(Rectangle pajaro){ // Metodo colision de la clase Columna
        if(arriba.intersects(pajaro) || abajo.intersects(pajaro)){ // Si el objeto arriba o abajo intersecan con el objeto pajar
            return true;
        }
        return false; // Retorno falso
    }



}
