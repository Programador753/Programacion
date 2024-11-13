/*
Tenemos una cadena de caracteres cargada por palabras, cada 
palabra está separada de la siguiente por un espacio en blanco.
Modificar la cadena de manera que cada palabra quede con su
primer y último caracter de cada palabra en mayúsculas.
 */
package Primera;

public class Ejercicio075 {
    public static void main(String arg[]) {
        char frase[] = {' ','E', 'n', ' ', 'u', 'n', ' ', 'l', 'u', 'g', 'a', 'r', ' ', 'd', 'e', ' ', 'L', 'a', ' ', 'M', 'a', 'n', 'c', 'h', 'a'};
        int inicio , fin;
        inicio = fin = frase.length-1; 
       
        while(inicio > 0){
            while(frase[inicio] != ' ')
                inicio--;             
            frase[inicio+1] = Character.toUpperCase(frase[inicio+1]);
            frase[fin] = Character.toUpperCase(frase[fin]);
            fin = inicio = inicio -1; // Le paso a fin la posicion de inicio - 1 posicion 
        }
        System.out.println(frase);
    }    
}
