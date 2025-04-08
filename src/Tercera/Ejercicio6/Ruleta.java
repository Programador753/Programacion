package Tercera.Ejercicio6;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.util.ArrayList;


public class Ruleta extends Applet {

    public static final int FILAS = 12; // Dimensiones del tablero
    public static final int COLUMNAS = 3; // Dimensiones del tablero
    public static final int NUMJUGADAS = 10; // Número de fichas
    Image imagen; // Imagen del tablero
    Graphics noseve; // Gráficos para la imagen
    Casilla casillas[][]; // Matriz de casillas del tablero
    public int rojos[] = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36}; // Números rojos
    Ficha activa; // Ficha activa
    Image imagenFicha[]; // Imagen de la ficha
    ArrayList<Ficha> fichas[]; // ArrayList de fichas
    Button boton; // Botón para iniciar el juego
    int numeroSuerte; // Número de la suerte
    int jugadas[]; // Ultimas jugadas

    public void init() {
        imagen = this.createImage(1920, 1080); // Crea la imagen del tablero
        noseve = imagen.getGraphics(); // Obtiene los gráficos de la imagen

        setup();


        casillas = new Casilla[FILAS][COLUMNAS]; // Inicializa la matriz de casillas
        java.util.ArrayList<Integer> lRojos = new java.util.ArrayList<>(); // Lista para almacenar los números de las casillas

        for (int i = 0; i < rojos.length; i++) {
            lRojos.add(new Integer(rojos[i])); // Agrega los números rojos a la lista
        }

        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (lRojos.contains(new Integer((i * COLUMNAS) + j + 1))) {
                    casillas[i][j] = new Casilla((j * Casilla.DIM) + 30, (i * Casilla.DIM) + 50, (i * COLUMNAS) + j + 1, Color.RED.darker()); // Crea una casilla roja
                } else {
                    casillas[i][j] = new Casilla((j * Casilla.DIM) + 30, (i * Casilla.DIM) + 50, (i * COLUMNAS) + j + 1, Color.BLACK); // Crea una casilla negra
                }
            }
        }

        // Carga la imagen de la ficha
        imagenFicha = new Image[NUMJUGADAS]; // Inicializa la matriz de imágenes de la ficha
        for (int i = 0; i < NUMJUGADAS; i++) {
            imagenFicha[i] = getImage(getCodeBase(), "Tercera/Ejercicio6/Fichas/ficha" + (i + 1) + ".png"); // Carga la imagen de la ficha
        }
        // Crea lista de valores
        int valores[] = {1, 5, 10, 25, 50, 100, 500, 1000, 5000, 10000}; // Valores de las fichas

        // Inicializa el array de fichas
        fichas = new ArrayList[NUMJUGADAS]; // Inicializa el array de fichas

        for (int i = 0; i < NUMJUGADAS; i++) {
            fichas[i] = new ArrayList<Ficha>(); // Crea una nueva lista de fichas
            fichas[i].add(new Ficha(400, 50 + (i * Ficha.DIM), i, imagenFicha[i])); // Añade una ficha a la lista
        }
        // Inicializo jugadas
        jugadas = new int[NUMJUGADAS]; // Inicializa el array de jugadas


        // Establece el tamaño del applet
        this.setSize(1920, 1080); // Establece el tamaño del applet
    }

    private void setup() {
        Panel panel = new Panel(); // Crea un nuevo panel
        boton = new Button("Iniciar Juego"); // Crea un nuevo botón
        panel.add(boton); // Añade el botón al panel
        this.setLayout(new BorderLayout()); // Establece el diseño del applet
        this.setBackground(Color.green.darker()); // Establece el color de fondo del applet
        this.add("North", panel); // Añade el panel al applet
        this.setSize(1920, 1080); // Establece el tamaño del applet
        this.setVisible(true); // Hace visible el applet
        this.setFocusable(true); // Establece el applet como enfocable
        this.requestFocus();

        

        
    }

    public void update(Graphics g) {
        paint(g); // Llama al método paint para dibujar el applet
    }

    public void paint(Graphics g) {
        // Dibuja el tablero
        noseve.setColor(Color.green.darker()); // Establece el color de fondo
        noseve.fillRect(0, 0, 1920, 1080); // Dibuja el fondo verde

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                casillas[i][j].paint(noseve); // Dibuja cada casilla en el tablero
            }
        }
        // Efecto de múltiples fichas con desplazamiento
        for (int i = 0; i < NUMJUGADAS; i++) {
            for (int j = 0; j < fichas[i].size(); j++) {
                fichas[i].get(j).paint(noseve, this); // Dibuja cada ficha en el tablero
            }
        }
        
        
        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen del tablero en el applet
    }

    public boolean mouseDown(Event e, int x, int y) {
        // Comprueba si se ha hecho clic en una ficha
        if (activa == null) {
            for (int i = 0; i < NUMJUGADAS; i++) {
                for (int j = 0; j < fichas[i].size(); j++) {
                    if (fichas[i].get(j).contains(x, y)) { // Comprueba si el clic está dentro de la ficha
                        activa = fichas[i].get(j); // Establece la ficha activa
                        if (Math.abs(activa.x - 400) <= 20 && Math.abs(activa.y - (50 + i * Ficha.DIM)) <= 20) // Comprueba si la ficha está en su posición original
                        {
                            fichas[i].add(new Ficha(activa.x, activa.y, activa.precio, activa.fichaImage)); // Añade la ficha activa a la lista 
                            return true; // Sale del método si se ha hecho clic en una ficha
                        }
                    }
                }
            }
        }

        return false;
    }

    public boolean mouseDrag(Event e, int x, int y) {
        // Mueve la ficha activa con el ratón
        if (activa != null) {
            activa.mover(x, y); // Mueve la ficha activa a la posición del ratón
            repaint(); // Vuelve a dibujar el applet
        }
        return true;
    }

    public boolean mouseUp(Event e, int x, int y) {
        // Comprueba si se ha soltado el ratón sobre una casilla
        if (activa != null) {
            activa.cargarApostados(casillas); // Carga las casillas apostadas por la ficha activa
            activa = null; // Establece la ficha activa a null
            repaint(); // Vuelve a dibujar el applet

        }
        return true;
    }

    public boolean action(Event e, Object o) {
        // Comprueba si se ha hecho clic en el botón
        if (e.target instanceof Button) {

            this.jugadas = new int[NUMJUGADAS]; // Inicializa el array de jugadas
            for (int i = 0; i < NUMJUGADAS; i++) {
                this.jugadas[i] = (int)(Math.random() * 37); // Genera un número aleatorio entre 0 y 36 para cada jugada
            }

            return true;
        }
        return true;
    }
}
