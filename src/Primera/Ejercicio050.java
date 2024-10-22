/*
Ordenar todos los vectores de la tabla utilizando la función ordenar.
 */
package Primera;

public class Ejercicio050 {
    public static void main(String arg[]){
        int salarios[][] = { {700, 900, 1300, 800, 790, 850},
                            {1000, 950, 1080, 1070, 1200, 1100},
                            {1300, 930, 1200, 1170, 1000, 1000},
                            {1500, 1950, 1880, 1978, 2200, 2100} 
                            };
        
        for (int i = 0; i < salarios.length; i++)
                ordenar(salarios[i]);
        
        for(int i = 0; i < salarios.length; i++){
            System.out.println();
            for (int j = 0; j < salarios[i].length; j++)
            System.out.print(salarios[i][j] + "  ");
        }
        System.out.println();
    }
    public static void ordenar(int v1[]){
        int inter;
        for(int j=0; j<v1.length-1; j++)
            for(int i=v1.length-1; i>j; i--)
                if(v1[i] <v1[i-1]){
                    inter = v1[i];
                    v1[i] = v1[i-1];
                    v1[i-1] = inter;
            }
    }
}
