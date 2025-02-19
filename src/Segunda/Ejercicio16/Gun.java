package Segunda.Ejercicio16;

import java.awt.Color; // Importamos la clase Color
import java.awt.Graphics; // Importamos la clase Graphics
import java.awt.Rectangle; // Importamos la clase Rectangle 


public class Gun extends Rectangle { // Clase Gun que hereda de la clase Rectangle 


    public Gun() { // Constructor de la clase Gun 
        super(130, 260, 40, 40);  // Posicion y tamaño del cañon 
    }
    
    public void dibujar(Graphics g){ // Metodo para dibujar el cañon 
        g.setColor(Color.yellow); // Color amarillo 
        g.fillRect(x, y, width, height); // Dibujamos el cañon 
    } 
    
    public void actualizar(int posX){ // Metodo para actualizar la posicion deL cañon
        x = posX - (width/2); // Modificamos la posicion de x para que el cañon se mueva con el raton 
        if(x >= (300-width)) x = (300-width); // condicion para que x no sea mayor a 300 - el ancho del cañon
        if(x <= 0) x = 0; // condicion para que x no sea menor a 0 
    }
}