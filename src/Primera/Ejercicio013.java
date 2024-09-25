/*
Division entera, mediante restas.
 */
package Primera;

public class Ejercicio013 {
    public static void main (String arg[]){
        int divisor = 2;    
        int dividendo = 8;  
        int contador = 0;
        int numero = dividendo;
        while(numero >= divisor)
        {
            contador++;
            numero -=divisor;
        }
        System.out.printf(" %d dividido entre %d es %d y resto %d\n", dividendo, divisor, contador, numero );
    }
}
