package Segunda.Ejercicio16;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Gun extends Rectangle {


    public Gun() {
        super(130, 260, 40, 40); 
    }
    
    public void dibujar(Graphics g){ //No devuelve nada, modifica valores 
        g.setColor(Color.yellow);
        g.fillRect(x, y, width, height); 
    } 
    
    public void actualizar(int posX){ //No devuelve nada, ya que solo modifica valores. Así que void
        x = posX - (width/2);
        if(x >= (300-width)) x = (300-width); //Hacemos que x no se salga de límites poniendo topes
        if(x <= 0) x = 0;
    }
}