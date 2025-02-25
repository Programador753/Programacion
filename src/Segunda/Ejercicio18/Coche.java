package Segunda.Ejercicio18;

import java.awt.Color; // Importo clase color
import java.awt.Graphics; // Importo clase graphics
import java.awt.Rectangle; // Importo clase rectangulo



public class Coche extends Rectangle{
    static final Color colores[] = {Color.red, Color.blue, Color.green, Color.white, Color.orange, Color.MAGENTA, Color.pink, Color.cyan}; // Creo un array de colores
    Color color; // Color del coche
    int velX;  // Velocidad del coche 
    
    public Coche(int posX, int posY, int velX) {
        super(posX, posY, 40, 20); // Llamo al constructor de Rectangle
        color = colores[(int)(Math.random()*colores.length)]; // Asigno un color aleatorio al coche
        this.velX = velX; // Igualo los valores de velX con el parametro que recibe el metodo constructor.
    }
    
    public void paint(Graphics g){
        g.setColor(color); // Asigno color al coche
        g.fillRect(x, y, width, height); // Dibujo el rectangulo 
    }
    
    public boolean update(){
        x += velX; // Incremento la poscion en X segun la velocidad.
        if((x < -width) || (x > 500)) // Control de si se sale para borrarlo de la lista
            return true; //Devuelve cierto
        return false;// Devuelve falso
    }
    public boolean colision(Rana r){ // Metodo para control de colision con coche
        return this.intersects(r); // Devolver si intersecta.
    }
}
