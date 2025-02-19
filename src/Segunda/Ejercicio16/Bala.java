package Segunda.Ejercicio16;

import java.awt.Rectangle; // Importamos la clase Color
import java.awt.Color;
import java.awt.Graphics;


public class Bala extends Rectangle{ // Heredamos clase rectangle

    public static final int VELY = -5;
    public Bala(int PosX){
        super(PosX, 260, 5, 10);
        
    }
    public void paint(Graphics g){
        g.setColor(Color.RED);
        g.fillRect(x, y, width, height);
    }
    public boolean update(){
        y += VELY;
        return (y < -20);
    }
}