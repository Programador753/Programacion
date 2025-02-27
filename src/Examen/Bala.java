package Examen;

import java.awt.Color; // Importamos la clase Color
import java.awt.Graphics; // Importamos la clase Graphics
import java.awt.Rectangle; // Importamos la clase Rectangle


public class Bala extends Rectangle{ // Heredamos clase rectangle
    
    Color color; // Creo un color
    public static final int VELY = -5; // Velocidad de la bala en el eje Y
    public Bala(int PosX, Color color){  // Constructor de la clase Bala
        super(PosX, 300, 5, 10); // Llamo al constructor de la clase padre
        this.color = color; // Asigno el color a la bala
    }
    public void paint(Graphics g){ // Metodo paint de la clase Bala
        g.setColor(color); // Establezco el color de g
        g.fillRect(x, y, 5, 10); // Relleno un rectangulo con el color establecido
    }
    public boolean update(){ // Metodo update de la clase Bala que devuelve un booleano
        y += VELY; // Aumentamos la posicion de la bala en el eje Y
        return (y < -20); // Devolvemos si la bala ha salido de la pantalla
    }
}