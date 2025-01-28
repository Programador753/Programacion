package Segunda.Ejercicio12;

import java.awt.Color; // Importa la clase Color
import java.awt.Graphics; // Importa la clase Graphics

public class Rectangulo {
    public static final int ARRIBA = 0; // Constante ARRIBA
    public static final int ABAJO = 1; // Constante ABAJO
    public static final int IZQUIERDA = 2; // Constante IZQUIERDA
    public static final int DERECHA = 3; // Constante DERECHA
    int posXInicial; // Variable de tipo entero
    int posYInicial;  // Variable de tipo entero
    int posX, posY, ancho, alto; // Variables de tipo entero
    Color color; // Objeto de la clase Color
    int direccion; // Variable de tipo entero


    
    public Rectangulo(Color color, int posX, int posY, int ancho, int alto) { // Metodo constructor de la clase
        this.color = color; // Inicializo la variable color 
        this.posX = posX; // Inicializo la variable posX
        this.posY = posY; // Inicializo la variable posY
        this.ancho = ancho; // Inicializo la variable ancho 
        this.alto = alto; // Inicializo la variable alto 
        this.direccion = DERECHA; // Inicializo la variable direccion 
        posXInicial = posX; // Inicializo la variable posXInicial
        posYInicial = posY; // Inicializo la variable posYInicial
    }

    public void paint(Graphics g){
        g.setColor(color); // Establece el color del rectangulo 
        g.fillRect(posX, posY, ancho, alto); // Dibuja un rectangulo
    }

    public  void update() {
        switch (direccion) { // Estructura switch para agujas del reloj
            case ARRIBA: // Caso ARRIBA
                posY --; // Decrementa la variable posY
                if (posY <= posYInicial) { // Si la variable posY es menor o igual a posYInicial
                    direccion = DERECHA; // La variable direccion es igual a DERECHA
                }
                break; // Rompe el ciclo
            case ABAJO: // Caso ABAJO
                posY ++; // Incrementa la variable posY
                if (posY >= posYInicial + 20) { // Si la variable posY es mayor o igual a posYInicial + 20
                    direccion = IZQUIERDA; // La variable direccion es igual a IZQUIERDA
                }
                break; // Rompe el ciclo
            case IZQUIERDA: // Caso IZQUIERDA
                posX --; // Decrementa la variable posX
                if (posX <= posXInicial) { // Si la variable posX es menor o igual a posXInicial
                    direccion = ARRIBA; // La variable direccion es igual a ARRIBA
                }
                break; // Rompe el ciclo
            case DERECHA: // Caso DERECHA
                posX ++; // Incrementa la variable posX
                if (posX >= posXInicial + 20) { // Si la variable posX es mayor o igual a posXInicial + 20
                    direccion = ABAJO; // La variable direccion es igual a ABAJO
                }
                break; // Rompe el ciclo
        }
    }
}

