/*
Mostrar por pantalla el resultado de la multiplicación de los 
elementos de cada fila de la tabla por el correspondiente de v1.
 */
package Primera;

public class Ejercicio028 {
    public static void main(String arg[]){
        int tabla[][] = {   {10, 20, -30, -40},
                            {50, 60, -70, 80},
                            {90, 100, -110, -120}};
        int v1[] = {2, 4, 6};
        
        for(int i=0; i < v1.length; i++){
            for(int j=0; j < tabla[i].length; j++)
                System.out.printf("%d  ", (tabla[i][j] * v1[i]));
            System.out.println();
            
        }
    }
}
