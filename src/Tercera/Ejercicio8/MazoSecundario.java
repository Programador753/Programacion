/*
Este mazo simplemente muestra la carta superior de la baraja principal 
cuando se roba, sin restricciones especiales.
*/

package Tercera.Ejercicio8;

public class MazoSecundario extends Mazo {
    public static final int POSICIONX = 110;
    public static final int POSICIONY = 20;
    
    public MazoSecundario() { //Constructor
        super(POSICIONX, POSICIONY, Carta.ANCHURA, Carta.ALTURA);
    }
    // Implementa el método anadir - acepta cualquier carta
    public boolean anadir(Carta c) {
        cartas.add(c);
        return true;
    }
    // Implementa el método recolocar
    public void recolocar() {
        this.extraer().setPosicion(POSICIONX, POSICIONY);
    }
}