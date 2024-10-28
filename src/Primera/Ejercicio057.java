/*
Implementar un método que modifique los elementos de la tabla kilos,
de manera que multiplique cada uno de ellos por el multiplicador
si el elemento es menor que 10.
Mostrar por pantalla el contenido de kilos una vez modificado.
 */
package Primera;

public class Ejercicio057 {
    public static void main(String arg[]){
        int kilos[][] = {{5, 6, 9, 23, 7, 14, 0},
                        {16, 8, 4, 33, 15, 21, 2}
                        };
        int multiplicador = 5;
        modificar(kilos, multiplicador);
        for (int i = 0; i < kilos.length; i++){
            for(int j = 0; j < kilos[i].length; j++)
                 System.out.print(kilos[i][j] + "  ");
            System.out.println();
        }
    }
    public static void modificar(int k[][], int m){
        for (int i = 0; i < k.length; i++)
            for(int j = 0; j < k[i].length; j++)
                if (k[i][j] < 10)
                    k[i][j] *= m;
    }
}
