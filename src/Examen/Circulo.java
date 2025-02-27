package Examen;

import java.awt.Rectangle;
import java.awt.Graphics;
import java.awt.Color;




public class Circulo extends Rectangle{ // Heredamos de la clase Rectangle
    int velX, velY; // Velocidades de la pelota
    int numero; // Número que aparece en la pelota
    
    public Circulo(int x, int y, int velX, int velY){ // Constructor de la clase Circulo
        super(x, y, 40, 40); // Llamo al constructor de la clase padre
        this.velX = velX; // Asigno la velocidad en el eje X
        this.velY = velY; // Asigno la velocidad en el eje Y
    }

    public void paint(Graphics g){ // Método paint de la clase Circulo
        g.setColor(Color.yellow); // Establezco el color de la pelota
        g.fillOval(x, y, 40, 40); // Dibujo la pelota
        g.setColor(Color.white); // Establezco el color del número
        g.setFont(g.getFont().deriveFont(20)); // Establezco el tamaño de la fuente
        g.drawString("" + numero, x + 15, y + 25); // Dibujo el número en la pelota
    }



    public void update(){ // Método update de la clase Circulo
        x += velX; // Aumento la posición de la pelota en el eje X
        y += velY; // Aumento la posición de la pelota en el eje Y
        
    }
    
        
}
