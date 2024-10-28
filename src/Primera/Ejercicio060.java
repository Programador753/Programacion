/*
Implementar método que convierta la frase a mayusculas.
 */
package Primera;

public class Ejercicio060 {
    public static void main(String arg[]){
        char frase[] = {'E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
    
        System.out.println(modificar(frase));

    }
    public static char[] modificar (char cadena[]){
        char mod[] = new char[50];
        for (int i = 0; i < cadena.length; i++)
            mod[i] = Character.toUpperCase(cadena[i]);
        return mod;
    }    
}
