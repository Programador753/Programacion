/*
Modificar la frase de manera que cada palabra desplace sus letras
una posición a la derecha y la última letra se coloque en la 
primera posición.
Y hacer lo mismo pero a la izquierda
 */
package Primera;

public class Ejercicio066 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        int inicio, fin;
        inicio = fin = 0;
        
        while(fin < frase.length){
            while(frase[fin] != ' ')
                fin++;
            despDerecha(frase, fin, inicio);
            despIzquierda(frase, fin, inicio);
            inicio = fin = fin+1;
        }
        System.out.println(frase);
    }

    public static void despDerecha(char[] frase, int fin, int inicio) {
        char intercambio;
        intercambio = frase[fin-1];
        for(int i = fin-1; i > inicio; i--)
            frase[i] = frase[i-1];
        frase[inicio] = intercambio;
    }
    public static void despIzquierda(char[] frase, int fin, int inicio) {
        char intercambio;
        intercambio = frase[inicio];
        for (int i = inicio; i < fin - 1; i++)
            frase[i] = frase[i + 1];
        frase[fin - 1] = intercambio;
    }
}
