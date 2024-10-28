/*
Implementar una función que reciba la frase y sustituya el 
caracter a sustituir por el caracter sustituto.
 */
package Primera;

public class Ejercicio061 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        char sustituir = 'a';
        char sustituto = 'X';
        modificar(frase, sustituir, sustituto);
        System.out.println(frase);
    }
        public static void modificar (char cadena[], char sustituir, char sustituto){
            for (int i = 0; i < cadena.length; i++)
                if (cadena[i] == sustituir)
                    cadena[i] = sustituto;               
        }
}
