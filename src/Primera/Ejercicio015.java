/*
Mostrar por pantalla el elemento mayor del vector 
 */
package Primera;

public class Ejercicio015 {
    public static void main (String arg[]){
        int datos[] = {-17, -33, -4, -95, -170};
        int mayor = datos[0];
        for(int i=0; i < datos.length; i++)
            if(datos[i] > mayor)
                mayor = datos[i];
        System.out.printf("El mayor valor del vector es %d\n", mayor);
        
        int posMayor = 0;
        for(int i=1; i < datos.length; i++)
            if(datos[i] > datos[posMayor])
                posMayor = i;
        System.out.printf("El mayor es %d y se ubica en la posicion %d\n", datos[posMayor], posMayor);
    }
}
