/*
Intercambio de las diagonales principales
 */
package Primera;

public class Ejercicio040 {
    public static void main(String arg[]){
        int tabla1[][] = {
                            {1, 2, 3, 4},
                            {5, 6, 7, 8},
                            {9, 10, 11, 12},
                            {13, 14, 15, 16}
                         };
        int intercambio;
        
        for (int i = 0, j=tabla1.length-1; i < tabla1.length; i++, j--){
                intercambio = tabla1[i][j];
                tabla1[i][j] = tabla1[i][i];
                tabla1[i][i] = intercambio;            
        }
        
        /*
        for (int i = 0; i < tabla1.length; i++){
                intercambio = tabla1[i][tabla1.length-1-i];
                tabla1[i][tabla1.length-1-i] = tabla1[i][i];
                tabla1[i][i] = intercambio;            
        }
         */   
        for(int i = 0; i < tabla1.length; i++){
            for(int j = 0; j < tabla1[i].length; j++)
                System.out.printf("%d  ", tabla1[i][j]);
            System.out.println();
        }
    }
}
