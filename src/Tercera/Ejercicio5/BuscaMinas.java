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
    Image bandera; // Imagen de la bandera
    Casilla casillas[][]; // Matriz de casillas del tablero
    


    public void init(){
        imagen = this.createImage(400, 500); // Crea la imagen del tablero
        noseve = imagen.getGraphics(); // Obtiene los gráficos de la imagen

        mina = getImage(getCodeBase(), "Tercera/Ejercicio5/Imagenes/mina.png"); // Carga la imagen de la mina
        reverso = getImage(getCodeBase(), "Tercera/Ejercicio5/Imagenes/casilla.png"); // Carga la imagen del reverso de la mina
        bandera = getImage(getCodeBase(), "Tercera/Ejercicio5/Imagenes/bandera.png"); // Carga la imagen de la bandera

     
        casillas = new Casilla[DIM][DIM]; // Inicializa la matriz de casillas
        for (int i = 0; i < DIM; i++){
            for (int j = 0; j < DIM; j++){
                casillas[i][j] = new Casilla(100 + (j * Casilla.TAM), 100 + (i * Casilla.TAM), reverso); // Crea una nueva casilla en la posición correspondiente
            }
        }

        int resultados[] = obtenerAleatorio(); // Obtiene las posiciones aleatorias de las minas

        for (int i = 0; i < DIM; i++){
            int x = resultados[i] / DIM; // Calcula la fila de la mina
            int y = resultados[i] % DIM; // Calcula la columna de la mina
            casillas[x][y].setMina(mina); // Establece la imagen de la mina en la casilla correspondiente
            casillas[x][y].setAlrededor(-1); // Marca la casilla como mina
        }

        // Calcula el número de minas alrededor de cada casilla
        for (int i = 0; i < DIM; i++){
            for (int j = 0; j < DIM; j++){
                if (casillas[i][j].getAlrededor() != -1){ // Si no es una mina
                    int alrededor = 0; // Inicializa el contador de minas alrededor
                    for (int k = -1; k <= 1; k++){
                        for (int l = -1; l <= 1; l++){
                            if ((i + k >= 0) && (i + k < DIM) && (j + l >= 0) && (j + l < DIM)){
                                if (casillas[i + k][j + l].getAlrededor() == -1){ // Si hay una mina alrededor
                                    alrededor++; // Incrementa el contador
                                }
                            }
                        }
                    }
                    casillas[i][j].setAlrededor(alrededor); // Establece el número de minas alrededor en la casilla
                }
            }
        }


        // Establece el tamaño del applet
        this.setSize(400, 500); // Establece el tamaño del applet
    }

    private int[] obtenerAleatorio() {
        // Situamos las minas en el tablero de forma aleatoria
        int resultados[] = new int[DIM ]; // Array para almacenar las posiciones de las minas
        int vector[] = new int[DIM * DIM]; // Array para almacenar las posiciones de las minas
        for (int i = 0; i < (DIM * DIM); i++){
            vector[i] = i; // Inicializa el array con los índices
        }
        for(int i = 0; i < DIM; i++){
            int aleatorio = (int)(Math.random() * (DIM * DIM - i)); // Genera un número aleatorio
            resultados[i] = vector[aleatorio]; // Almacena la posición de la mina
            vector[aleatorio] = vector[DIM * DIM - i - 1]; // Reemplaza la posición en el array
        }
        return resultados;
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

    // Método para manejar eventos de ratón para descubrir casillas y colocar banderas
    public boolean mouseDown(Event e, int x, int y) {
        for (int i = 0; i < DIM; i++){
            for (int j = 0; j < DIM; j++){
                if (casillas[i][j].contains(x, y)){ // Verifica si el clic está dentro de la casilla
                    if ((e.modifiers & Event.META_MASK) != 0) { // Click derecho
                        // Coloca una bandera en la casilla
                        casillas[i][j].setBandera(bandera);
                    } else { // Click izquierdo
                        // Descubre la casilla
                        casillas[i][j].setTapada(false);
                    }
                    break; // Salir del bucle una vez encontrada la casilla
                }
            }
        }
        repaint(); // Vuelve a dibujar el applet
        return true;
    }
}
