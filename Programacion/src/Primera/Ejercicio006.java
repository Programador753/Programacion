/*
Mostrar si un numero acaba en 5 o no
 */
package Primera;

public class Ejercicio006 {
    public static void main (String arg[]){
        int x;
        x = 305;
        if((x % 10) == 5)
            System.out.println("El "+ x +" acaba en 5" );
        else
            System.out.println("El "+ x +" no acaba en 5" ); 
    }
}
