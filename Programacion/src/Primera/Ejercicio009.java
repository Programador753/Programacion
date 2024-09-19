/*
Mostrar por pantalla la tabla del multiplicar de un numero
 */
package Primera;

public class Ejercicio009 {
    public static void main (String arg[]){
        int numero;
        numero = 5;
        for(int cont = 0; cont <= 10; cont++ )
            System.out.println(numero + " x " + cont + " = " + (numero * cont));
    }
}
