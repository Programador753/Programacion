/* GRUPOS DE PIEZAS POR FILAS 
 * Al generar la fila cargo cada pieza con un numero aleatorio inicalmente del 1 al 4 posteriormente ira aumentando 
 * y se irá aumentando segun el numero maximo de la pieza del tablero para poder generar piezas con el mismo valor maximo 
 */
package AntonioHernandezCaveroTerceraProgramacion;


import java.applet.Applet;
import java.awt.Graphics;
import java.util.ArrayList;


public class Fila {

    public ArrayList<Pieza> piezas;
    private int numFila;
    
    public Fila(int numFila) {
        this.numFila = numFila;
        piezas = new ArrayList<>();
    }

    // Método para cargar la fila con piezas de valores aleatorios
    // Por defecto, genera piezas con valores del 1 al 4 (para las filas iniciales)
    public void cargarFila() {
        cargarFila(4); // Usa el máximo por defecto (4) para las primeras filas
    }
    
    // Sobrecarga del método para generar piezas con valores hasta el máximo actual del tablero
    public void cargarFila(int valorMaximo) {
        piezas.clear(); // Asegurarse de que la lista esté vacía al cargar una nueva fila
        
        for(int i = 0; i < DragAndMerge.NUM_COLUMNAS; i++) {
            // Crea una nueva pieza en la posición correspondiente de la grid
            int posX = i * DragAndMerge.TAM_CELDA + 150;
            int posY = numFila * DragAndMerge.TAM_CELDA + 100;
            
            // Genera un número aleatorio entre 1 y el valor máximo actual
            int numero = (int) (Math.random() * valorMaximo) + 1;
            
            Pieza nuevaPieza = new Pieza(posX, posY, DragAndMerge.TAM_CELDA, numero);
            piezas.add(nuevaPieza);
        }
    }

    // Método para mover las piezas de la fila (hacia arriba o abajo)
    public void moverPiezasArriba(int tamCelda) {
        if (piezas == null || piezas.isEmpty()) {
            return; // No hay piezas que mover, salir del método
        }
        
        // Actualizar la posición Y de cada pieza en la fila (mover hacia arriba)
        for (Pieza pieza : piezas) {
            if (pieza != null) {
                pieza.setPosicion(pieza.x, pieza.y - tamCelda);
            }
        }
    }
    
    // Método para mover las piezas hacia abajo
    public void moverPiezasAbajo(int tamCelda) {
        if (piezas == null || piezas.isEmpty()) {
            return; // No hay piezas que mover, salir del método
        }
        
        // Actualizar la posición Y de cada pieza en la fila (mover hacia abajo)
        for (Pieza pieza : piezas) {
            if (pieza != null) {
                pieza.setPosicion(pieza.x, pieza.y + tamCelda);
            }
        }
    }

    public void setFilaIndex(int index) {
        this.numFila = index;
    }

    // Método para subir la fila en el grid (actualizar posiciones)
    public void subirFila() {
        if (piezas == null || piezas.isEmpty()) {
            return; // No hay piezas que mover, salir del método
        }
        
        // Actualizar la posición Y de cada pieza en la fila
        for (Pieza pieza : piezas) {
            if (pieza != null) {
                pieza.setPosicion(pieza.x, numFila * DragAndMerge.TAM_CELDA + 100);
            }
        }
    }

    // Método para actualizar las posiciones de las piezas según el índice de fila actual
    public void actualizarPosicionesPiezas() {
        if (piezas == null || piezas.isEmpty()) {
            return;
        }
        
        for (int i = 0; i < piezas.size(); i++) {
            Pieza pieza = piezas.get(i);
            if (pieza != null) {
                int posX = i * DragAndMerge.TAM_CELDA + 150;
                int posY = numFila * DragAndMerge.TAM_CELDA + 100;
                pieza.setPosicion(posX, posY);
            }
        }
    }

    // Actualiza los números de las piezas en esta fila según el máximo
    public void actualizarNumerosPiezas(int maxNumero) {
        if (piezas == null || piezas.isEmpty()) {
            return;
        }
        
        for (Pieza pieza : piezas) {
            if (pieza != null) {
                // Generar número entre 1 y el máximo encontrado
                int numero = (int) (Math.random() * maxNumero) + 1;
                pieza.setNumero(numero);
            }
        }
    }
    public void paint(Graphics g, Applet applet) {
        // Verifica si la lista de piezas está vacía antes de intentar acceder a ella
        if (piezas == null || piezas.isEmpty()) {
            return; // No hay piezas que dibujar, salir del método
        }
        
        // Dibuja todas las piezas de la fila desde abajo hacia arriba (última a primera)
        for (int i = piezas.size() - 1; i >= 0; i--) {
            Pieza pieza = piezas.get(i);
            if (pieza != null) {
                pieza.paint(g, applet);
            }
        }
    }
}
