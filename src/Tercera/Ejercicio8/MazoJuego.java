/* 
Este mazo implementa las reglas específicas del solitario para las columnas de juego:

Una carta solo se puede añadir si el mazo está vacío o si la carta es de color diferente 
y su valor es una unidad menor que la carta superior.

Al recolocar, las cartas se disponen en cascada (cada carta 30 píxeles más abajo que la anterior)
*/

package Tercera.Ejercicio8;

public class MazoJuego extends Mazo {
    public static final int POSICIONY = 170;
    
    public MazoJuego(int posX) {  // Constructor
        super(posX, POSICIONY, Carta.ANCHURA, Carta.ALTURA);
    }
    
    public boolean anadir(Carta carta) {  // Implementa el método anadir
        if(cartas.isEmpty() || (carta.getColor() != extraer().getColor()) && (carta.getValor()+1 == extraer().getValor())) {
            cartas.add(carta);
            recolocar();
            return true;
        }
        return false;
    }
    
    public void recolocar() { // Implementa el método recolocar
        if(cartas.size() == 1) {
            extraer().setPosicion(x, y);
        } else {
            extraer().setPosicion(x, this.extraer().y+30);
        }
    }
}