package Segunda.Ejercicio17;

import java.awt.Rectangle; // Importo la clase rectangulo 
import java.awt.Color; // Importo clase Color de la libreria awt
import java.awt.Graphics; // Importo clase Graphics de la libreria awt

public class Obstaculo {
    public static final int POSINICIAL = 280; // Constante de la clase Obstaculo
    public static final int VELX = -2; // Constante de la clase Obstaculo 
    Rectangle rect1; // Rectangulo obstaculo
    Color colores[] = {Color.red, Color.blue, Color.green, Color.black, Color.orange, Color.MAGENTA, Color.pink, Color.cyan}; // Creo un array de colores
    Color color; // Creo un color 
    
    public Obstaculo(){ // Constructor de la clase Columna
        int ancho = (int)(Math.random() * 5) + 10;
        rect1 = new Rectangle(280, POSINICIAL - ancho , (int)(Math.random() * 10) + 20, ancho); // Creo el primer rectangulo de la columna con la altura generada
        color = colores[(int)(Math.random()*colores.length)]; // Asigno un color aleatorio 
    }
     public void paint(Graphics g){ // Metodo paint de la clase Obstaculo
        g.setColor(color); // Establezco el color 
        g.fillRect(rect1.x, rect1.y, rect1.width, rect1.height); // Dibujo el primer obstaculo
     }
     
      public boolean update(){ // Metodo update de la clase Columna
        rect1.x += VELX; // Muevo el primer rectangulo de la columna
        return(rect1.x <= -50); // devuelvo si esta fuera
      }
    
}
