/*
Meter frase en cadena2, pero sus caracteres se alojarán en orden inverso.
 */
package Primera;

public class Ejercicio069 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char cadena2[] = new char[150];
        
        for(int i = 0; i < frase.length; i++)
            cadena2[(frase.length-1)-i] = frase[i];
        
        System.out.println(cadena2);
    }
}
