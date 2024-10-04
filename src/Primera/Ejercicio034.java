/*
Mostrar por pantalla el título de la película y el día de la 
semana de mayor taquillaje.
Lo mismo con el menor.
 */
package Primera;

public class Ejercicio034 {
    public static void main(String arg[]){
        int salas[][] = {{10, 20, 30, 40, 50, 200, 180},
                            {50, 60, 70, 80, 80, 300, 198},
                            {90, 100, 110, 120, 130, 150, 120},
                            {9, 199, 150, 180, 13, 100, 190}};
        String peliculas[] = {"Joker", "Soy Nevenka", "Buffalo Kids", "Los destellos"};
        String dias[] = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sabado", "Domingo"};
        
        int filaMax = 0;
        int colMax = 0;
        int filaMin = 0;
        int colMin = 0;
        for(int i = 0; i < salas.length; i++)
            for(int j = 0; j < salas[i].length; j++){
                if (salas[i][j] > salas[filaMax][colMax]){
                    filaMax = i;
                    colMax = j;
                }
                if (salas[i][j] < salas[filaMin][colMin]){
                    filaMin = i;
                    colMin = j;
                }
            }
        System.out.printf("La pelicula mas taquillera fue %s con %d entradas vendidas el %s\n", peliculas[filaMax], salas[filaMax][colMax], dias[colMax]);
        System.out.printf("La pelicula menos taquillera fue %s con %d entradas vendidas el %s\n", peliculas[filaMin], salas[filaMin][colMin], dias[colMin]);           
    }    
}
