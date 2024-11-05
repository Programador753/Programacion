/*
Copiar el contenido de frase en cadena2, dos veces.
 */
package Primera;

public class Ejercicio068 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a', ' '};
        char cadena2[] = new char[150];
        int i;
        
        for(i = 0; i < frase.length; i++)
            cadena2[i] = frase[i];
        for(int j = 0; j < frase.length; j++, i++)
            cadena2[i] = frase[j];
                
        System.out.println(cadena2);
    }
}
