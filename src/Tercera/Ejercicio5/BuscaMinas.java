package Tercera.Ejercicio5;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;


public class BuscaMinas extends Applet{
    public static final int DIM = 10; // Dimensiones del tablero
    Image imagen; // Imagen del tablero
    Graphics noseve; // Gráficos para la imagen
    Image mina; // Imagen de la mina
    Image reverso; // Imagen del reverso de la mina
    Casilla casillas[][]; // Matriz de casillas del tablero
    


    public void init(){
        imagen = this.createImage(400, 500); // Crea la imagen del tablero
        noseve = imagen.getGraphics(); // Obtiene los gráficos de la imagen

        mina = getImage(getCodeBase(), "Tercera/Ejercicio5/Imagenes/mina.png"); // Carga la imagen de la mina
        reverso = getImage(getCodeBase(), "Tercera/Ejercicio5/Imagenes/casilla.png"); // Carga la imagen del reverso de la mina

     
        casillas = new Casilla[DIM][DIM]; // Inicializa la matriz de casillas
        for (int i = 0; i < DIM; i++){
            for (int j = 0; j < DIM; j++){
                casillas[i][j] = new Casilla(100 + (j * Casilla.TAM), 100 + (i * Casilla.TAM), reverso); // Crea una nueva casilla en la posición correspondiente
            }
        }

        // Situamos las minas en el tablero de forma aleatoria
        for (int i = 0; i < 10; i++){
            int x = (int)(Math.random() * DIM); // Genera una posición aleatoria en el eje X
            int y = (int)(Math.random() * DIM); // Genera una posición aleatoria en el eje Y
            casillas[x][y].setMina(mina); // Asigna la imagen de la mina a la casilla correspondiente
            casillas[x][y].setTapada(true); // Mantiene la mina tapada

            // Incrementa el contador de minas alrededor de las casillas adyacentes
            for (int i2 = -1; i2 <= 1; i2++){
                for (int j2 = -1; j2 <= 1; j2++){
                    if ((x + i2 >= 0) && (x + i2 < DIM) && (y + j2 >= 0) && (y + j2 < DIM)){
                        casillas[x + i2][y + j2].setAlrededor(casillas[x + i2][y + j2].getAlrededor() + 1); // Incrementa el contador de minas alrededor
                    }
                }
            }
            
        }

        // Establece el tamaño del applet
        this.setSize(400, 500); // Establece el tamaño del applet
    }

    public void update(Graphics g){
        paint(g); // Llama al método paint para dibujar el applet
    }

    public void paint(Graphics g){
        // Dibuja el tablero
        noseve.setColor(Color.GREEN); // Establece el color de fondo
        noseve.fillRect(0, 0, 700, 500); // Dibuja el fondo verde
        for (int i = 0; i < DIM; i++){
            for (int j = 0; j < DIM; j++){
                casillas[i][j].paint(noseve, this); // Dibuja cada casilla en el tablero
            }
        }


        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen del tablero en el applet
    }

    public boolean mouseDown(Event ev, int x, int y){
        // Recorre la matriz de casillas para verificar si se ha hecho clic en alguna de ellas
        for (int i = 0; i < DIM; i++){
            for (int j = 0; j < DIM; j++){
                if (casillas[i][j].contains(x, y)){ // Verifica si la posición del clic está dentro de la casilla
                    casillas[i][j].setTapada(false); // Desbloquea la casilla
                    repaint(); // Vuelve a dibujar el applet
                }
            }
        }
        return true; // Indica que el evento ha sido manejado
    }
}
