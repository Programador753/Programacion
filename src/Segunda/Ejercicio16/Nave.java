package Segunda.Ejercicio16;

import java.awt.Color; // Importamos la clase Color
import java.awt.Graphics; // Importamos la clase Graphics
import java.awt.Rectangle; // Importamos la clase Rectangle


public class Nave extends Rectangle{ // Heredamos clase rectangle 
    Color colores[] = {Color.red, Color.blue, Color.green, Color.white, Color.orange, Color.yellow, Color.pink, Color.cyan}; // Creo un array de colores
    Color color; // Creo un color 
    int velX; // Creo una variable de velocidad en x
    
    public Nave(){ // Constructor de la clase Nave 
        super((int)(Math.random()*250), (int)(Math.random()*100), 40, 15); // Creo un rectángulo con valores aleatorios 
        color = colores[(int)(Math.random()*colores.length)]; // Asigno un color aleatorio 
        velX = (int)(Math.random()*5) + 1; // Asigno una velocidad aleatoria en x con un mínimo de 1 y un máximo de 5
    }
    public void paint(Graphics g){ // Método paint que recibe un objeto de la clase Graphics
        g.setColor(color); // Asigno un color al objeto g
        g.fillRect(x, y, width, height); // Dibujo un rectángulo con los valores de x, y, width y height
    }
    public void update(){ // Método update que no devuelve nada
        x += velX; // Aumento la x con la velocidad en x
        if((x <= 0) || (x >=(300-width))) // Si x es menor o igual a 0 o x es mayor o igual a 300 menos el ancho del rectángulo
            velX = -velX; // Cambio la dirección de la velocidad en x
        
    }
    
}
