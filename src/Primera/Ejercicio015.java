/*
Mostrar por pantalla el elemento mayor del vector 
 */
package Primera;

public class Ejercicio015 {
    public static void main (String arg[]){
        int datos[] = {-170, -33, -400, -95, -170};
        int mayor = datos[0];
        for(int i=0; i < datos.length; i++)
            if(datos[i] > mayor)
                mayor = datos[i];
        System.out.printf("El mayor valor del vector es %d\n", mayor);
        
                        
    }
}
