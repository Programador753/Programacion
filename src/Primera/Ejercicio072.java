/*
Las palabras de frase están separadas por un espacio en blanco.
Meter en frase2 las mismas palabras que hay en frase, pero
en orden inverso.
 */
package Primera;

public class Ejercicio072 {
    public static void main(String arg[]) {
        char frase[] = {' ','E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char frase2[] = new char[150];
        int inicio , fin;
        inicio = fin = frase.length-1; 
        
        int x = 0;
        while(inicio > 0){
            while(frase[inicio] != ' ')
                inicio--;             
            for(int i = inicio  ;i <= fin; i++) // recorro la palabra
                frase2[x++] = frase[i]; // Cargo en frase 2 el valor de frase correspondiente y incremento el valor del indice
            fin = inicio = inicio -1; // Le paso a fin la posicion de inicio - 1 posicion 
        }   
        System.out.println(frase2); // Imprimo frase2.
    }
}
