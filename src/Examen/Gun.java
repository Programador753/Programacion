package Examen;


import java.awt.Color; // Importamos la clase Color
import java.awt.Graphics; // Importamos la clase Graphics
import java.awt.Rectangle; // Importamos la clase Rectangle 


public class Gun extends Rectangle { // Clase Gun que hereda de la clase Rectangle 
    public static final int ANCHURA = 20; // Declaro constante WIDTH con valor 28
    public static final int ALTURA = 30; // Declaro constante HEIGHT con valor 10
    Color colores[] = {Color.red, Color.blue, Color.green, Color.orange}; // Creo un array de colores
    Color color; // Creo un color 
    
    public Gun(int x, int y){ // Constructor de la clase Gun
        super(x+ANCHURA, y-ALTURA, ANCHURA, ALTURA); // Llamo al constructor de la clase padre
        for(int i = 0; i < 4; i++){ // Bucle for para recorrer el array de colores
            if(x == 20 + i * 60){ // Si x es igual a 20 + i * 50
                color = colores[i]; // Asigno el color del array a color
            }
        }
    }
    public void paint(Graphics g){ // Método paint que recibe un objeto de la clase Graphics
        g.setColor(color); // Establezco el color de g
        g.fillRect(x, y, ANCHURA, ALTURA); // Relleno un rectangulo con el color establecido 
    }
    
}