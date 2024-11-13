/*
Dado un String, eliminar de él los espacios en blanco, sin
utilizar la función replace
 */
package Primera;

public class Ejercicio083 {
    public static void main(String arg[]) {
        String frase = "Había una vez, un circo, que alegraba siempre el corazon";

        int posicion = frase.indexOf(" ");
        while(posicion != -1){
            frase = frase.substring(0, posicion).concat(frase.substring(posicion+1));
            posicion = frase.indexOf(" ", posicion+1);
        }
        System.out.println(frase);
    }    
}
