/*
Primer bucle (nº fijo de iteraciones)
int cont;
for( cont = 0 , cont < 10 , cont++ )
cont = cont + 1 => cont++
 */
package Primera;

public class Ejercicio008 {
    public static void main (String arg[]){
        int cont;
        for(cont = 0; cont < 10; cont++)
            System.out.println("Iteración : " + (cont +1));
            
    }
}
