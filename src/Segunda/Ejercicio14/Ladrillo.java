package Segunda.Ejercicio14;

import java.awt.Color; // Importo clase Color
import java.awt.Graphics; // Importo clase Rectangulo
import java.awt.Rectangle; // Importo clase Graphics

public class Ladrillo extends Rectangle{ // Clase Ladrillo extendida de la clase Rectangulo (Rectangle)
    public static final int ANCHURA = 28; // Declaro constante WIDTH con valor 28
    public static final int ALTURA = 10; // Declaro constante HEIGHT con valor 10
    public Color color; // Declaro variable color de tipo Color (Clase Color)

    public Ladrillo(int x, int y, Color color){ // Constructor de la clase Ladrillo
        super(x, y, ANCHURA, ALTURA); // Llamo al constructor de la clase Rectangle
        this.color = color; // Asigno el color
    }

    public void paint(Graphics gg){ // Metodo paint para dibujar
        gg.setColor(color); // Asignamos el color
        gg.fillRect(x, y, ANCHURA, ALTURA); // Dibujamos el ladrillo
    }


}
