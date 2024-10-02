/*
Modificar el contenido de la tabla, de manera que cada elemento,
si es negativo se convierta en positivo y si es positivo se
multiplique por 2. Despues mostrar el contenido de la tabla.
 */
package Primera;

public class Ejercicio027 {
    public static void main(String arg[]){
        int tabla[][] = {   {10, 20, -30, -40},
                            {50, 60, -70, 80},
                            {90, 100, -110, -120}};
        
        for(int i = 0; i < tabla.length; i++)
            for(int j=0; j < tabla[i].length; j++)
            if(tabla[i][j] < 0 )
                tabla[i][j] *= -1;
            else
                tabla[i][j] *= 2;
        
        for(int i = 0; i < tabla.length; i++){
            for(int j=0; j < tabla[i].length; j++)
                System.out.printf("%d  ", tabla[i][j]);
            System.out.println();
        }
    }
}
