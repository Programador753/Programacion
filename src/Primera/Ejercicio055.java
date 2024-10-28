/*
Tenemos dos productos y guardados en la tabla kilos está lo que
se ha vendido de cada producto, cada día de la semana.
El vector de precios nos indica cuanto vale el kilo de cada producto.
Implementar un método que modifique la tabla, multiplicando sus elementos 
por el elemento del vector de precios correspondiente en una nueva tabla.
 */
package Primera;

public class Ejercicio055 {
    public static void main(String arg[]){
        int kilos[][] = {{5, 6, 9, 23, 7, 14, 0},
                        {16, 8, 4, 33, 15, 21, 2}
                        };
        int precios[] = {6, 7};
        int resultado[][] = new int[2][7]; // Instancio un vector bidimensional de 2 x 7.
        multiplicar(kilos, precios, resultado); // Llamo a la funcion multiplicar y le paso los paramentros.
        
        // Bucle para recorrer el vector resultado.
        for(int i = 0; i < resultado.length; i++){
            System.out.println(); // Salto de linea (Retorno de carro) 
            for (int j = 0; j < resultado[i].length; j++)
                System.out.print(resultado[i][j] + "  ");
        }
        
        System.out.println(); // Salto de linea para separa 
        
        for(int i = 0; i < kilos.length; i++){
            System.out.println();
            for (int j = 0; j < kilos[i].length; j++)
                System.out.print((multiplicar(kilos, precios)[i][j]) + "  "); 
                //Imprimo el vector resultado que nos devuelve la funcion multiplicar.
        }
        
        System.out.println(); // Salto de linea para separar del mensaje final. 
    }
    // Función a la que le paso los kilos, el precio y el vector bidimensional en el que ha de cargar los datos.
    public static void multiplicar(int kilos[][], int precios[], int resultado[][]){
        for(int i = 0; i < kilos.length; i++)
            for (int j = 0; j < kilos[i].length; j++)
                resultado[i][j] = precios[i]*kilos[i][j];
    }
    // Función a la que le paso los kilos y el precio y me devuelve mediante un return el vector resultado.
    public static int[][] multiplicar(int kilos[][], int precios[]){
        // Instancio vector bidimensional para el resultado.
        int resultado[][] = new int[2][7]; 
        for(int i = 0; i < kilos.length; i++)
            for (int j = 0; j < kilos[i].length; j++)
                resultado[i][j] = precios[i]*kilos[i][j];
        return resultado;
    }    
}
