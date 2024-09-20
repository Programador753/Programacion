/*
Multiplicacion mediante suma 
5 * 7 -> 5+5+5+5+5+5+5
 */
package Primera;

public class Ejercicio011 {
    public static void main (String arg[]){
        int numero = 5;
        int x = 7;
        int acom = 0;
        for(int cont = 1; cont <= x; cont++)          
            acom = acom + numero;
        System.out.println( numero + " * " + x + " = " + acom);
        
        acom = 0;
        for(int cont = x; cont >= 1; cont--)          
            acom += numero;
        System.out.println("El resultado es : " + acom);
    }
}
