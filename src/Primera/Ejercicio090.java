/*
Multiplicación mediante sumas con recursividad 
 */
package Primera;

public class Ejercicio090 {
    public static void main(String arg[]) { 
        int resultado = multiplicar(5,3);
        System.out.println("El resultado es " + resultado);
    }
    public static int multiplicar(int a, int b){
        if(b == 1)
            return a;
        else
            return multiplicar(a,b-1) + a;
    }
}
