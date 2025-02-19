package Segunda.Ejercicio15;

import java.awt.Color; // Importo clase Rectangle de la libreria awt
import java.awt.Graphics; // Importo clase Color de la libreria awt
import java.awt.Rectangle; // Importo clase Graphics de la libreria awt

public class Columna{ // clase Columna formada por 2 rectangulos separados por un espacio entre medios para formar la columna
    public static final int HUECO = 80; // Constante de la clase Columna
    public static final int ANCHURA = 30; // Constante de la clase Columna 
    public static final int POSINICIAL = 300; // Constante de la clase Columna 
    public static final int VELX = -1; // Constante de la clase Columna 
    Rectangle rect1, rect2; // Declaro 2 objetos de la clase Rectangle para formar la columna

    public Columna(){ // Constructor de la clase Columna
        int altura = (int)(Math.random() * 170) + 20; // Genero un numero aleatorio entre 20 y 150 para la altura de la columna
        rect1 = new Rectangle(POSINICIAL, 0, ANCHURA, altura); // Creo el primer rectangulo de la columna con la altura generada
        rect2 = new Rectangle(POSINICIAL, altura + HUECO, ANCHURA, 300 - (altura + HUECO)); // Creo el segundo rectangulo de la columna con la altura generada y el hueco

    }
    public void paint(Graphics g){ // Metodo paint de la clase Columna
        g.setColor(Color.RED); // Establezco el color rojo
        g.fillRect(rect1.x, rect1.y, rect1.width, rect1.height); // Dibujo el primer rectangulo de la columna
        g.fillRect(rect2.x, rect2.y, rect2.width, rect2.height); // Dibujo el segundo rectangulo de la columna
        
    }
    public void update(){ // Metodo update de la clase Columna
        rect1.x += VELX; // Muevo el primer rectangulo de la columna
        rect2.x += VELX; // Muevo el segundo rectangulo de la columna
    }
}
