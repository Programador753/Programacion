/*
Meter frase en cadena2 dos veces, la primera en orden y la seguna en orden inverso.
 */
package Primera;

public class Ejercicio070 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char cadena2[] = new char[150];
        int i;
        for(i = 0; i < frase.length; i++)
            cadena2[i] = frase[i];        
        
        for(int j = i-1; j >=0 ; j--, i++)
            cadena2[i] = frase[j];
        
        System.out.println(cadena2);        
    }
}
