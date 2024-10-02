/*
Mostrar por pantalla, de cada producto, los kilos que se han vendido en total.
 */
package Primera;

public class Ejercicio030 {
    public static void main(String arg[]){
        int kilos[][] = {   {10, 20, 30, 40, 50},
                            {50, 60, 70, 80, 80},
                            {90, 100, 110, 120, 30}};
        String []productos = {"Naranjas", "Manzanas", "Peras"};
        int acumProductos;
        for(int i=0; i < kilos.length; i++){
            acumProductos = 0;
            for(int j=0; j < kilos[i].length; j++)
                acumProductos += kilos[i][j];
            System.out.printf("Se han vendido %d kg de %s\n", acumProductos, productos[i] );
        }
    }
}
