package Examen;

import java.awt.Color; // Importo clase color
import java.awt.Graphics; // Importo clase Graphics
import java.awt.Rectangle; // Importo clase rectangle 

public class Naves extends Rectangle{ // Heredamos clase rectangle 
    Color colores[] = {Color.red, Color.blue, Color.green, Color.orange}; // Creo un array de colores
    Color color; // Creo un color 
    int velX = 3; // Velocidad de la nave en el eje X
    
    
    public Naves(int x, int y){ // Constructor de la clase Nave 
        super(x, y, 20, 20); // Llamo al constructor de la clase padre
        for(int i = 0; i < 4; i++){ // Bucle for para recorrer el array de colores
            if(y == 20 + i * 50){ // Si y es igual a 30 + i * 50
                color = colores[i]; // Asigno el color del array a color
            }
        }
    }
    public void paint(Graphics g){ // Método paint que recibe un objeto de la clase Graphic
        g.setColor(color); // Establezco el color de g
        g.fillRect(x, y, 20, 20); // Relleno un rectangulo con el color establecido
    }
    
    public void update(){ // Método update de la clase Nave
        x += velX; // Aumento la posición de la nave en el eje X
        if(x > 280 || x < 0){ // Si la posición de la nave es mayor que 280 o menor que 0
            velX = -velX; // Cambio la dirección de la nave
        }
    }

    public boolean colisiona(Bala bala) { // Método intersects que recibe un objeto de la clase Bala
        if (this.intersects(bala) && bala.color == this.color) // Si la bala colisiona con la nave y el color de la bala es igual al color de la nave
            return true;
        return false;

    }
}