package Segunda.Ejercicio15;
 // Pajaro juego flappy bird
import java.awt.Color; // Importo clase color
import java.awt.Graphics; // Importo clase
import java.awt.Rectangle; // Importo clase Event

public class Pajaro extends Rectangle{ // Clase Pajaro extendida de la clase Rectangle
    public static final int GRAVEDAD = 2; // Gravedad del pajaro
    public static final int SALTO = -5; // Salto del pajaro


    public Pajaro() { // Constructor de la clase pajaro
        super(10, 0, 15, 15); // Constructor de la clase padre
    }

    public void paint(Graphics g){ // Metodo paint para dibujar
        g.setColor(Color.yellow); // Asignamos el color
        g.fillRect(x, y, width, height); // Dibujamos el pajaro
    }
    
    public void update(){ // Metodo gravedad para que el pajaro caiga
        y += GRAVEDAD; // Aumentamos la posicion y
    }

    public void saltar(){ // Metodo salto para que el pajaro suba
        y += SALTO; // Disminuimos la posicion y
    }

    public boolean colision(Columna c){ // Metodo colision para comprobar si el pajaro colisiona con un objeto
        return this.intersects(c.rect1) || this.intersects(c.rect2); // Si el pajaro colisiona con la columna
    }

}
