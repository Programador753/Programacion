/*
Muestra por pantalla el número de ocasiones en el que la subcadena 
se encuentra dentro de frase.
 */
package Primera;

public class Ejercicio064 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', 'n', 'n', 'n', ' ', 'n', 'n', 'n', 'n', 'r', ' ', 'n', 'n', 'n', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char subcadena[] = {'n', 'n', 'n'};
        int cont = 0;
        
        for(int i = 0; i <= (frase.length - subcadena.length) ; i++){
            if(subcadena[0] == frase[i]){
                int j = 1;
                    while((j < subcadena.length) && (frase[i + j] == subcadena[j])){
                        j++;
                    }
                    if (j == subcadena.length)
                        cont ++;
            }
        }
        System.out.printf("La cadena esta %d veces dentro de la frase\n", cont);
    }
}
