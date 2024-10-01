/*
Mostrar por pantalla el resultado de multiplicar cada elemento de datos 
por cada uno de los elementos de multiplos.
 */
package Primera;

public class Ejercicio024 {
    public static void main(String arg[]) { 
        int datos[] = {10, 20, 30, 40, 50};
        int multiplos[] = {3, 5, 7};
        for(int j=0; j < multiplos.length; j++){
            for(int i=0; i <datos.length; i++)
                System.out.print((datos[i]* multiplos[j]) + " - ");
            System.out.println();
        }
    }
}
