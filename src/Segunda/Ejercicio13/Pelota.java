package Segunda.Ejercicio13;

import java.awt.Color; // Importamos la clase Color
import java.awt.Graphics; // Importamos la clase Rectangle
import java.awt.Rectangle; // Importamos la clase Graphics

public class Pelota extends Rectangle{ // Heredamos de la clase Rectangle
    int velX, velY; // Velocidades de la pelota
    Color color; // Color de la pelota
    Color colores[] = {Color.yellow, Color.blue, Color.lightGray, Color.red, Color.magenta}; // Colores de la pelota
    
    public Pelota() {
        super((int)(Math.random()*250), (int)(Math.random()*250), 0, 0); // Creamos un rectangulo con valores aleatorios
        int radio = ((int)(Math.random()*30)) + 20; // Creamos un radio aleatorio
        // this.width = this.height = radio; // Asignamos el radio al ancho y alto del rectangulo
        this.setSize(radio, radio); // Asignamos el radio al tamaño del rectangulo
        this.velX = (int)(Math.random()*11) - 5; // Asignamos una velocidad aleatoria en X entre -5 y 5
        this.velY = (int)(Math.random()*11) - 5; // Asignamos una velocidad aleatoria en Y entre -5 y 5
        color = colores[(int)(Math.random()*colores.length)]; // Asignamos un color aleatorio
    }
    public void paint(Graphics gg){  // Metodo paint para dibujar
        gg.setColor(color); // Asignamos el color
        gg.fillOval(x, y, width, height); // Dibujamos la pelota
    }
    public void update(){ // Metodo update para actualizar
        x += velX; // Sumamos la velocidad en X a la posicion en X
        y += velY; // Sumamos la velocidad en Y a la posicion en Y
        if(x < 0 || x > 400 - width){ // Si la posicion en X es menor que 0 o mayor que 300 menos el ancho
            velX = -velX; // Cambiamos el sentido de la velocidad en X
            x += velX; // Sumamos la velocidad en X a la posicion en X
        }
        if(y < 0 || y > 400 - height){ // Si la posicion en Y es menor que 0 o mayor que 300 menos el alto
            velY = -velY; // Cambiamos el sentido de la velocidad en Y
            y += velY; // Sumamos la velocidad en Y a la posicion en Y
        }
    }
    
}
