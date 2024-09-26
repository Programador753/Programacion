/*
 Mostrar por pantalla el elemento mayor y menor del vector de enteros
 Un error en ejecucion es una excepcion
 */
package Primera;

public class Ejercicio016 {
    public static void main (String arg[]){
        int datos[] = {-17, -33, -4, -95, -170};
        int mayor = datos[0];
        int menor = datos[0];
        for(int i=1; i < datos.length; i++)
        {
            if(datos[i] > mayor)
                mayor = datos[i];
            if(datos[i] < menor)
                menor = datos[i];
        }
        System.out.printf("El valor mayor es %d y el menor es %d\n", mayor, menor);
        
        int posMayor = 0;
        int posMenor = 0;
        for(int i=1; i < datos.length; i++)
        {
            if(datos[i] > datos[posMayor])
                posMayor = i;
            if(datos[i] < datos[posMenor])
                posMenor = i;
        }
        System.out.printf("El mayor es %d y se ubica en la posicion %d y el menor es %d y se ubica en la posicion %d\n", datos[posMayor], posMayor, datos[posMenor], posMenor);
    }
}
