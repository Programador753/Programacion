/*
Tenemos un bombo con 48 bolas tienes que sacarlas de manera aleatoria 
y guardarlas en una tabla, que luego mostrarás.
 */
package Segunda.Ejercicio04;

public class Ejecutable {
    public static final int FILAS = 6; // Constante estatica para FILAS
    public static final int COLUMNAS = 6; // Constante estatica para COLUMNAS
    public static void main(String arg[]){
        Bombo bombo = new Bombo(); // instancio el objeto Bombo
        int resultados[][] = new int [FILAS][COLUMNAS]; //  Instancio el vector que almacenara los resultados.
        for(int i = 0; i < resultados.length; i++)
            for (int j = 0; j < resultados[i].length; j++)
                resultados[i][j] = bombo.sacaBola(); // Cargo el vector con los valores de bola
        
        for(int i = 0; i < resultados.length; i++){
            for (int j = 0; j < resultados[i].length; j++)
                System.out.printf(" %d ", resultados[i][j]);
            System.out.println();
        }
    }
}
