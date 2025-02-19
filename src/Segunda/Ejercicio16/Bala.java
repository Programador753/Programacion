package Segunda.Ejercicio16;

import java.awt.Color; // Importamos la clase Color
import java.awt.Graphics; // Importamos la clase Graphics
import java.awt.Rectangle; // Importamos la clase Rectangle


public class Bala extends Rectangle{ // Heredamos clase rectangle

    public static final int VELY = -5; // Velocidad de la bala en el eje Y
    public Bala(int PosX){  // Constructor de la clase Bala
        super(PosX, 260, 5, 10); // Llamamos al constructor de la clase Rectangle con los parametros PosX, 260, 5, 10
        
    }
    public void paint(Graphics g){ // Metodo paint de la clase Bala
        g.setColor(Color.RED); // Establecemos el color de la bala en rojo
        g.fillRect(x, y, width, height); // Dibujamos la bala en la posicion x, y con el ancho y alto de la bala
    }
    public boolean update(){ // Metodo update de la clase Bala que devuelve un booleano
        y += VELY; // Aumentamos la posicion de la bala en el eje Y
        return (y < -20); // Devolvemos si la bala ha salido de la pantalla
    }
}