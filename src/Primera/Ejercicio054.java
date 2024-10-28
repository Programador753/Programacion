/*
Tenemos dos productos y guardados en la tabla kilos está lo que
se ha vendido de cada producto, cada día de la semana.
El vector de precios nos indica cuanto vale el kilo de cada producto.
Implementar un método que modifique la tabla, multiplicando sus elementos 
por el elemento del vector de precios correspondiente.
 */
package Primera;

public class Ejercicio054 {
    public static void main(String arg[]){
        int kilos[][] = {{5, 6, 9, 23, 7, 14, 0},
                        {16, 8, 4, 33, 15, 21, 2}
                        };
        int precios[] = {6, 7};
        
        multiplicar(kilos, precios);
        
        for(int i = 0; i < kilos.length; i++){
            System.out.println();
            for (int j = 0; j < kilos[i].length; j++)
                System.out.print(kilos[i][j] + "  ");
        }
    }
    public static void multiplicar(int kilos[][], int precios[]){
        for(int i = 0; i < kilos.length; i++)
            for (int j = 0; j < kilos[i].length; j++)
                kilos[i][j] *= precios[i];
    }
}
