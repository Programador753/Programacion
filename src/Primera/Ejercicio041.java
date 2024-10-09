/*
En la tabla de goles se guardan los que han metido los 5
futbolistas en las últimas 4 temporadas.
Mostrar por pantalla la media de goles de cada jugador.
No utilizar un vector auxiliar.
 */
package Primera;

public class Ejercicio041 {
    public static void main(String arg[]){
        int goles[][] = {
                            {18, 20, 13, 14, 23},
                            {15, 26, 7, 18, 13},
                            {19, 10, 11, 22, 30},
                            {13, 19, 15, 26, 9}
                        };
        String futbolistas[] = {"Halland", "Mbappé", "Grizzman","Yamal", "Williams"};
        double media;
        
        for(int i = 0; i < goles[0].length; i++){
            media = 0;
            for(int j = 0; j < goles.length; j++)
                media += goles[j][i];
        System.out.printf("La media de goles de %s es de %.2f goles \n", futbolistas[i], media/4);        
        }
    } 
}


