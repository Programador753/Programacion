/*
Mostrar por pantalla si un numero es par
 */
package Primera;

public class Ejercicio005 {
    public static void main (String arg[]){
        int x;
        x = 33;
        
        if((x % 2) == 0)
            System.out.println("El "+ x +" es PAR" );
        else
            System.out.println("El "+ x +" es IMPAR" ); 
    }  
}
