/*
Cadena de caracteres.
Implementar una función que devuelva el número de espacios en
blanco que contiene una cadena.
Y luego sacar el numero de palabras en el programa principal.
 */
package Primera;

public class Ejercicio058 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        
        System.out.printf("El número de palabras es %d\n",espacios(frase)+1);
    }
    public static int espacios (char cadena[]){
        int contador = 0;
        for (int i = 0; i < cadena.length; i++)
            if (cadena[i] == ' ')
                contador ++;
        return contador;
    }
}
