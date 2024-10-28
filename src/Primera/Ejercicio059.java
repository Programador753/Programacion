/*
1. Implementar un método que cargue en fraseMod el contenido de
frase sustituyendo los espacios en blanco por una 'X'.
 */
package Primera;

public class Ejercicio059 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char fraseMod[] = new char[50];
        
        modificar(frase, fraseMod);
        System.out.println(fraseMod);
        System.out.println(modificar(frase));
    }
    public static void modificar (char cadena[], char mod[]){
        for (int i = 0; i < cadena.length; i++)
            if (cadena[i] == ' ')
                mod[i] = 'X';
            else 
                mod[i] = cadena[i];
    }
    public static char[] modificar (char cadena[]){
        char mod[] = new char[50];
        for (int i = 0; i < cadena.length; i++)
            if (cadena[i] == ' ')
                mod[i] = 'X';
            else 
                mod[i] = cadena[i];
        return mod;       
    }
}
