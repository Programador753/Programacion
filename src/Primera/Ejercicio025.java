/*
Sacar las tablas de multiplicar de los 10 primeros numeros 
 */
package Primera;

public class Ejercicio025 {
    public static void main(String arg[]) { 
        for(int j = 1; j < 10; j++){
            System.out.println("TABLA DEL " + j);
            for(int i = 1; i <= 10; i++ )
                System.out.printf("%d * %d = %d\n", j, i, (i*j));
            System.out.println();
        }
    }
}
