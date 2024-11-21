/*
Reloj de de CuCo
a = a%12
 */
package Primera;

public class Ejercicio094 {
    public static void main (String arg[]){
        int resultado = campanadas(14);
        System.out.println("El total de campanadas es " + resultado);
    }
    public static int campanadas(int a){
        
        if(a == 1)
            return a;
        else
            if (a <= 12)
                return campanadas(a-1) + a;
            else
                if (a >= 24)
                    return 0;
                else
                    return campanadas(a-1) + (a%12);
    }  
}
