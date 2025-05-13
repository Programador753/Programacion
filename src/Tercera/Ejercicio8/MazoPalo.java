/* Este mazo implementa las reglas para los montones finales:
Solo se puede comenzar con un As (valor 1)

Las cartas añadidas deben ser del mismo palo y en orden ascendente (2 sobre 1, 3 sobre 2, etc.)

Todas las cartas se apilan en la misma posición (una encima de otra)
*/
package Tercera.Ejercicio8;

public class MazoPalo extends Mazo {
    public static final int POSICIONY = 20;
    int palo;
    
    public MazoPalo(int posX) { // Constructor
        super(posX, POSICIONY, Carta.ANCHURA, Carta.ALTURA);
    }
    
    public boolean anadir(Carta carta) { // Implementa el método anadir
        if(cartas.isEmpty() && carta.getValor()==1) {
            cartas.add(carta);
            palo = carta.getPalo();
            recolocar();
            return true;
        } else {
            if(palo == carta.getPalo() && (carta.getValor()-1 == cartas.get(cartas.size()-1).getValor())) {
                cartas.add(carta);
                recolocar();
                return true;
            }
        }
        return false;
    }
    
    public void recolocar() { // Implementa el método recolocar
        this.extraer().setPosicion(x, POSICIONY);
    }
}