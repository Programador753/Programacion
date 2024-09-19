/*
Multiplicacion mediante suma 
5 * 7 -> 5+5+5+5+5+5+5
 */
package Primera;

public class Ejercicio011 {
    public static void main (String arg[]){
        int numero = 5;
        int x = 7;
        int  acom = 0;
        for(int cont = 0; cont < x; cont++)          
            acom = acom + numero;
            System.out.println( numero + " x " + x + " = " + acom);                 
    }
}
