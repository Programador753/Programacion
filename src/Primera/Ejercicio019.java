/*
Hacer un programa que muestre la media de los valores del vector.
 */
package Primera;

public class Ejercicio019 {
    public static void main(String arg[]){
        int datos[] = {10, -20, 30, -40, 50};
        int acum = 0;
        for(int i=0; i < datos.length; i++)
            acum += datos[i];
        
        System.out.printf("La media datos es %d\n", (acum /= datos.length));
    }    
}
