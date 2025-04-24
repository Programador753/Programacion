package Tercera.Ejercicio7;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;

public class Memory extends Applet implements Runnable {
    public static final int TIEMPO = 1000;
    Image imagen; // Imagen del tablero
    Graphics noseve; // Gráficos para la imagen
    Image imagenes[]; // Imágenes de las fichas
    Image reverso; // Imagen del reverso de las fichas
    Casilla casillas[][]; // Array de casillas
    Casilla casilla1 = null; // Ficha seleccionada 1
    Casilla casilla2 = null; // Ficha seleccionada 2
    int cuentaSegundos = 0; // Contador de segundos
    int temporal = 0; // Contador temporal
    Thread animacion; // Hilo para el temporizador

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

        desordenar();

        // Establece el tamaño del applet
        this.setSize(1920, 1080); // Establece el tamaño del applet
    }

    private void desordenar() {
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

    public int cuantas(){
        int cont = 0; // Contador de casillas descubiertas
        if (casilla1 != null) cont++; // Si la primera casilla está descubierta, incrementa el contador
        if (casilla2 != null) cont++; // Si la segunda casilla está descubierta, incrementa el contador
        return cont; // Devuelve el contador
    }
    public void start() {
        animacion = new Thread(this); // Crea un nuevo hilo para la animación
        animacion.start(); // Inicia el hilo
    }

    public boolean mouseDown(Event e, int x, int y) {
        for (int i = 0; i < casillas.length; i++) {
            for (int j = 0; j < casillas[i].length; j++) {
                if (casillas[i][j].contains(x, y)) { // Verifica si el clic está dentro de la casilla
                    casillas[i][j].setDescubierta(true); // Marca la casilla como descubierta
                    switch (cuantas()) { // Verifica cuántas casillas están descubiertas
                        case 0: // Si no hay casillas descubiertas
                            casilla1 = casillas[i][j]; // Asigna la primera casilla
                            break;
                        case 1: // Si hay una casilla descubierta
                            casilla2 = casillas[i][j];
                            if (casilla1.getImagen() == casilla2.getImagen()) { // Si las imágenes son iguales
                                casilla1 = null; // Reinicia la primera casilla
                                casilla2 = null; // Reinicia la segunda casilla
                            } else { // Si las imágenes son diferentes debe esperar 3 segundos y ocultar las casillas usando el metodo run()
                                temporal = cuentaSegundos; // Almacena el tiempo actual
                            }
                            break;
                        case 2: // Si hay dos casillas descubiertas
                            casilla1.setDescubierta(false); // Oculta la primera casilla
                            casilla2.setDescubierta(false); // Oculta la segunda casilla
                            casilla1 = null; // Reinicia la primera casilla
                            casilla2 = null; // Reinicia la segunda casilla
                            temporal = cuentaSegundos; // Almacena el tiempo actual
                            break;
                        default: // Si hay más de dos casillas descubiertas
                    }
                    repaint(); // Vuelve a dibujar el applet
                }
            }
        }
        return true; // Devuelve true para indicar que el evento ha sido manejado
    }

    @Override
    public void run() { 
        do {
            cuentaSegundos++; // Incrementa el contador de segundos
            if ((temporal != 0) &&(cuentaSegundos - temporal) == 3) { // Si han pasado 3 segundos
                casilla1.setDescubierta(false); // Oculta la primera casilla
                casilla2.setDescubierta(false); // Oculta la segunda casilla
                casilla1 = null; // Reinicia la primera casilla
                casilla2 = null; // Reinicia la segunda casilla
                repaint(); // Vuelve a dibujar el applet
            }
            try {
                Thread.sleep(TIEMPO); // Espera 100 milisegundos
            } catch (InterruptedException e) {}
        } while (true);
    }
}