/*
Eliminar un caracter de la cadena tantas veces como aparezca.
 */
package Primera;

public class Ejercicio073 {
    public static void main(String arg[]) {
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char caracter = 'n';
        int longitud = frase.length;
        
        for(int i = 0; i < longitud; i++)
            if(frase[i] == caracter){
                for(int j = i; j < longitud-1; j++)
                    frase[j] = frase[j+1];
                frase[longitud-1] = ' ';
                longitud--;
            }
        
        System.out.println(frase); // Imprimo frase2.
    }
}
