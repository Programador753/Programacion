package Tercera.Ejercicio4;

import java.applet.Applet; // Importo clase applet
import java.awt.Graphics; // Importo clase graphics
import java.awt.Image; // Importo clase imagen 

public class Lugar {
    public static final int DIM = 48;
    private Image imagen;
    int valor;

    public Lugar(Image imagen, int valor){
        this.imagen = imagen;
        this.valor = valor;
        
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    
    public void paint(Graphics g, Applet a, int x, int y){
        if(imagen!=null)
            g.drawImage(imagen, x, y, a);
            
            
    }
    
}