package Segunda.Ejercicio18;

import java.awt.Color; // Importamos la clase Rectangle
import java.awt.Graphics; // Importamos la clase Color
import java.awt.Rectangle; // Importamos la clase Graphics


public class Rana extends Rectangle {
    public static final int VEL = 5; // Velocidad vertical de la rana (constante)
    public static final int ARRIBA = 1004; // Constante para la dirección arriba con la flecha arriba
    public static final int ABAJO = 1005; // Constante para la dirección abajo
    public static final int IZQUIERDA = 1006; // Constante para la dirección izquierda
    public static final int DERECHA = 1007; // Constante para la dirección derecha

    public Rana(){
        super(245, 260, 30, 40); // Inicializamos la rana en la posición (245, 260) con un tamaño de 30x40 con la llamada a la superclase.

    }
    public void paint(Graphics g) {
        g.setColor(Color.GREEN); // Establecemos el color de la rana a verde
        g.fillRect(x, y, width, height); // Dibujamos la rana como un rectángulo
    }
    public void actualizar(int dirección){
        switch (dirección) {
            case ARRIBA:
                y -= VEL; // Mueve la rana hacia arriba
                break;
            case ABAJO:
                y += VEL; // Mueve la rana hacia abajo
                break;
            case IZQUIERDA:
                x -= VEL; // Mueve la rana hacia la izquierda
                break;
            case DERECHA:
                x += VEL; // Mueve la rana hacia la derecha
                break;
        }
    }
    
}
