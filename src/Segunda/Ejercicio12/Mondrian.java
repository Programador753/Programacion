package Segunda.Ejercicio12;

import java.applet.Applet; // Importo la clase Applet
import java.awt.Color; // Importo la clase Color
import java.awt.Graphics; // Importo la clase Graphics
import java.awt.Image; // Importo clase Imagen


public class Mondrian extends Applet implements Runnable{
    public static final int ARRIBA = 0; // Constante ARRIBA
    public static final int ABAJO = 1; // Constante ABAJO
    public static final int IZQUIERDA = 2; // Constante IZQUIERDA
    public static final int DERECHA = 3; // Constante DERECHA
    int direccion; // Variable de tipo entero
    Thread animacion; // Objeto de la clase Thread
    int posX , posY; // Variables de tipo entero
    Image imagen; // Objeto de la clase Imagen
    Graphics noseve; // Objeto de la clase Graphics
    public void init(){  // Metodo init 
        posX = 80; // Inicializo la variable posX
        posY = 100; // Inicializo la variable posY
        imagen = this.createImage(300, 300); // Creo una imagen 
        noseve = imagen.getGraphics(); // Obtiene los graficos de la imagen
        direccion = DERECHA; // Inicializo la variable direccion
    }
    public void start(){
        animacion = new Thread(this); // Instancio el objeto animacion
        animacion.start(); // Inicializo el objeto animacion
    }
    public void paint(Graphics g){ // Metodo paint
        noseve.setColor(Color.BLACK); // Color blanco
        noseve.fillRect(0, 0, 300, 300); // Dibuja un rectangulo
        noseve.setColor(Color.yellow); // Color amarillo
        noseve.fillRect(0, 0, 90, 90); // Dibuja un rectangulo
        noseve.fillRect(250,0,40,190); // Dibuja un rectangulo
        noseve.fillRect(80, 160, 100, 120); // Dibuja un rectangulo
        noseve.setColor(Color.BLUE); // Color azul
        noseve.fillRect(80, 220, 220, 90); // Dibuja un rectangulo
        noseve.fillRect(100, 10, 90, 80); // Dibuja un rectangulo
        noseve.setColor(Color.LIGHT_GRAY); // Color gris claro
        noseve.fillRect(posX, posY, 110, 90); // Dibuja un rectangulo
        noseve.setColor(Color.RED); // Color rojo
        noseve.fillRect(200, 0, 45, 45); // Dibuja un rectangulo
        noseve.fillRect(0, 110, 70, 200); // Dibuja un rectangulo
        noseve.setColor(Color.MAGENTA); // Color magenta
        noseve.fillRect(200, 55, 60, 135); // Dibuja un rectangulo
        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen
    }
    public void update(Graphics g){ // Metodo update
        paint(g); // Llama al metodo paint
    }
    @Override
    public void run() { // Metodo run
        do{ // Bucle do while 
            switch (direccion) { // Estructura switch para agujas del reloj
                case ARRIBA: // Caso ARRIBA
                    posY -= 10; // Decrementa la variable posY
                    if(posY < 0) // Condicion si posY es menor a 0
                        direccion = DERECHA; // Cambia la direccion a DERECHA
                    break; // Rompe el caso
                case ABAJO: // Caso ABAJO
                    posY += 10; // Incrementa la variable posY
                    if(posY > 210) // Condicion si posY es mayor a 210
                        direccion = IZQUIERDA; // Cambia la direccion a IZQUIERDA
                    break; // Rompe el caso
                case IZQUIERDA: // Caso IZQUIERDA
                    posX -= 10; // Decrementa la variable posX
                    if(posX < 0) // Condicion si posX es menor a 0
                        direccion = ARRIBA; // Cambia la direccion a ARRIBA
                    break; // Rompe el caso
                case DERECHA: // Caso DERECHA
                    posX += 10; // Incrementa la variable posX
                    if(posX > 190) // Condicion si posX es mayor a 190
                        direccion = ABAJO; // Cambia la direccion a ABAJO
                    break; // Rompe el caso
                default:
                    break;
            }
            repaint(); // Llama al metodo repaint
            try { // Manejo de excepciones 
                Thread.sleep(100); // Tiempo de espera
            } catch (InterruptedException ex) {} // Excepcion a manejar 
        }while(true); // Bucle infinito 
    }

}
