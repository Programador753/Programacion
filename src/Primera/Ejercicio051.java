/*
Obtener las combinaciones de tantos elementos tomados de tantos en tantos.
Creando la funcion factorial y utilizándola.
 */
package Primera;

public class Ejercicio051 {
    public static void main(String arg[]){
        int a = 5;
        int b = 2;
        int resultado = (factorial(a)/(factorial(a-b)*factorial(b)));
        
        System.out.println(resultado);
        
    }
    public static int factorial(int numero){
        int acum = numero;
        for(int i = numero-1; i >0; i-- )
            acum *= i;
        return acum;
    }
    
}
