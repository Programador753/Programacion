package AntonioHernandezCaveroTerceraProgramacion;
/* Grid de celdas de 10 filas x 7 columnas con celdas de 50 x 50 pixeles. */

import java.applet.Applet;
import java.util.ArrayList;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Event;
import java.awt.Point;

public class DragAndMerge extends Applet implements Runnable{
    public static final int NUM_COLUMNAS = 7; // 7 columnas 
    public static final int NUM_FILAS = 10; // 10 FILAS
    public static final int TAM_CELDA = 50; // Tamaño de cada celda
    Image imagen;
    Graphics noseve;
    Fila filas[] = new Fila[NUM_FILAS]; // Array de filas
    
    // Variables para manejar el drag and drop
    private boolean isDragging = false;
    private Pieza piezaArrastrada = null;
    private int filaOriginal = -1;
    private int columnaOriginal = -1;
    private int xOffset, yOffset;
    private Point posicionOriginal = new Point(0, 0); // Almacena la posición original de la pieza arrastrada

    public void init() { // Inicializa el applet
        imagen = this.createImage(700, 800); 
        noseve = imagen.getGraphics(); 
        for(int i = 0; i < NUM_FILAS; i++) {
            filas[i] = new Fila(i);
        }
        
        
        for(int i = 0; i < 3; i++) {
            filas[NUM_FILAS - 1 - i].cargarFila(); // Carga desde la última fila hacia arriba
        }
        
        this.setSize(700, 800); // Establece el tamaño del applet
        Thread t = new Thread(this);
        t.start();
    }

    public void update(Graphics g) { // Actualiza el applet
        paint(g);   // Llama al metodo paint para dibujar el applet
    }
    
    public void paint(Graphics g) { // Dibuja el applet
        noseve.setColor(Color.white);
        noseve.fillRect(0, 0, 700, 800); // Dibuja el fondo
        noseve.setColor(Color.black);
        // Dibuja el grid
        for(int i = NUM_COLUMNAS; i > 0; i--) {
            for(int j = 0; j < NUM_FILAS; j++) {
                int x = (i - 1) * TAM_CELDA + 150;
                int y = j * TAM_CELDA + 100;
                noseve.drawRect(x, y, TAM_CELDA, TAM_CELDA); // Dibuja la celda
            }
        }

        // Dibuja las filas
        for(int i = 0; i < NUM_FILAS; i++) {
            if (filas[i] != null) {
                try {
                    filas[i].paint(noseve, this); // Dibuja la fila
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Error al pintar la fila " + i + ": " + e.getMessage());
                }
            }
        }
        
        // Si hay una pieza siendo arrastrada, dibujarla encima de todo
        if (isDragging && piezaArrastrada != null) {
            piezaArrastrada.paint(noseve, this);
        }

        g.drawImage(imagen, 0, 0, this); // Dibuja la imagen en el applet
    }
    
    // Método para encontrar la pieza en la posición (x, y)
    private Pieza encontrarPieza(int x, int y) {
        for (int i = 0; i < NUM_FILAS; i++) {
            if (filas[i] != null) {
                for (int j = 0; j < NUM_COLUMNAS; j++) {
                    if (j < filas[i].piezas.size()) {
                        Pieza pieza = filas[i].piezas.get(j);
                        if (pieza != null && pieza.contains(x, y)) {
                            filaOriginal = i;
                            columnaOriginal = j;
                            return pieza;
                        }
                    }
                }
            }
        }
        return null;
    }
    
    // Método para encontrar la celda del grid en la posición (x, y)
    private Point encontrarCelda(int x, int y) {
        int columna = (x - 150) / TAM_CELDA;
        int fila = (y - 100) / TAM_CELDA;
        
        if (columna >= 0 && columna < NUM_COLUMNAS && fila >= 0 && fila < NUM_FILAS) {
            return new Point(columna, fila);
        }
        return null;
    }
    
    // Método para encontrar la pieza en una celda específica
    private Pieza encontrarPiezaEnCelda(int fila, int columna) {
        if (fila >= 0 && fila < NUM_FILAS && columna >= 0 && columna < NUM_COLUMNAS) {
            if (filas[fila] != null && columna < filas[fila].piezas.size()) {
                return filas[fila].piezas.get(columna);
            }
        }
        return null;
    }
    
    // Manejo de eventos del mouse
    public boolean mouseDown(Event evt, int x, int y) {
        piezaArrastrada = encontrarPieza(x, y);
        if (piezaArrastrada != null) {
            isDragging = true;
            xOffset = x - piezaArrastrada.x; // Offset para el arrastre
            yOffset = y - piezaArrastrada.y;
            posicionOriginal.x = piezaArrastrada.x;
            posicionOriginal.y = piezaArrastrada.y;
            piezaArrastrada.setPosicion(x - xOffset, y - yOffset); // Establecer la nueva posición
            filaOriginal = (y - 100) / TAM_CELDA; // Guardar la fila original
            columnaOriginal = (x - 150) / TAM_CELDA; // Guardar la columna original
        } else {
            isDragging = false;
        }
        repaint();
        return true;
    }
    
    public boolean mouseDrag(Event evt, int x, int y) {
        if (isDragging && piezaArrastrada != null) {
            piezaArrastrada.setPosicion(x - xOffset, y - yOffset);
            repaint();
        }
        return true;
    }
    
    public boolean mouseUp(Event evt, int x, int y) {
        if (isDragging && piezaArrastrada != null) {
            Point celda = encontrarCelda(x, y);
            if (celda != null) {
                Pieza piezaDestino = encontrarPiezaEnCelda(celda.y, celda.x);
                
                // Verificar si se puede combinar (misma pieza y mismo número)
                if (piezaDestino != null && piezaDestino != piezaArrastrada && 
                    piezaDestino.getNumero() == piezaArrastrada.getNumero()) {
                    
                    // Combinar piezas - incrementar valor y cambiar color
                    piezaDestino.incrementarNumero();
                    
                    // Eliminar la pieza arrastrada de su posición original
                    if (filaOriginal >= 0 && filaOriginal < NUM_FILAS && 
                        columnaOriginal >= 0 && columnaOriginal < filas[filaOriginal].piezas.size()) {
                        filas[filaOriginal].piezas.set(columnaOriginal, null);
                    }
                } else {
                    // Si no se puede combinar, volver a la posición original
                    piezaArrastrada.setPosicion(posicionOriginal.x, posicionOriginal.y);
                }
            } else {
                // Si se suelta fuera del grid, volver a la posición original
                piezaArrastrada.setPosicion(posicionOriginal.x, posicionOriginal.y);
            }
            
            isDragging = false;
            piezaArrastrada = null;
            repaint();
        }
        return true;
    }

    // Método para encontrar el valor máximo de las piezas en el tablero
    private int encontrarValorMaximo() {
        int maximo = 1; // El valor mínimo es 1
        
        for (int i = 0; i < NUM_FILAS; i++) {
            if (filas[i] != null) {
                for (Pieza pieza : filas[i].piezas) {
                    if (pieza != null && pieza.getNumero() > maximo) {
                        maximo = pieza.getNumero();
                        // Establecer un límite máximo de 10 según las instrucciones
                        if (maximo >= 10) {
                            return 10;
                        }
                    }
                }
            }
        }
        
        return maximo;
    }

    @Override
    public void run(){
        int contador = 0;
        do {
            contador++;
            if (contador % 10 == 0) { // Cada 10 segundos (10 iteraciones de 1 segundo)
                // Encontrar el valor máximo de las piezas en el tablero
                int valorMaximo = encontrarValorMaximo();
                
                // Desplazar las filas hacia arriba (mover las referencias de las filas)
                for (int i = 0; i < NUM_FILAS - 1; i++) {
                    filas[i] = filas[i + 1];
                    if (filas[i] != null) {
                        filas[i].setFilaIndex(i);
                    }
                }
                
                // Crear una nueva fila en la parte inferior (la última fila, índice NUM_FILAS - 1)
                filas[NUM_FILAS - 1] = new Fila(NUM_FILAS - 1);
                filas[NUM_FILAS - 1].cargarFila(valorMaximo); // Cargar con valores entre 1 y el máximo
                
                // Actualizar las posiciones visuales de todas las piezas
                for (int i = 0; i < NUM_FILAS; i++) {
                    if (filas[i] != null) {
                        filas[i].actualizarPosicionesPiezas();
                        
                        // Eliminar nulls de la lista de piezas
                        for (int j = 0; j < filas[i].piezas.size(); j++) {
                            if (filas[i].piezas.get(j) == null) {
                                filas[i].piezas.remove(j);
                                j--; // Ajustar el índice después de la eliminación
                            }
                        }
                    }
                }
            }
            repaint();
            try {
                Thread.sleep(1000); // Esperar 1 segundo
            } catch (InterruptedException e) {}
        } while (true);
    }
}
