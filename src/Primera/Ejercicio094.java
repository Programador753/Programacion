/*
Reloj de de CuCo
Contador de campanadas con recursividad y sin recursividad 
 */
package Primera;

public class Ejercicio094 {
    public static void main (String arg[]){
        int resultado = campanadas(24);
        System.out.println("El total de campanadas es " + resultado);
        
        int resultado2 = campanadas2(24);
        System.out.println("El total de campanadas es " + resultado2);
    }
    public static int campanadas(int hora){
        if (hora >= 24)
            return 0;
        else
            if(hora == 1)
                return 1;
            else
                if (hora > 12)
                    return campanadas(hora-1) + (hora-12);
                else
                    return campanadas(hora-1) + hora;
    }
    public static int campanadas2 (int hora){
        int acum = 0;
        for(int i = 1; i <= hora; i++)
            if (hora >= 24)
                return 0;
            else
                if(i > 12)
                    acum += i-12;
                else
                    acum += i;
        return acum;
    }
}
