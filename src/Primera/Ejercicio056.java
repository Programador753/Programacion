/*
Implementar un método que devuelva un vector en el que se hayan 
acumulado los kilos de cada producto.
Desde el programa principal mostrad, de cada producto, su nombre
y el número de kilos que se han vendido.
 */
package Primera;

public class Ejercicio056 {
    public static void main(String arg[]){
        int kilos[][] = {{5, 6, 9, 23, 7, 14, 0},
                        {16, 8, 4, 33, 15, 21, 2}
                        };
        String productos[] = {"Peras", "Manzanas"};
        int totales[] = totalKilos(kilos); // Creo y cargo el vector con el resultado.
        //Bucle para recorrer el vector productos.
        for(int i = 0; i < productos.length; i++) 
            System.out.printf("Se han vendido %d kg de %s\n",totales[i], productos[i]);
        
    }
    public static int[] totalKilos(int v[][]){
        int total[] = {0, 0};
        for (int i = 0; i < v.length; i++)
            for (int j = 0; j < v[i].length; j++)
                total[i] += v[i][j];
        return total;
    }
}
