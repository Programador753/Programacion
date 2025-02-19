package Segunda.Ejercicio17;

import java.awt.Rectangle; // Importo la clase rectangulo 
import java.awt.Color; // Importo clase Color de la libreria awt
import java.awt.Graphics; // Importo clase Graphics de la libreria awt

public class Obstaculo {
    public static final int POSINICIAL = 280; // Constante de la clase Obstaculo
    public static final int VELX = -1; // Constante de la clase Obstaculo 
    Rectangle rect1; // Rectangulo obstaculo
    
    public Obstaculo(){ // Constructor de la clase Columna
        int ancho = (int)(Math.random() * 20) + 20;
        rect1 = new Rectangle(280, POSINICIAL - ancho , 30, ancho); // Creo el primer rectangulo de la columna con la altura generada
        
    }
     public void paint(Graphics g){ // Metodo paint de la clase Obstaculo
        g.setColor(Color.RED); // Establezco el color rojo
        g.fillRect(rect1.x, rect1.y, rect1.width, rect1.height); // Dibujo el primer obstaculo
     }
     
      public void update(){ // Metodo update de la clase Columna
        rect1.x += VELX; // Muevo el primer rectangulo de la columna
      }
    
}
