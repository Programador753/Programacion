/*
Un numero es primo si es divisible por si mismo o por el 1.
Realizar una funcion que reciba un entero positivo y devuelva si es primo o no.
 */
package Primera;

public class Ejercicio098 {
    public static void main(String arg[]){
       if(esPrimo(3))
           System.out.println("Es primo");
       else
           System.out.println("NO Es primo");
   }
    public static boolean esPrimo(int numero){
        for(int i = numero-1; i > 1; i--)
            if (numero % i == 0)
                return false;
        return true;
   }
}
