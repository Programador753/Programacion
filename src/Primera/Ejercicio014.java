/*
Acceso a vector mediante nombre[posicion del dato].
a) Declaración y manipulación de vectores.
b)Modificar el contenido de cada elemento del vector multiplicandolo por dos 
y mostrar como queda el vector.
 */
package Primera;

public class Ejercicio014 {
    public static void main (String arg[]){
        int datos[] = {17, 33, 4, 95,170};
        for(int i=0; i < datos.length; i++)
            System.out.printf("datos[%d] = %d\n", i, datos[i]);
        for(int i=0; i < datos.length; i++)
           datos[i] *= 2 ;
        System.out.println();
        for(int i=0; i < datos.length; i++)
            System.out.printf("datos[%d] = %d\n", i, datos[i]); 
        
    }
}
