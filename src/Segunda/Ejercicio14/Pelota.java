package Segunda.Ejercicio14;

import java.awt.Color; // Importamos la clase Color
import java.awt.Graphics; // Importamos la clase Rectangle
import java.awt.Rectangle; // Importamos la clase Graphics

public class Pelota extends Rectangle{ // Heredamos de la clase Rectangle
    int velX, velY; // Velocidades de la pelota
        
    public Pelota() {
        super(150, 260, 9, 9); // Llamamos al constructor de la clase Rectangle
        int radio = 9; // Creamos un radio aleatorio
        // this.width = this.height = radio; // Asignamos el radio al ancho y alto del rectangulo
        this.setSize(radio, radio); // Asignamos el radio al tamaño del rectangulo
        velX = -3; // Asignamos la velocidad en X
        velY = -2; // Asignamos la velocidad en Y
    }
    public void paint(Graphics gg){  // Metodo paint para dibujar
        gg.setColor(Color.WHITE); // Asignamos el color
        gg.fillOval(x, y, width, height); // Dibujamos la pelota
    }
    
    public void mover(){ // Metodo mover para mover la pelota
        x += velX; // Aumentamos la posicion en X
        y += velY; // Aumentamos la posicion en Y
        if (x <= 0 || x >= (300 - width)) // Si la pelota llega al final izquierdo o derecho
            velX = -velX; // Cambiamos la direccion en X
        if (y <= 0 || y >= (300 - height)) // Si la pelota llega al final superior o inferior
            velY = -velY; // Cambiamos la direccion en Y
        
    }

    public boolean intersects(Rectangle r){ // Metodo intersects para comprobar si choca con un objeto
        return r.intersects(x, y, width, height); // Devolvemos si choca o no
    }




}