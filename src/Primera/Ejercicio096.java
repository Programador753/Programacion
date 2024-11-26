/*
Pasar un numero a binario usando recursividad
 */
package Primera;

public class Ejercicio096 {
    public static void main (String arg[]){
        binario(19);
    }
    public static void binario (int numero){
        if(numero > 0){
            binario(numero/2);
            System.out.printf("%d",numero%2);
        }      
    }   
}
