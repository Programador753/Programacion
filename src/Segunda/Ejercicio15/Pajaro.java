package Segunda.Ejercicio15;
 // Pajaro juego flappy bird
import java.awt.Color; // Importo clase color
import java.awt.Graphics; // Importo clase
import java.awt.Rectangle; // Importo clase Event

public class Pajaro extends Rectangle{ // Clase Pajaro extendida de la clase Rectangle
    public static final int GRAVEDAD = 5; // Gravedad del pajaro
    public static final int SALTO = 20; // Salto del pajaro
    public Color color; // Declaro variable color de tipo Color (Clase Color)


    public Pajaro(int x, int y, int width, int height) { // Constructor de la clase pajaro
        super(10, 0, 15, 15); // Constructor de la clase padre
        this.color = Color.yellow; // Asigno el color
    }

    public void paint(Graphics g){ // Metodo paint para dibujar
        g.setColor(color); // Asignamos el color
        g.fillRect(x, y, width, height); // Dibujamos el pajaro
    }

    public void actualizar(){ // Metodo para mover el pajaro
        y += GRAVEDAD; // Aumentamos la posicion y
    }

    public void saltar(){ // Metodo para hacer saltar al pajaro
        if (y > SALTO) // Si la posicion y es mayor que 20
            y -= SALTO; // Disminuimos la posicion y
        else
            y = 0; // Si no, la posicion y es 0
    }
    
    public boolean colision(Rectangle r){ // Metodo para comprobar colision
        return this.intersects(r); // Devolvemos si hay colision
    }

}
