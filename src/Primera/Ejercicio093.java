/*
Division entera mediante restas con recursividad 
a -> dividendo
b -> divisor
 */
package Primera;

public class Ejercicio093 {
    public static void main(String arg[]) { 
        int resultado = dividir(7,2);
        System.out.println("Division entera de 7/2" + resultado);
    }
    public static int dividir(int a, int b){
        if(a < b )
            return 0;
        else
            return dividir(a-b, b) + 1;
    }    
}
