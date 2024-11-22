/*
Pasar un numero a binario usando recursividad
 */
package Primera;

public class Ejercicio096 {
    public static void main (String arg[]){
        int numero = 256809;
        
        binario(numero);
        System.out.println();
    }
    public static void binario (int numero){
        if(numero/2 == 0)
            System.out.print(numero%2);
        else{
            binario(numero/2);
            System.out.print(numero%2);
        }  
    }   
}
