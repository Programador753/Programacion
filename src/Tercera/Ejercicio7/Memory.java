package Tercera.Ejercicio7;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Memory extends Applet {
    Image imagen; // Imagen del tablero
    Graphics noseve; // Gráficos para la imagen
    Image imagenes[]; // Imágenes de las fichas
    Image reverso; // Imagen del reverso de las fichas
    Casilla casillas[][]; // Array de casillas

    @Override
    public void init() {
        imagen = this.createImage(1920, 1080); // Crea una imagen para el tablero
        noseve = imagen.getGraphics(); // Obtiene los gráficos de la imagen
        
        imagenes = new Image[8]; // Inicializa el array de imágenes de las fichas
        casillas = new Casilla[4][4]; // Inicializa el array de casillas
        // Carga las imágenes de las fichas
        for (int i = 0; i < imagenes.length; i++) {
            imagenes[i] = this.getImage(getCodeBase(), "Tercera/Ejercicio7/donutsMatch/img" + (i + 1) + ".png"); // Carga la imagen de la ficha
        }
        reverso = this.getImage(getCodeBase(), "Tercera/Ejercicio7/donutsMatch/reverso.png"); // Carga la imagen del reverso de las fichas

        // Bucle para desordenar las imágenes con un vector de 8 elementos
        int indices[] = new int[16]; // Inicializa el array de índices
        for (int i = 0; i < 8; i++) {
            indices[i] = i; // Asigna el índice de la imagen
            indices[i + 8] = i; // Asigna el índice de la imagen duplicada
        }
        // Desordena el array de índices
        for (int i = 0; i < indices.length; i++) {
            int aleatorio = (int) (Math.random() * 16); // Genera un índice aleatorio
            int temp = indices[i]; // Almacena el valor actual
            indices[i] = indices[aleatorio]; // Intercambia los valores
            indices[aleatorio] = temp; // Intercambia los valores
        }


        // Inicializa las casillas con las imágenes desordenadas
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j] = new Casilla(i * Casilla.DIM, j * Casilla.DIM, imagenes[indices[i * 4 + j]], reverso); // Crea una nueva casilla                   
            }
        }
        

        // Establece el tamaño del applet
        this.setSize(1920, 1080); // Establece el tamaño del applet
    }

    @Override
    public void update(Graphics g) {
        paint(g); // Llama al método paint para dibujar el applet
        
    }

    @Override
    public void paint(Graphics g) {
        noseve.setColor(Color.green.darker()); // Establece el color de fondo
        noseve.fillRect(0, 0, 1920, 1080); // Dibuja el fondo verde

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                casillas[i][j].paint(noseve, this); // Dibuja cada casilla
            }
        }
        
        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen del tablero en el applet
    }

    
    public boolean mouseDown(Event e, int x, int y) {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].contains(x, y)) { // Verifica si el clic está dentro de la casilla
                    casillas[i][j].setDescubierta(true); // Marca la casilla como descubierta
                    controlCasillas(); // Llama al método para controlar las casillas descubiertas
                    repaint(); // Vuelve a dibujar el applet
                }
            }
        }
        return true; // Devuelve true para indicar que el evento ha sido manejado
    }

    // Control de las casillas descubiertas para verificar si son iguales
    public void controlCasillas() {
        int descubiertas = 0; // Contador de casillas descubiertas
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].isDescubierta()) { // Verifica si la casilla está descubierta
                    descubiertas++; // Incrementa el contador
                }
            }
        }
        if (descubiertas == 2) { // Si hay dos casillas descubiertas
            try {
                Thread.sleep(1000); // Espera un segundo
            } catch (InterruptedException e) {
                e.printStackTrace(); // Maneja la excepción
            }
            for (int i = 0; i < casillas.length; i++) {
                for (int j = 0; j < casillas[i].length; j++) {
                    if (!casillas[i][j].isDescubierta()) { // Si la casilla no está descubierta
                        casillas[i][j].setDescubierta(false); // Marca la casilla como no descubierta
                    }
                }
            }
        }
        // Verifica si todas las casillas están descubiertas
    }





}