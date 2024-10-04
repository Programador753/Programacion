/*
Mostrar por pantalla la película más taquillera y el número de 
entradas que han vendido.
Mostrar por pantalla la película menos taquillera y el número 
de entradas que ha vendido.
 */
package Primera;

public class Ejercicio033 {
    public static void main(String arg[]){
        int salas[][] = {{10, 20, 30, 40, 50, 200, 180},
                            {50, 60, 70, 80, 80, 300, 198},
                            {90, 100, 110, 120, 130, 150, 120},
                            {9, 199, 150, 180, 13, 100, 190}};
        String peliculas[] = {"Joker", "Soy Nevenka", "Buffalo Kids", "Los destellos"};
        int entradas[] = {0, 0, 0, 0};
        
        for(int i = 0; i < salas.length; i++)
            for(int j = 0; j < salas[i].length; j++)
                entradas[i] += salas[i][j];
        
        int posMin = 0;
        int posMax = 0;
        for(int i=0; i < entradas.length; i++){
            if(entradas[i] > entradas[posMin])
                posMax = i;
            if(entradas[i] < entradas[posMin])
                posMin = i;
        }
        System.out.printf("La pelicula mas taquillera fue %s con %d entradas vendidas\n", peliculas[posMax], entradas[posMax]);
        System.out.printf("La pelicula menos taquillera fue %s con %d entradas vendidas\n", peliculas[posMin], entradas[posMin] );        
    }
}
